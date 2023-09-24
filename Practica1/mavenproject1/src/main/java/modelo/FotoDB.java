/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;


public class FotoDB implements Serializable{
    public static int insertFoto(Foto foto) {
        ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            PreparedStatement ps = null;
            String query="INSERT INTO Fotos (Nombre,Usuario,id_Piso,imagen) VALUES (?, ?, ?, ?)";
            try {
                ps = connection.prepareStatement(query);

                ps.setString(1, foto.getNombreArchivo());
                ps.setString(2, foto.getUsuario());
                ps.setInt(3, foto.getIdPiso());
                ps.setBytes(4, foto.getContenido());
               

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
    
    public static ArrayList<Foto> selectFoto(int id_Piso) {
        
                ConnectionPool pool = ConnectionPool.getInstance();
                Foto foto;
                ArrayList<Foto> fotos=new ArrayList<>();
                Connection connection = pool.getConnection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                String query = "SELECT * FROM Fotos WHERE id_Piso = ?";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setInt(1, id_Piso);
                    rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        
                        foto = new Foto(rs.getString("Nombre"),rs.getBytes("imagen"),rs.getString("Usuario"),rs.getInt("id_Piso"));
                        String imagenBase64 = Base64.getEncoder().encodeToString(foto.getContenido());                         
                        foto.setContenidoBase64(imagenBase64);
                        fotos.add(foto);
                    }
                    rs.close();
                    ps.close();
                    pool.freeConnection(connection);
                     
                    return fotos;
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                } 
    }
    public static int setId(Foto foto) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id=0;
        String query="SELECT id_foto FROM fotos where id_Piso = ? AND Nombre = ?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setInt(1,foto.getIdPiso());
            ps.setString(2, foto.getNombreArchivo());
        
            rs = ps.executeQuery();
            while (rs.next()) {
               id = Integer.parseInt(rs.getString("id_Foto"));
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
       public static void updateFotos(String usuario,String user) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query="UPDATE Fotos SET Usuario=? WHERE Usuario=?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1,user);
            ps.setString(2, usuario);
        
            rs = ps.executeQuery();
            
            ps.close();
            
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
           
    }
    }
}
