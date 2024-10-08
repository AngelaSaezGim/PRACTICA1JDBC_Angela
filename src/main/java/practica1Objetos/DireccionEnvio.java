/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1Objetos;

/**
 *
 * @author angsaegim
 */
public class DireccionEnvio {

    private int idDireccion;
    private int numero;
    private String calle;
    private String comuna;
    private String ciudad;
    private int idCliente; 

    public DireccionEnvio(int idDireccion, int numero, String calle, String comuna, String ciudad, int idCliente) {
        this.idDireccion = idDireccion;
        this.numero = numero;
        this.calle = calle;
        this.comuna = comuna;
        this.ciudad = ciudad;
        this.idCliente = idCliente;
    }
    
    public DireccionEnvio(int numero, String calle, String comuna, String ciudad, int idCliente) {
        this.numero = numero;
        this.calle = calle;
        this.comuna = comuna;
        this.ciudad = ciudad;
        this.idCliente = idCliente;
    }
    
     public DireccionEnvio(int idDireccion) {
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    @Override
    public String toString() {
        return "-> Direccion [" + idDireccion + "] " + " Numero = " + numero + " | Calle = " + calle + " | Comuna = " + comuna + " | Ciudad = " + ciudad + " | IdCliente " + idCliente;
    }

}
