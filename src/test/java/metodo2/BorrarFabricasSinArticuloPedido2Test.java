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
    public void testBorrarFabricasSinArticuloPedido() throws Exception {
        System.out.println("borrarFabricasSinArticuloPedido numero fabricas pedido es 0");
        DataAccessManager dam = null;
        int expResult = 0;
        int result = BorrarFabricasSinArticuloPedido2.borrarFabricasSinArticuloPedido(dam);
        assertEquals(expResult, result);
    }

    @Test
    public void testBorrarFabricasSinArticuloPedido2() throws Exception {
        System.out.println("borrarFabricasSinArticuloPedido numero fabricas pedido es mayor a 0");
        DataAccessManager dam = null;
        int expResult = 0;
        int result = BorrarFabricasSinArticuloPedido2.borrarFabricasSinArticuloPedido(dam);
        assertEquals(expResult, result);
    }

    private static class DataAccessManagerSimulation extends DataAccessManager {

        public DataAccessManagerSimulation() {
            super();
        }

    }

}
