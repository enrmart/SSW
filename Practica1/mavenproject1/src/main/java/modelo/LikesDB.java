package modelo;
import java.sql.*;

public class LikesDB {
    public static int insert(Likes like) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        
        
        Connection connection = pool.getConnection();
         
        PreparedStatement ps = null;
        String query="INSERT INTO LIKES (Usuario,id_Piso) VALUES (?, ?)";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1,like.getUsuario());
            ps.setInt(2, like.getId_Piso());
            
            
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
    }
    }


    public static boolean likesExists(String Usuario,int id_Piso) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM LIKES L WHERE L.Usuario = ? and A.id_Piso=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Usuario);
            ps.setInt(2, id_Piso);
            

            rs = ps.executeQuery();
            boolean res = rs.next();
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    
    public static Likes selectLikes(String Usuario,int id_Piso) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Likes like= null;

        String query = "SELECT * FROM LIKES L WHERE L.Usuario = ? and A.id_Piso=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Usuario);
            ps.setInt(2, id_Piso);
            

            rs = ps.executeQuery();
            like= new Likes(rs.getString("Usuario"),rs.getInt("id_Piso"));
            
            
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return like;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return like;
        }
    }
public static void updateLikes(String usuario,String user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE Likes SET Usuario=? WHERE Usuario=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, usuario);
            

            rs = ps.executeQuery();
            
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
   
    
}
