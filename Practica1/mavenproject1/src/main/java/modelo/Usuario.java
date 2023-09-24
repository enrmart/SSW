package modelo;

public class Usuario {

    
    private String nombre;
    private String apellidos;
    private String telefono;
    private String usuario;
    private String contraseña;
    private String foto;
    private boolean administracion;
    private boolean estudiante;
    private boolean anunciante;

    public Usuario(String nombre, String apellidos, String telefono, String usuario, String contraseña) {
    
    
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.telefono = telefono;
    this.usuario = usuario;
    this.contraseña = contraseña;
    this.foto = "img/png-transparent-computer-icons-user-user-icon.png";
    this.administracion = false;
    this.estudiante = true;
    this.anunciante = false;
}
    
     // Getters

    

     public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getFoto() {
        return foto;
    }

    public boolean isAdministracion() {
        return administracion;
    }

    public boolean isEstudiante() {
        return estudiante;
    }

    public boolean isAnunciante() {
        return anunciante;
    }

    // Setters
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setAdministracion(boolean administracion) {
        this.administracion = administracion;
    }

    public void setEstudiante(boolean estudiante) {
        this.estudiante = estudiante;
    }

    public void setAnunciante(boolean anunciante) {
        this.anunciante = anunciante;
    }

}
