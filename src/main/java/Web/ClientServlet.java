package Web;

import Dao.ClientDao;
import Model.Client;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet("/")
public class ClientServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;
        private ClientDao clientDao;

        public void init() {
        clientDao = new ClientDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action1 = request.getServletPath();
        try {
            switch (action1) {
                case "/Cnew":
                    showNewFormC(request, response);
                    break;
                case "/insertC":
                    insertClient(request, response);
                    break;
                case "/deleteC":
                    deleteClient(request, response);
                    break;
                case "/editC":
                    showEditFormC(request, response);
                    break;
                case "/updateC":
                    updateClient(request, response);
                    break;
                default:
                    listClient(request, response);
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
    private void listClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Client> listClient = ClientDao.selectAllClients();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("clientList.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewFormC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("clientForm.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditFormC(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client existingClient = ClientDao.selectClient(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("clientForm.jsp");
        request.setAttribute("client", existingClient);
        dispatcher.forward(request, response);

    }
    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        Client newClient = new Client(nom, prenom, adresse);
        ClientDao.inserClient(newClient);
        response.sendRedirect("listC");
    }
    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");


        Client book = new Client(id, nom, prenom, adresse);
        ClientDao.updateClient(book);
        response.sendRedirect("listC");
    }
    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ClientDao.deleteClient(id);
        response.sendRedirect("listC");

    }
}
