/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metodo2;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practica1App.BorrarFabricasSinArticuloPedido2;
import static org.junit.jupiter.api.Assertions.*;
import practica1DataAccess.DataAccessManager;

/**
 *
 * @author angel
 */
public class BorrarFabricasSinArticuloPedido2Test {

    private DataAccessManager dam;

    @BeforeEach
    public void setUp() {
        dam = new DataAccessManagerSimulation();
    }

    public BorrarFabricasSinArticuloPedido2Test() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of FiltrarFabricasSinPedido method, of class
     * BorrarFabricasSinArticuloPedido2.
     */
    //COMPLEJIDAD CICLOMATICA = 2
    @Test
    public void testBorrarFabricasSinArticuloPedido1() throws Exception {
        System.out.println(" ");
        System.out.println("Test 1 - Numero fabricas pedido es 0 - NO HAY FABRICAS sin pedidos de artículos");
        System.out.println(" ");
         dam = new DataAccessManagerSimulation() {
            @Override
            public List<String> filtrarFabricasSinPedido() {
                return List.of(); 
            }
            
            @Override
            public int borrarFabricasSinArticulosAsociadosAPedido(List<String> idsFabricas) {
                return idsFabricas.size();
            }
        };
        int expResult = 0;
        int result = BorrarFabricasSinArticuloPedido2.borrarFabricasSinArticuloPedido(dam);
        assertEquals(expResult, result);
    }

    @Test
    public void testBorrarFabricasSinArticuloPedido2() throws Exception {
        System.out.println(" ");
        System.out.println("Test 2 - Numero fabricas pedido es 0 - TENGO 2 FABRICAS sin articulos asociados a productos");
        System.out.println(" ");
        System.out.println("borrarFabricasSinArticuloPedido");
         // Simulamos que hay fábricas sin pedidos de artículos
        dam = new DataAccessManagerSimulation() {
            
            @Override
            public List<String> filtrarFabricasSinPedido() {
                return List.of("Fabrica1", "Fabrica2"); 
            }

            @Override
            public int borrarFabricasSinArticulosAsociadosAPedido(List<String> idsFabricas) {
                return idsFabricas.size(); 
            }
        };
        int expResult = 2;
        int result = BorrarFabricasSinArticuloPedido2.borrarFabricasSinArticuloPedido(dam);
        assertEquals(expResult, result);
    }

    private static class DataAccessManagerSimulation extends DataAccessManager {

        public DataAccessManagerSimulation() {
            super();
        }
        
        @Override
        public List<String> filtrarFabricasSinPedido() {
            return List.of();
        }

        @Override
        public int borrarFabricasSinArticulosAsociadosAPedido(List<String> idsFabricas) {
            return 0;
        }

    }

}
