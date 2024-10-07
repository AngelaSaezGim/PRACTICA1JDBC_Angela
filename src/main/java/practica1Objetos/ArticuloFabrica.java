/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1Objetos;

/**
 *
 * @author angsaegim
 */
public class ArticuloFabrica {
    
    private int idArticulo;
    private int idFabrica;  
    private int existencias;
    private double precio;

    // Constructor
    public ArticuloFabrica(int idArticulo, int idFabrica, int existencias, double precio) {
        this.idArticulo = idArticulo;
        this.idFabrica = idFabrica;
        this.existencias = existencias;
        this.precio = precio;
    }
    
    public ArticuloFabrica(int idFabrica, int existencias, double precio) {
        this.idFabrica = idFabrica;
        this.existencias = existencias;
        this.precio = precio;
    }
    
    public ArticuloFabrica(int idArticulo, int idFabrica) {
        
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdFabrica() {
        return idFabrica;
    }

    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
     @Override
    public String toString() {
        return "-> ArticuloFabrica = Id del articulo " + idArticulo + " | " + " idFabrica = " + idFabrica + " | Existencias = " + existencias + " | Precio = " + precio;
    }
    
}
