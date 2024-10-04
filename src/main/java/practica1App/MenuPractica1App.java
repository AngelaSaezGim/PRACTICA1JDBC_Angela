/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package practica1App;

import java.util.List;
import java.util.Scanner;

import practica1DataAccess.DataAccessManager;

import practica1Objetos.Articulo;
import practica1Objetos.ArticuloFabrica;
import practica1Objetos.Cliente;
import practica1Objetos.DireccionEnvio;
import practica1Objetos.Fabrica;
import practica1Objetos.FabricaAlternativa;
import practica1Objetos.LineaPedido;
import practica1Objetos.Pedido;

import java.sql.SQLException;

/**
 *
 * @author angsaegim
 */
public class MenuPractica1App {

    private static Scanner tcl = new Scanner(System.in);

    //Opciones del menú principal
    private enum MenuOption {
        QUERY_ALL, QUERY_BY_CODE, EXIT
    };

    private enum MenuOption1 {
        QUERY_ARTICULOS, QUERY_ARTICULOSFABRICA, QUERY_CLIENTES, QUERY_DIRECCIONESENVIO,
        QUERY_FABRICASALTERNATIVAS, QUERY_FABRICAS, QUERY_LINEASPEDIDO, QUERY_PEDIDOS, ATRAS
    };

    private enum MenuOption2 {
        QUERY_ARTICULOS, QUERY_ARTICULOSFABRICA, QUERY_CLIENTES, QUERY_DIRECCIONESENVIO,
        QUERY_FABRICASALTERNATIVAS, QUERY_FABRICAS, QUERY_LINEASPEDIDO, QUERY_PEDIDOS, ATRAS
    };

    public static void main(String[] args) {

        MenuOption opcionElegida = null;
        MenuOption1 opcionElegidaAll = null;
        MenuOption2 opcionElegidaContaining = null;

        try ( DataAccessManager dam = DataAccessManager.getInstance()) {
            do {
                printOptions();
                opcionElegida = readChoice();

                switch (opcionElegida) {
                    case QUERY_ALL:
                        do {
                            printOptionsAll();
                            opcionElegidaAll = readChoice1();
                            switch (opcionElegidaAll) {
                                case QUERY_ARTICULOS:
                                    verArticulos(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    verArticulosFabrica(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_CLIENTES:;
                                    verClientes(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    verDireccionesEnvio(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    verFabricasAlternativas(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    verFabricas(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    verLineasPedido(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    verPedidos(dam);
                                    esperarIntro();
                                    break;
                                case ATRAS:
                            }
                        } while (opcionElegidaAll != MenuOption1.ATRAS);
                        break;
                    case QUERY_BY_CODE:
                        do {
                            printOptionsCode();
                            opcionElegidaContaining = readChoice2();
                            switch (opcionElegidaContaining) {
                                case QUERY_ARTICULOS:
                                    esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    esperarIntro();
                                    break;
                                case QUERY_CLIENTES:
                                    esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    esperarIntro();
                                    break;
                                case ATRAS:
                            }
                        } while (opcionElegidaContaining != MenuOption2.ATRAS);
                        break;
                    case EXIT:
                }

            } while (opcionElegida != MenuOption.EXIT);

        } catch (SQLException sqe) {
            System.out.println("Error de acceso a datos: " + sqe.getMessage());
        }
        System.out.println("\n\n  ADIOS !!!! \n\n");
        tcl.close();
    }

    //**************** MÉTODOS PRINTEAR ********************//
    private static void printOptions() {
        StringBuilder sb = new StringBuilder()
                .append("\n\n\nElija una opción:\n")
                .append("\t1)Consultar todos...\n")
                .append("\t2)Consultar por codigos...\n")
                .append("\t3)Salir\n")
                .append("Opción: ");
        System.out.print(sb.toString());
    }

    private static void printOptionsAll() {
        StringBuilder sb = new StringBuilder()
                .append("\n\n\nElija que quieres consultar:\n")
                .append("\t1)Consultar TODOS los articulos\n")
                .append("\t2)Consultar TODOS los articulos de las fabricas\n")
                .append("\t3)Consultar TODOS los clientes\n")
                .append("\t4)Consultar TODAS las direcciones de envio \n")
                .append("\t5)Consultar TODAS las fabricas alternativas\n")
                .append("\t6)Consultar TODAS las fabricas\n")
                .append("\t7)Consultar TODAS las lineas de pedidos\n")
                .append("\t8)Consultar TODOS los pedidos\n")
                .append("\t9)Atrás\n")
                .append("Opción: ");
        System.out.print(sb.toString());
    }

    private static void printOptionsCode() {
        StringBuilder sb = new StringBuilder()
                .append("\n\n\nElija que quieres consultar:\n")
                .append("\t1)Consultar articulos por id\n")
                .append("\t2)Consultar articulos de las fabricas por ids\n")
                .append("\t3)Consultar clientes por id\n")
                .append("\t4)Consultar direcciones de envio por id\n")
                .append("\t5)Consultar fabricas alternativas por ids\n")
                .append("\t6)Consultar fabricas por id\n")
                .append("\t7)Consultar lineas de pedidos por id\n")
                .append("\t8)Consultar pedidos por id\n")
                .append("\t9)Atrás\n")
                .append("Opción: ");
        System.out.print(sb.toString());
    }

    private static MenuOption readChoice() {
        try {
            int choiceInt = Integer.valueOf(tcl.nextLine());
            return MenuOption.values()[choiceInt - 1];
        } catch (RuntimeException re) {
            System.out.println("Opción inválida... Inténtelo otra vez.");
            return readChoice();
        }
    }

    private static MenuOption1 readChoice1() {
        try {
            int choiceInt = Integer.valueOf(tcl.nextLine());
            return MenuOption1.values()[choiceInt - 1];
        } catch (RuntimeException re) {
            System.out.println("Opción inválida... Inténtelo otra vez.");
            return readChoice1();
        }
    }

    private static MenuOption2 readChoice2() {
        try {
            int choiceInt = Integer.valueOf(tcl.nextLine());
            return MenuOption2.values()[choiceInt - 1];
        } catch (RuntimeException re) {
            System.out.println("Opción inválida... Inténtelo otra vez.");
            return readChoice2();
        }
    }

    private static void esperarIntro() {
        System.out.println("Presione Enter para continuar...");
        tcl.nextLine();
    }

    //***************************** FUNCIONES LANZADAS - DATA ACCESS MANAGER *****************************/
    private static void verArticulos(DataAccessManager dam) throws SQLException {
        List<Articulo> allArticulos = dam.loadAllArticulos();
        printArticulos(allArticulos);
    }

    private static void printArticulos(List<Articulo> articulos) {
        if (articulos == null || articulos.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (Articulo articulo : articulos) {
            System.out.println("\t" + articulo);
        }
        System.out.println();
    }

    private static void verArticulosFabrica(DataAccessManager dam) throws SQLException {
        List<ArticuloFabrica> allArticulosFabrica = dam.loadAllArticulosFabrica();
        printArticulosFabrica(allArticulosFabrica);
    }

    private static void printArticulosFabrica(List<ArticuloFabrica> articulosFabrica) {
        if (articulosFabrica == null || articulosFabrica.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (ArticuloFabrica articuloFabrica : articulosFabrica) {
            System.out.println("\t" + articuloFabrica);
        }
        System.out.println();
    }

    private static void verClientes(DataAccessManager dam) throws SQLException {
        List<Cliente> allClientes = dam.loadAllClientes();
        printClientes(allClientes);
    }

    private static void printClientes(List<Cliente> clientes) {
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println("\t" + cliente);
        }
        System.out.println();
    }

    private static void verDireccionesEnvio(DataAccessManager dam) throws SQLException {
        List<DireccionEnvio> allDireccionesEnvio = dam.loadAllDireccionesEnvio();
        printDireccionesEnvio(allDireccionesEnvio);
    }

    private static void printDireccionesEnvio(List<DireccionEnvio> direccionesEnvio) {
        if (direccionesEnvio == null || direccionesEnvio.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (DireccionEnvio direccionEnvio : direccionesEnvio) {
            System.out.println("\t" + direccionEnvio);
        }
        System.out.println();
    }

    private static void verFabricasAlternativas(DataAccessManager dam) throws SQLException {
        List<FabricaAlternativa> allFabricasAlternativas = dam.loadAllFabricasAlternativas();
        printFabricasAlternativas(allFabricasAlternativas);
    }

    private static void printFabricasAlternativas(List<FabricaAlternativa> fabricasAlternativas) {
        if (fabricasAlternativas == null || fabricasAlternativas.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (FabricaAlternativa fabricaAlternativa : fabricasAlternativas) {
            System.out.println("\t" + fabricaAlternativa);
        }
        System.out.println();
    }

    private static void verFabricas(DataAccessManager dam) throws SQLException {
        List<Fabrica> allFabricas = dam.loadAllFabricas();
        printFabricas(allFabricas);
    }

    private static void printFabricas(List<Fabrica> fabricas) {
        if (fabricas == null || fabricas.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (Fabrica fabrica : fabricas) {
            System.out.println("\t" + fabrica);
        }
        System.out.println();
    }

    private static void verLineasPedido(DataAccessManager dam) throws SQLException {
        List<LineaPedido> allLineasPedido = dam.loadAllLineasPedido();
        printLineasPedido(allLineasPedido);
    }

    private static void printLineasPedido(List<LineaPedido> lineasPedido) {
        if (lineasPedido == null || lineasPedido.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (LineaPedido lineaPedido : lineasPedido) {
            System.out.println("\t" + lineaPedido);
        }
        System.out.println();
    }

    private static void verPedidos(DataAccessManager dam) throws SQLException {
        List<Pedido> allPedidos = dam.loadAllPedidos();
        printPedidos(allPedidos);
    }

    private static void printPedidos(List<Pedido> pedidos) {
        if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println("\t" + pedido);
        }
        System.out.println();
    }
    
    // BY CONTENT 
 

}
