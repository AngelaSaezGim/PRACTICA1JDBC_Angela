/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1Objetos;

import java.sql.Timestamp;

/**
 *
 * @author angsaegim
 */
public class Pedido {

    private int idPedido;
    private Timestamp fecha;
    private int numeroComanda;
    private int idCliente;
    private int idDireccion;

    public Pedido(int idPedido, Timestamp fecha, int numeroComanda, int idCliente, int idDireccion) {
        this.setIdPedido(idPedido);
        this.setFecha(fecha);
        this.setNumeroComanda(numeroComanda);
        this.setIdCliente(idCliente);
        this.setIdDireccion(idDireccion);
    }

    public Pedido(Timestamp fecha, int numeroComanda, int idCliente, int idDireccion) {
        this.setFecha(fecha);
        this.setNumeroComanda(numeroComanda);
        this.setIdCliente(idCliente);
        this.setIdDireccion(idDireccion);
    }

    public Pedido(int idPedido) {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

    public void setNumeroComanda(int numeroComanda) {
        this.numeroComanda = numeroComanda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    
     public String toString() {
        return "-> Pedido [" + idPedido + "] " + " Fecha del pedido = " + fecha + " | Numero Comanda = " + numeroComanda + " | Id cliente relacionado = " + idCliente + " | Direccion = " + idDireccion;
    }

}
