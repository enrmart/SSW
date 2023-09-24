package modelo;
import java.io.Serializable;
import javax.servlet.*;
import javax.servlet.http.*;



public class Piso implements Serializable{
    private String calle;
    private String ciudad;
    private int numHab;
    private String pais;
    private int numBañ;
    private int superficie;
    private int Piso;
    private boolean ascensor;
    private boolean mascotas;
    private boolean fumar;
    private boolean calefaccion;
    private boolean internet;
    private boolean parking;
    private String fotos;
    private float precio;
    private String descripcion;
    private String anunciante;
    private int id_Piso;
    private boolean compartido;
    
    
    public Piso(String calle, String ciudad, int numHab, String pais, int superficie, int numBa, int Piso, boolean ascensor, boolean mascotas, boolean fumar, boolean calefaccion, boolean internet, boolean parking, String fotos,float precio,String descripcion, String usuario ,boolean compartido) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.numHab = numHab;
        this.pais = pais;
        this.superficie = superficie;
        this.numBañ = numBa;
        this.Piso = Piso;
        this.ascensor = ascensor;
        this.mascotas = mascotas;
        this.fumar = fumar;
        this.calefaccion = calefaccion;
        this.internet = internet;
        this.parking = parking;
        this.fotos = fotos;
        this.precio=precio;
        this.descripcion=descripcion;
        this.anunciante = usuario;
        this.compartido=compartido;
        
    }

    
//Getters
public float getPrecio() {
    return this.precio;
}

public String getDescripcion() {
    return this.descripcion;
}

public String getAnunciante() {
    return this.anunciante;
}

public int getId_Piso() {
    return id_Piso;
}

public String getCalle() {
    return calle;
}

public String getCiudad() {
    return ciudad;
}

public int getNumHab() {
    return numHab;
}

public String getPais() {
    return pais;
}

public int getNumBan() {
    return numBañ;
}

public int getSuperficie() {
    return superficie;
}

public int getPiso() {
    return Piso;
}

public boolean hasAscensor() {
    return ascensor;
}

public boolean allowsMascotas() {
    return mascotas;
}

public boolean allowsFumar() {
    return fumar;
}

public boolean hasCalefaccion() {
    return calefaccion;
}

public boolean hasInternet() {
    return internet;
}

public boolean hasParking() {
    return parking;
}

public String getFotos() {
    return fotos;
}

public Boolean isCompartido(){
    return compartido;
}





//Setters
public void setId_Piso(int id_Piso) {
    this.id_Piso = id_Piso;
}

public void setCalle(String calle) {
    this.calle = calle;
}

public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
}

public void setNumHab(int numHab) {
    this.numHab = numHab;
}

public void setPais(String pais) {
    this.pais = pais;
}

public void setNumBañ(int numBañ) {
    this.numBañ = numBañ;
}

public void setSuperficie(int superficie) {
    this.superficie = superficie;
}

public void setPiso(int piso) {
    this.Piso = piso;
}

public void setAscensor(boolean ascensor) {
    this.ascensor = ascensor;
}

public void setMascotas(boolean mascotas) {
    this.mascotas = mascotas;
}

public void setFumar(boolean fumar) {
    this.fumar = fumar;
}

public void setCalefaccion(boolean calefaccion) {
    this.calefaccion = calefaccion;
}

public void setInternet(boolean internet) {
    this.internet = internet;
}

public void setParking(boolean parking) {
    this.parking = parking;
}

public void setFotos(String fotos) {
    this.fotos = fotos;
}

public void setCompartido(boolean compartido) {
    this.compartido=compartido;
}
    
}
