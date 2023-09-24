package modelo;

public class Likes {

    private String usuario;
    private int id_Piso;



    public Likes (String user,int id){
        this.usuario=user;
        this.id_Piso=id;
    }
    

public String getUsuario(){
    return usuario;
}

public int getId_Piso(){
    return id_Piso;
}

public void setUsuario(String usuario){
    this.usuario=usuario;
}

public void setId_Piso(int id_Piso){
    this.id_Piso=id_Piso;
}
}
