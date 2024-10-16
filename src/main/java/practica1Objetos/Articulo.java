/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1Objetos;

/**
 *
 * @author angsaegim
 */
public class Articulo {

    private int idArticulo;
    private String descripcion;

    public Articulo(int idArticulo, String descripcion) {
        this.setIdArticulo(idArticulo);
        this.setDescripcion(descripcion);
    }

    public Articulo(String descripcion) {
        this.setDescripcion(descripcion);
    }

    public Articulo(int idArticulo) {
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "-> Articulo [" + idArticulo + "] " + descripcion;
    }

}
