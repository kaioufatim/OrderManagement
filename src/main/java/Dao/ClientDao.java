package Dao;

import Model.Article;
import Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    private static final String INSERT_Client_SQL = "INSERT INTO client" + "  (nom,prenom,adresse) VALUES "
            + " (?, ?, ?);";

    private static final String SELECT_Client_BY_ID = "select id,nom,prenom,adresse from client where id =?";
    private static final String SELECT_ALL_Clients = "select * from client";
    private static final String DELETE_Client_SQL = "delete from client where id = ?;";
    private static final String UPDATE_Client_SQL = "update client set nom = ?,prenom= ?, adresse =? where id = ?;";

    public ClientDao() {
    }

    public static void inserClient(Client client) throws SQLException {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Client_SQL);
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            preparedStatement.setString(3, client.getAdresse());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Client selectClient(int id) {
        Client c = null;
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement
                    (SELECT_Client_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Client();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAdresse(rs.getString("adresse"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public static List<Client> selectAllClients() {
        List<Client> clients = new ArrayList<Client>();
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_Clients);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client c = new Client();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAdresse(rs.getString("adresse"));
                clients.add(c);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clients;
    }
    public static Client updateClient(Client c) {
        Connection connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement
                    (UPDATE_Client_SQL) ;
            ps.setString(1, c.getNom());
            ps.setString(2,c.getPrenom());
            ps.setString(3, c.getAdresse());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }
    public static void deleteClient(int id) {
        Connection connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement
                    (DELETE_Client_SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}