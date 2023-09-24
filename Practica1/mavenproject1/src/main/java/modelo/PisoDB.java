package modelo;
import java.sql.*;
import java.util.ArrayList;


public class PisoDB {

    public static int insert(Piso piso) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query="INSERT INTO Pisos (Calle,Ciudad,numHab,Pais,Superficie,numBa,Piso,Ascensor,Mascotas,Fumar,Calefaccion,Internet,Parking,Fotos,Precio,Descripcion,Anunciante,Compartido) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, piso.getCalle());
            ps.setString(2, piso.getCiudad());
            ps.setInt(3, piso.getNumHab());
            ps.setString(4, piso.getPais());
            ps.setInt(5, piso.getSuperficie());
            ps.setInt(6, piso.getNumBan());
            ps.setInt(7, piso.getPiso());
            ps.setBoolean(8, piso.hasAscensor());
            ps.setBoolean(9, piso.allowsMascotas());
            ps.setBoolean(10, piso.allowsFumar());
            ps.setBoolean(11, piso.hasCalefaccion());
            ps.setBoolean(12, piso.hasInternet());
            ps.setBoolean(13, piso.hasParking());
            ps.setString(14, piso.getFotos());
            ps.setFloat(15,piso.getPrecio());
            ps.setString(16,piso.getDescripcion());
            ps.setString(17,piso.getAnunciante());
            ps.setBoolean(18, piso.isCompartido());
          
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
    
    
    

    public static int setId(Piso piso) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id=0;
        String query="SELECT id_piso FROM pisos where Calle = ?  AND Ciudad = ? AND Pais = ?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, piso.getCalle());
            ps.setString(2, piso.getCiudad());
            ps.setString(3, piso.getPais());
            rs = ps.executeQuery();
            while (rs.next()) {
               id = Integer.parseInt(rs.getString("id_Piso"));
            }
            ps.close();
            pool.freeConnection(connection);
            return id;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
    }
    }
    
    
    //Comprobar si el piso existe
    public static boolean pisoExists(String calle,String ciudad,String pais) {
     if(selectPiso(calle,ciudad,pais)!=null){
         return false;
     }else{
         return true;
     }
      
    }


    public static Piso selectPiso(String calle,String ciudad,String pais) {
                ConnectionPool pool = ConnectionPool.getInstance();
                Piso piso= null;
                Connection connection = pool.getConnection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                String query = "SELECT * FROM Pisos P WHERE P.Calle = ?  AND P.Ciudad = ? AND P.Pais = ?";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setString(1, calle);
                    ps.setString(2, ciudad);
                    ps.setString(3, pais);
                    rs = ps.executeQuery();
                    
                    if (rs.next()) {
                        piso = new Piso(rs.getString("Calle"),rs.getString("Ciudad"),rs.getInt("numHab"),rs.getString("Pais"),rs.getInt("Superficie"),rs.getInt("numBa"),rs.getInt("Piso"),rs.getBoolean("Ascensor"),rs.getBoolean("Mascotas"),rs.getBoolean("Fumar"),rs.getBoolean("Calefaccion"),rs.getBoolean("Internet"),rs.getBoolean("Parking"),rs.getString("Fotos"),rs.getFloat("Precio"),rs.getString("Descripcion"),rs.getString("Anunciante"),rs.getBoolean("Compartido"));
                        
                    }
                    rs.close();
                    ps.close();
                    pool.freeConnection(connection);
                    
                    return piso;
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                } 
    }
    
    public static Piso selectPiso(int id_Piso) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Piso piso= null;
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Pisos P WHERE P.id_Piso = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_Piso);
           
            rs = ps.executeQuery();
            
            if (rs.next()) {
                piso = new Piso(rs.getString("Calle"),rs.getString("Ciudad"),rs.getInt("numHab"),rs.getString("Pais"),rs.getInt("Superficie"),rs.getInt("numBa"),rs.getInt("Piso"),rs.getBoolean("Ascensor"),rs.getBoolean("Mascotas"),rs.getBoolean("Fumar"),rs.getBoolean("Calefaccion"),rs.getBoolean("Internet"),rs.getBoolean("Parking"),rs.getString("Fotos"),rs.getFloat("Precio"),rs.getString("Descripcion"),rs.getString("Anunciante"), rs.getBoolean("Compartido"));
           
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return piso;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
} 
    
     public static ArrayList<Piso> selectPisoBuscador(String pais, String ciudad, int numHab, int numBa, double precio, boolean ascensor,boolean fumar,boolean mascotas, boolean calef,boolean internet,boolean parking,boolean compartido, String lupa) {
        ConnectionPool pool = ConnectionPool.getInstance();
        ArrayList<Piso> pisos;
        pisos = new ArrayList<Piso>();
        Piso piso= null;
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM PISOS P "
                + "WHERE p.Pais LIKE CONCAT('%', COALESCE(?, ''), '%') "
                + "and p.Ciudad LIKE CONCAT('%', COALESCE(?, ''), '%') "
                + "and p.numHab = COALESCE(?,p.numHab) "
                + "and p.numBa = COALESCE(?,p.numBa) "
                + "and p.Precio <= ? "
                + "and (p.Ascensor=? or not ?) "
                + "and (p.Fumar=? or not ?) "
                + "and (p.Mascotas=? or not ?) "
                + "and (p.Calefaccion=? or not ?) "
                + "and (p.Internet=? or not ?) "
                + "and (p.Parking=? or not ?) "
                + "and (p.Compartido=? or not ?) "
                + "and p.Calle LIKE CONCAT('%', COALESCE(?, ''), '%') "
                + "and p.id_Piso not in (SELECT A.id_Piso FROM alquiler A)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, pais);
            ps.setString(2, ciudad);
            if(numHab==-1){
            ps.setString(3, null); 
            }else{
             ps.setInt(3, numHab);    
            }
            if(numBa==-1){
            ps.setString(4, null);    
            }else{
            ps.setInt(4, numBa);    
            }
            ps.setFloat(5,(float)precio);   
            ps.setBoolean(6,ascensor);
            ps.setBoolean(7,ascensor);
            ps.setBoolean(8,fumar);
            ps.setBoolean(9,fumar);
            ps.setBoolean(10,mascotas);
            ps.setBoolean(11,mascotas);
            ps.setBoolean(12,calef);
            ps.setBoolean(13,calef);
            ps.setBoolean(14,internet);
            ps.setBoolean(15,internet);
            ps.setBoolean(16,parking);
            ps.setBoolean(17,parking);
            ps.setBoolean(18,compartido);
            ps.setBoolean(19,compartido);
            ps.setString(20, lupa);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                piso = new Piso(rs.getString("Calle"),rs.getString("Ciudad"),rs.getInt("numHab"),rs.getString("Pais"),rs.getInt("Superficie"),rs.getInt("numBa"),rs.getInt("Piso"),rs.getBoolean("Ascensor"),rs.getBoolean("Mascotas"),rs.getBoolean("Fumar"),rs.getBoolean("Calefaccion"),rs.getBoolean("Internet"),rs.getBoolean("Parking"),rs.getString("Fotos"),rs.getFloat("Precio"),rs.getString("Descripcion"),rs.getString("Anunciante"),rs.getBoolean("Compartido") );
                pisos.add(piso);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return pisos;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
}
     
     public static ArrayList<Piso> selectPisoSinFiltro() {
        ConnectionPool pool = ConnectionPool.getInstance();
        ArrayList<Piso> pisos;
        pisos = new ArrayList<Piso>();
        Piso piso= null;
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM pisos P WHERE P.id_Piso not in (SELECT A.id_Piso FROM alquiler A)";
        try {
           ps = connection.prepareStatement(query);
           rs = ps.executeQuery();
            
            while (rs.next()) {
                piso = new Piso(rs.getString("Calle"),rs.getString("Ciudad"),rs.getInt("numHab"),rs.getString("Pais"),rs.getInt("Superficie"),rs.getInt("numBa"),rs.getInt("Piso"),rs.getBoolean("Ascensor"),rs.getBoolean("Mascotas"),rs.getBoolean("Fumar"),rs.getBoolean("Calefaccion"),rs.getBoolean("Internet"),rs.getBoolean("Parking"),rs.getString("Fotos"),rs.getFloat("Precio"),rs.getString("Descripcion"),rs.getString("Anunciante"),rs.getBoolean("Compartido") );
                pisos.add(piso);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return pisos;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
}
 public static void updatePisos(String usuario, String user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Piso piso= null;
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE Pisos SET Anunciante=? WHERE Anunciante=?";
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