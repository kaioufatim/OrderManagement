package Web;

import Dao.ClientDao;
import Dao.CommandeDao;
import Model.Client;
import Model.Commande;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

//@WebServlet(name = "CommandeServlet", value = "/CommandeServlet")
//@WebServlet("/CommandesServlet")
@WebServlet("/")

public class CommandeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CommandeDao commandeDao;

    public void init() {
        commandeDao = new CommandeDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action1 = request.getServletPath();
        try {
            switch (action1) {
                case "/newCom":
                    showNewFormCom(request, response);
                    break;
                case "/insertCom":
                    insertCommande(request, response);
                    break;
//                default:
//                    listCommande(request, response);
//                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    private void showNewFormCom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("commandeForm.jsp");
        dispatcher.forward(request, response);
    }
    private void insertCommande(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

}
}
