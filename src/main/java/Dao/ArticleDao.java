package Dao;

import Model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    private static final String INSERT_Article_SQL = "INSERT INTO articles" + "  (nom,quantite, prix) VALUES "
            + " (?, ?, ?);";

    private static final String SELECT_Article_BY_ID = "select id,nom,quantite,prix from articles where id =?";
    private static final String SELECT_ALL_Articles = "select * from articles";
    private static final String DELETE_Article_SQL = "delete from articles where id = ?;";
    private static final String UPDATE_Article_SQL = "update articles set nom = ?,quantite= ?, prix =? where id = ?;";

    public ArticleDao() {
    }


    public static void inserArticle(Article article) throws SQLException {
        Connection connection = SingletonConnection.getConnection();
        try {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Article_SQL);
                preparedStatement.setString(1, article.getName());
                preparedStatement.setInt(2, article.getQuantite());
                preparedStatement.setDouble(3, article.getPrix());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static Article selectArticle(int id) {
        Article a= null;
        Connection connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement
                    (SELECT_Article_BY_ID);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                a=new Article();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("nom"));
                a.setQuantite(rs.getInt("quantite"));
                a.setPrix(rs.getDouble("prix"));

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return a;
    }
    public static List<Article> selectAllArticles() {
        List<Article> articles=new ArrayList<Article>();
        Connection connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps =connection.prepareStatement(SELECT_ALL_Articles);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Article a =new Article();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("nom"));
                a.setQuantite(rs.getInt("quantite"));
                a.setPrix(rs.getDouble("prix"));
                articles.add(a);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return articles;
    }

    public static Article updateArticle(Article a) {
        Connection connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement
                    (UPDATE_Article_SQL) ;
            ps.setString(1, a.getName());
            ps.setInt(2,a.getQuantite());
            ps.setDouble(3, a.getPrix());
            ps.setInt(4, a.getId());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return a;
    }
    public static void deleteArticle(int id) {
        Connection connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement
                    (DELETE_Article_SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
