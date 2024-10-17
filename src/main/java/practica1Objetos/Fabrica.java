/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1Objetos;

/**
 *
 * @author angsaegim
 */
public class Fabrica {
    
    private int idFabrica;
    private String telefonoContacto;
    private int totalArticulos;
    
    
    public Fabrica(int idFabrica, String telefonoContacto, int totalArticulos){
        this.setIdFabrica(idFabrica);
        this.setTelefonoContacto(telefonoContacto);
        this.totalArticulos = 0;
    }
    
    public Fabrica(int idFabrica, int totalArticulos){
        this.setIdFabrica(idFabrica);
        this.setTelefonoContacto(telefonoContacto);
        this.totalArticulos = 0;
    }
    
     public Fabrica(String telefonoContacto){
        this.setTelefonoContacto(telefonoContacto);
        this.totalArticulos = 0;
    }
        
    public Fabrica(int idFabrica){
        
    }

    public int getIdFabrica() {
        return idFabrica;
    }

    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    
    public int getTotalArticulos() {
        return totalArticulos;
    }

    public void setTotalArticulos(int totalArticulos) {
        this.totalArticulos = totalArticulos;
    }
    
    public String toString() {
        return "-> Fabrica [" + idFabrica + "] " + " Telefono Contacto = " + telefonoContacto;
    }


    
    
}
