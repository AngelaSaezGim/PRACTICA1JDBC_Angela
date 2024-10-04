/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1Objetos;

/**
 *
 * @author angsaegim
 */
public class Cliente {
    
    private int idCliente;
    private double saldo;
    private double limiteCredito;
    private double descuento;
    
    public Cliente(int idCliente, double saldo, double limiteCredito, double descuento){
        this.setIdCliente(idCliente);
        this.setSaldo(saldo);
        this.setLimiteCredito(limiteCredito);
        this.setDescuento(descuento);
    }
    
    public Cliente(double saldo, double limiteCredito, double descuento){
        this.setSaldo(saldo);
        this.setLimiteCredito(limiteCredito);
        this.setDescuento(descuento);
    }
    
    public Cliente(int idCliente){
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
     @Override
    public String toString() {
        return "-> Cliente [" + idCliente + "] " + " Saldo = " + saldo + " | Limite Credito = " + limiteCredito + " | Descuento = " + descuento;
    }

}
