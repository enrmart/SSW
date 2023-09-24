package modelo;

import java.sql.Date;


public class Alquiler {

        private Date Fecha_Fin;
        private float Valoracion;
        private String Comentario;
        private String Alquilado;
        private int id_Piso;



public Alquiler(Date Fecha_Fin,String Alquilado,int id_Piso){
    
    this.Fecha_Fin=Fecha_Fin;
    Valoracion=(float) 0.0;
    Comentario=null;
    this.Alquilado=Alquilado;
    this.id_Piso=id_Piso;

}
// Getters

public Date getFecha_Fin() {
    return Fecha_Fin;
}

public float getValoracion() {
    return Valoracion;
}

public String getComentario() {
    return Comentario;
}

public String getAlquilado() {
    return Alquilado;
}

public int getId_Piso() {
    return id_Piso;
}

// Setters


public void setFecha_Fin(Date Fecha_Fin) {
    this.Fecha_Fin = Fecha_Fin;
}

public void setValoracion(float Valoracion) {
    this.Valoracion = Valoracion;
}

public void setComentario(String Comentario) {
    this.Comentario = Comentario;
}

public void setAlquilado(String Alquilado) {
    this.Alquilado = Alquilado;
}

public void setId_Piso(int id_Piso) {
    this.id_Piso = id_Piso;
}


    
}
