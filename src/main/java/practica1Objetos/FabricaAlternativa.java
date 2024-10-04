/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1Objetos;

/**
 *
 * @author angsaegim
 */
public class FabricaAlternativa {

    private int idFabricaPrincipal;
    private int idFabricaAlternativa;
    
    // Constructor
    public FabricaAlternativa(int idFabricaPrincipal, int idFabricaAlternativa) {
        this.idFabricaPrincipal = idFabricaPrincipal;
        this.idFabricaAlternativa = idFabricaAlternativa;
    }

    public int getIdFabricaPrincipal() {
        return idFabricaPrincipal;
    }

    public void setIdFabricaPrincipal(int idFabricaPrincipal) {
        this.idFabricaPrincipal = idFabricaPrincipal;
    }

    public int getIdFabricaAlternativa() {
        return idFabricaAlternativa;
    }

    public void setIdFabricaAlternativa(int idFabricaAlternativa) {
        this.idFabricaAlternativa = idFabricaAlternativa;
    }
    
    public String toString() {
        return "-> Fabrica Alternativa =  Id Fabrica Principal [" + idFabricaPrincipal + "] " + " | Id Fabrica Alternativa = [" + idFabricaAlternativa + "]";
    }
    
}
