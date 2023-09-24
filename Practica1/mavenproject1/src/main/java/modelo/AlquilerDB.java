package modelo;
import java.sql.*;

public class AlquilerDB {

    public static int insert(Alquiler alquiler) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        
        
        Connection connection = pool.getConnection();
         
        PreparedStatement ps = null;
        String query="INSERT INTO ALQUILER (Fecha_Fin,Valoracion,Comentario,Alquilado,id_Piso) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);

            ps.setDate(1, alquiler.getFecha_Fin());
            ps.setFloat(2, (float) 5.0);
            ps.setString(3, null);
            ps.setString(4, alquiler.getAlquilado());
            ps.setInt(5, alquiler.getId_Piso());
            
            
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

    public static boolean alquilerExists(String Alquilado,int id_Piso, Date Fecha_Fin) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ALQUILER A WHERE A.FechaFin = ? and A.Alquilado = ? and A.id_Piso=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, Fecha_Fin);
            ps.setString(2, Alquilado);
            ps.setInt(3, id_Piso);

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

   
    
    public static Alquiler selectAlquiler(String Alquilado,int id_Piso, Date Fecha_Fin) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Alquiler alq= null;

        String query = "SELECT * FROM ALQUILER A WHERE A.FechaFin = ? and A.Alquilado = ? and A.id_Piso=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, Fecha_Fin);
            ps.setString(2, Alquilado);
            ps.setInt(3, id_Piso);

            rs = ps.executeQuery();
            alq= new Alquiler(rs.getDate("Fecha_Fin"),rs.getString("Alquilado"),rs.getInt("id_Piso"));
            
            alq.setComentario(rs.getString("Comentario"));
            alq.setValoracion(rs.getFloat("Valoracion"));
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return alq;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return alq;
        }
    }
    
    

    public static boolean cambiarValoracion(String Alquilado,int id_Piso, Date Fecha_Fin,float Valoracion){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE AQUILER A SET A.Valoracion = ? WHERE A.FechaFin = ? and A.Alquilado = ? and A.id_Piso=?";
        if (alquilerExists(Alquilado, id_Piso, Fecha_Fin)){

            try{
                ps = connection.prepareStatement(query);
                ps.setFloat(1, Valoracion);
                ps.setDate(2, Fecha_Fin);
                ps.setString(3, Alquilado);
                ps.setInt(4, id_Piso);
    
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
        else{
            return false;
        }
        
       
    }


    public static boolean cambiarComentario(String Alquilado,int id_Piso, Date Fecha_Fin,String Comentario){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE AQUILER A SET A.Comentario = ? WHERE A.FechaFin = ? and A.Alquilado = ? and A.id_Piso=?";
        if (alquilerExists(Alquilado, id_Piso, Fecha_Fin)){

            try{
                ps = connection.prepareStatement(query);
                ps.setString(1, Comentario);
                ps.setDate(2, Fecha_Fin);
                ps.setString(3, Alquilado);
                ps.setInt(4, id_Piso);
    
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
        else{
            return false;
        }
        
        
        
        
       
    }
      public static void updateAlquiler(String usuario,String user){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE ALQUILER A SET A.Alquilado = ? WHERE A.Alquilado = ?";
        

            try{
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
