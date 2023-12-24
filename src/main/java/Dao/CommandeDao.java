package Dao;

import Model.Client;
import Model.Commande;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Dao.ClientDao.selectClient;

public class CommandeDao {
    private static final String INSERT_Commandes_SQL = "INSERT INTO commande1" + "  (id_client,etat,date) VALUES "
            + " (?, ?, ?);";
    private static final String SELECT_ALL_Commandes = "select * from commande1";


    public static void insertCommande(Commande commande) throws SQLException {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Commandes_SQL);
            preparedStatement.setInt(1, commande.getClient().getId());
            preparedStatement.setString(2, commande.getEtat());
            preparedStatement.setDate(3, Date.valueOf(commande.getDate()));
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static List<Commande> selectAllCommandes() {
        List<Commande> commandes = new ArrayList<Commande>();
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_Commandes);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String etat = rs.getString("etat");
                int clientId = rs.getInt("id_client");
                LocalDate date = rs.getDate("date").toLocalDate();

                // Assume you have a method to get a client by ID
                Client client = selectClient(clientId);


                Commande commande = new Commande(id, etat, client, date);
                commandes.add(commande);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return commandes;
    }
}
