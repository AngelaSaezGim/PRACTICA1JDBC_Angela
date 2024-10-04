/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1Objetos;

/**
 *
 * @author angsaegim
 */
public class LineaPedido {
    
        
    private int idLineaPedido;
    private int idPedido;
    private int idArticulo; 
    private int cantidad;

    public LineaPedido(int idLineaPedido, int idPedido, int idArticulo, int cantidad) {
        this.idLineaPedido = idLineaPedido;
        this.idPedido = idPedido;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }
    
    public LineaPedido(int idPedido, int idArticulo, int cantidad) {
        this.idPedido = idPedido;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }
    
    public LineaPedido(int idLineaPedido) {
    }

    public int getIdLineaPedido() {
        return idLineaPedido;
    }

    public void setIdLineaPedido(int idLineaPedido) {
        this.idLineaPedido = idLineaPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
     public String toString() {
        return "-> Linea Pedido [" + idLineaPedido + "] " + " Id del pedido relacionado = " + idPedido + " | Id del articulo relacionado = " + idArticulo + " | Cantidad = " + cantidad;
    }
    
}
