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

    // Constructor
    public ArticuloFabrica(int idArticulo, int idFabrica, int existencias) {
        this.idArticulo = idArticulo;
        this.idFabrica = idFabrica;
        this.existencias = existencias;
    }
    
    public ArticuloFabrica(int existencias) {
        this.existencias = existencias;
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
    
    
    
}
