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
    
    public Fabrica(int idFabrica, String telefonoContacto){
        this.setIdFabrica(idFabrica);
        this.setTelefonoContacto(telefonoContacto);
    }
    
     public Fabrica(String telefonoContecto){
        this.setTelefonoContacto(telefonoContacto);
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
    
    
    
}
