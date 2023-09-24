package modelo;
import java.sql.*;


public class UsuarioDB {

    public static int insert(Usuario user) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        
        
        Connection connection = pool.getConnection();
         
        PreparedStatement ps = null;
        String query="INSERT INTO USUARIOS (Nombre,Apellidos,Telefono,Usuario,Contrasenna,Foto,Administracion,Estudiante,Anunciante) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getTelefono());
            ps.setString(4, user.getUsuario());
            ps.setString(5, user.getContraseña());
            ps.setString(6, user.getFoto());
            ps.setBoolean(7, user.isAdministracion());
            ps.setBoolean(8, user.isEstudiante());
            ps.setBoolean(9, user.isAnunciante());
            
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
    public static int update(Usuario user,String usuario) throws SQLException {
        int res;
        ConnectionPool pool = ConnectionPool.getInstance();
        
        
        Connection connection = pool.getConnection();
         
        PreparedStatement ps = null;
        
        if(!usuarioExists(user.getUsuario())){
            insert(user);
            FotoDB.updateFotos(usuario,user.getUsuario());
            PisoDB.updatePisos(usuario,user.getUsuario());
            LikesDB.updateLikes(usuario,user.getUsuario());
            AlquilerDB.updateAlquiler(usuario,user.getUsuario());
            
            
            deleteUser(usuario);
            
            return 0;
            
            
        }else if(usuario.equals(user.getUsuario())){
        String query="UPDATE USUARIOS SET Nombre=?,Apellidos=?,Telefono=?,Usuario=?,Contrasenna=? WHERE usuario=? ";

        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getTelefono());
            ps.setString(4, user.getUsuario());
            ps.setString(5, user.getContraseña());
            ps.setString(6, user.getUsuario());
            
            res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return 0;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
    }
        }else{return -1;}
      
    }

    public static boolean usuarioExists(String Usuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT usuario FROM Usuarios WHERE usuario = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Usuario);
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

    public static boolean coincide(String Usuario,String Contraseña){
        boolean coincide = false;
        if(usuarioExists(Usuario)){
            Usuario u = selectUser(Usuario);
            if(u.getContraseña().equals(Contraseña)){
                coincide=true;
            }
        }
        return coincide;
    }
    
    public static Usuario selectUser(String Usuario) {
                ConnectionPool pool = ConnectionPool.getInstance();
                Connection connection = pool.getConnection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                String query = "SELECT * FROM Usuarios WHERE usuario = ?";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setString(1, Usuario);
                    rs = ps.executeQuery();
                    Usuario user = null;
                    if (rs.next()) {
                        user = new Usuario(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("telefono"),rs.getString("usuario"),rs.getString("contrasenna"));
                   
                    }
                    rs.close();
                    ps.close();
                    pool.freeConnection(connection);
                    return user;
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                } 
    } 
    public static void deleteUser(String Usuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        PreparedStatement ps5 = null;
        ResultSet rs = null;
        
        if (!Usuario.equals("admin1")){
            
            
            String query1 = "DELETE FROM PISOS  WHERE Anunciante=?";
            String query2 = "DELETE FROM USUARIOS  WHERE Usuario=?";
            String query3 = "DELETE FROM FOTOS  WHERE Usuario=?";
            String query4 = "DELETE FROM LIKES  WHERE Usuario=?";
            String query5 = "DELETE FROM ALQUILER  WHERE Alquilado=?";
        try {
            ps4 = connection.prepareStatement(query5);
            ps5 = connection.prepareStatement(query4);
            ps3 = connection.prepareStatement(query3);
            ps1 = connection.prepareStatement(query1);
            ps2 = connection.prepareStatement(query2);
            
            
            ps5.setString(1, Usuario);
            ps4.setString(1, Usuario);
            ps3.setString(1, Usuario);
            ps1.setString(1, Usuario);
            ps2.setString(1, Usuario);
            
            
            rs = ps4.executeQuery();
            rs = ps5.executeQuery();
            rs = ps3.executeQuery();
            rs = ps1.executeQuery();
            rs = ps2.executeQuery();
            
            rs.close();
            ps5.close();
            ps4.close();
            ps3.close();
            ps1.close();
            ps2.close();
            pool.freeConnection(connection);
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
            
        }
        
    }
    
    
}