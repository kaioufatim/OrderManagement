package Web;

import Dao.ArticleDao;
import Model.Article;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet(name = "ArticleServlet", value = "/ArticleServlet")
//@WebServlet("/")

public class ArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArticleDao articleDao;
    public void init() {
        articleDao = new ArticleDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertArticle(request, response);
                    break;
                case "/delete":
                    deleteArticle(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateArticle(request, response);
                    break;
                default:
                    listArticle(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
    private void listArticle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Article> listArticle = ArticleDao.selectAllArticles();
        request.setAttribute("listArticle", listArticle);
        RequestDispatcher dispatcher = request.getRequestDispatcher("articleList.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("articleForm.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Article existingArticle = ArticleDao.selectArticle(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("articleForm.jsp");
        request.setAttribute("article", existingArticle);
        dispatcher.forward(request, response);

    }
    private void insertArticle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        Double prix = Double.parseDouble(request.getParameter("prix"));
        Article newArticle = new Article(name, quantite, prix);
        ArticleDao.inserArticle(newArticle);
        response.sendRedirect("list");
    }
    private void updateArticle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        Double prix = Double.parseDouble(request.getParameter("prix"));


        Article book = new Article(id, name, quantite, prix);
        ArticleDao.updateArticle(book);
        response.sendRedirect("list");
    }
    private void deleteArticle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ArticleDao.deleteArticle(id);
        response.sendRedirect("list");

    }






}
