/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class filtro {
    private String lupa;
    private String ciudad;
    private String pais;
    private String numHab;
    private String numBa;
    private String precio;
    private boolean ascensor;
    private boolean mascotas;
    private boolean fumar;
    private boolean calefaccion;
    private boolean internet;
    private boolean parking;
    private boolean compartido;
    
    // Constructor
    public filtro(String pais,String ciudad, String numHab,
                   String numBa, String precio, boolean ascensor,
                   boolean mascotas, boolean fumar, boolean calefaccion,
                   boolean internet, boolean parking, boolean compartido,String lupa) {
        
        setLupa(lupa);
        setCiudad(ciudad);
        setPais(pais);
        setNumBa(numBa);
        setNumHab(numHab);
        setPrecio(precio);
        this.ascensor = ascensor;
        this.mascotas = mascotas;
        this.fumar = fumar;
        this.calefaccion = calefaccion;
        this.internet = internet;
        this.parking = parking;
        this.compartido = compartido;
    }
    public String getLupa() {
        return lupa;
    }
    public void setLupa(String lupa) {
        if (lupa==null){
            this.lupa="";
        }else{
         this.lupa = lupa;   
        }
        
    }

    // Getter y Setter de ciudad
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        if (ciudad==null){
            this.ciudad="";
        }else{
         this.ciudad = ciudad; 
        }
        
    }

    // Getter y Setter de pais
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        if (pais==null){
            this.pais="";
        }else{
            this.pais = pais;
        }

    }

    // Getter y Setter de numHab
    public String getNumHab() {
        return numHab;
    }
    public void setNumHab(String numHab) {
        if (numHab==null){
            this.numHab="";
        }else{
            this.numHab = numHab;
        }
        
        
    }

    // Getter y Setter de numBa
    public String getNumBa() {
        return numBa;
    }
    public void setNumBa(String numBa) {
        if (numBa==null){
            this.numBa="";
        }else{
            this.numBa = numBa;
        }
        
    }

    // Getter y Setter de precio
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        if (precio==null){
            this.precio="";
        }else{
         this.precio = precio;
        }
        
    }

    // Getter y Setter de ascensor
    public boolean isAscensor() {
        return ascensor;
    }
    public void setAscensor(boolean ascensor) {
        this.ascensor = ascensor;
    }

    // Getter y Setter de mascotas
    public boolean isMascotas() {
        return mascotas;
    }
    public void setMascotas(boolean mascotas) {
        this.mascotas = mascotas;
    }

    // Getter y Setter de fumar
    public boolean isFumar() {
        return fumar;
    }
    public void setFumar(boolean fumar) {
        this.fumar = fumar;
    }

    // Getter y Setter de calefaccion
    public boolean isCalefaccion() {
        return calefaccion;
    }
    public void setCalefaccion(boolean calefaccion) {
        this.calefaccion = calefaccion;
    }

    // Getter y Setter de internet
    public boolean isInternet() {
        return internet;
    }
    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    // Getter y Setter de parking
    public boolean isParking() {
        return parking;
    }
    public void setParking(boolean parking) {
        this.parking = parking;
    }

    // Getter y Setter de compartido
    public boolean isCompartido() {
        return compartido;
    }
    public void setCompartido(boolean compartido) {
        this.compartido = compartido;
    }
    
}
