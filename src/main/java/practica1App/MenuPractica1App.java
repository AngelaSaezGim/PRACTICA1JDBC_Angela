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
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    break;
                                case QUERY_CLIENTES:;
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    break;
                                case QUERY_FABRICAS:
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    break;
                                case QUERY_PEDIDOS:
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

                                    break;
                                case QUERY_ARTICULOSFABRICA:

                                    break;
                                case QUERY_CLIENTES:

                                    break;
                                case QUERY_DIRECCIONESENVIO:

                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
 
                                    break;
                                case QUERY_FABRICAS:

                                    break;
                                case QUERY_LINEASPEDIDO:

                                    break;
                                case QUERY_PEDIDOS:
                                    
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

}
