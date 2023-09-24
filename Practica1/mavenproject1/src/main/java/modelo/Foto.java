/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Base64;


public class Foto implements Serializable {
  private String nombreArchivo;
  private byte[] contenido;
  private int idPiso;
  private String usuario;
  private int id_foto;
  private String contenidoBase64;

  // Constructor
  public Foto(String nombreArchivo, byte[] contenido, String usuario,int id_piso) {
    this.nombreArchivo = nombreArchivo;
    this.contenido = contenido;
    this.usuario=usuario;
    idPiso = id_piso;
  }

  // Getters y Setters
  public String getNombreArchivo() {
    return nombreArchivo;
  }

  public void setNombreArchivo(String nombreArchivo) {
    this.nombreArchivo = nombreArchivo;
  }

  public byte[] getContenido() {
    return contenido;
  }

  public void setContenido(byte[] contenido) {
    this.contenido = contenido;
  }
  
  public int getIdPiso() {
    return idPiso;
  }

  public void setIdPiso(int idPiso) {
    this.idPiso = idPiso;
  }
  
  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
  public int getIdFoto() {
    return id_foto;
  }

  public void setIdFoto(int id_foto) {
    this.id_foto = id_foto;
  }
  
  
  public String getContenidoBase64() {
    return contenidoBase64;
  }

  public void setContenidoBase64(String contenidoBase64) {
    this.contenidoBase64 = contenidoBase64;
  }
  
}

