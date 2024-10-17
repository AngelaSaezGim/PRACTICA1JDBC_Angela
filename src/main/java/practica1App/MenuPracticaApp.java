/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package practica1App;

import java.util.Scanner;

import practica1DataAccess.DataAccessManager;

import java.sql.SQLException;

/**
 *
 * @author angsaegim
 */
public class MenuPracticaApp {

    private static Scanner tcl = new Scanner(System.in);

    private enum MenuOption {
        QUERY_ALL, QUERY_BY_CODE, QUERY_INSERT, QUERY_DELETE, QUERY_UPDATE, QUERY_TOTALARTICULOSFABRICA,QUERY_LISTARCOMANDES, QUERY_BORRARFABRICASNOCOMANDA,
        QUERY_ARTICULOSAÑO, EXIT
    };

    private enum MenuOption1 {
        QUERY_ARTICULOS, QUERY_ARTICULOSFABRICA, QUERY_CLIENTES, QUERY_DIRECCIONESENVIO,
        QUERY_FABRICASALTERNATIVAS, QUERY_FABRICAS, QUERY_LINEASPEDIDO, QUERY_PEDIDOS, ATRAS
    };

    private enum MenuOption2 {
        QUERY_ARTICULOS, QUERY_ARTICULOSFABRICA, QUERY_CLIENTES, QUERY_DIRECCIONESENVIO,
        QUERY_FABRICASALTERNATIVAS, QUERY_FABRICAS, QUERY_LINEASPEDIDO, QUERY_PEDIDOS, ATRAS
    };

    private enum MenuOption3 {
        QUERY_ARTICULOS, QUERY_ARTICULOSFABRICA, QUERY_CLIENTES, QUERY_DIRECCIONESENVIO,
        QUERY_FABRICASALTERNATIVAS, QUERY_FABRICAS, QUERY_LINEASPEDIDO, QUERY_PEDIDOS, ATRAS
    };

    private enum MenuOption4 {
        QUERY_ARTICULOS, QUERY_ARTICULOSFABRICA, QUERY_CLIENTES, QUERY_DIRECCIONESENVIO,
        QUERY_FABRICASALTERNATIVAS, QUERY_FABRICAS, QUERY_LINEASPEDIDO, QUERY_PEDIDOS, ATRAS
    };

    private enum MenuOption5 {
        QUERY_ARTICULOS, QUERY_ARTICULOSFABRICA, QUERY_CLIENTES, QUERY_DIRECCIONESENVIO,
        QUERY_FABRICASALTERNATIVAS, QUERY_FABRICAS, QUERY_LINEASPEDIDO, QUERY_PEDIDOS, ATRAS
    };

    public static void main(String[] args) throws Exception {

        MenuOption opcionElegida = null;
        MenuOption1 opcionElegidaAll = null;
        MenuOption2 opcionElegidaContaining = null;
        MenuOption3 opcionElegidaInsert = null;
        MenuOption4 opcionElegidaDelete = null;
        MenuOption5 opcionElegidaUpdate = null;

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
                                    MetodosMenu.verArticulos(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    MetodosMenu.verArticulosFabrica(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_CLIENTES:;
                                    MetodosMenu.verClientes(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    MetodosMenu.verDireccionesEnvio(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    MetodosMenu.verFabricasAlternativas(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    MetodosMenu.verFabricas(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    MetodosMenu.verLineasPedido(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    MetodosMenu.verPedidos(dam);
                                    MetodosMenu.esperarIntro();
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
                                    MetodosMenu.searchArticuloByCode(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    MetodosMenu.searchArticuloFabricaByCode(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_CLIENTES:
                                    MetodosMenu.searchClienteByCode(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    MetodosMenu.searchDireccionEnvioByCode(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    MetodosMenu.searchFabricaAlternativaByCode(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    MetodosMenu.searchFabricaByCode(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    MetodosMenu.searchLineaPedidoByCode(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    MetodosMenu.searchPedidoByCode(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case ATRAS:
                            }
                        } while (opcionElegidaContaining != MenuOption2.ATRAS);
                        break;

                    case QUERY_INSERT:
                        do {
                            printOptionsInsert();
                            opcionElegidaInsert = readChoice3();
                            switch (opcionElegidaInsert) {
                                case QUERY_ARTICULOS:
                                    MetodosMenu.insertarArticulo(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    MetodosMenu.insertarArticuloFabrica(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_CLIENTES:
                                    MetodosMenu.insertarCliente(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    MetodosMenu.insertarDireccionEnvio(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    MetodosMenu.insertarFabricaAlternativa(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    MetodosMenu.insertarFabrica(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    MetodosMenu.insertarLineaPedido(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    MetodosMenu.insertarPedido(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case ATRAS:
                                    break;
                            }
                        } while (opcionElegidaInsert != MenuOption3.ATRAS);
                        break;

                    case QUERY_DELETE:
                        do {
                            printOptionsDelete();
                            opcionElegidaDelete = readChoice4();
                            switch (opcionElegidaDelete) {
                                case QUERY_ARTICULOS:
                                    MetodosMenu.borrarArticulo(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    MetodosMenu.borrarArticuloFabrica(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_CLIENTES:
                                    MetodosMenu.borrarCliente(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    MetodosMenu.borrarDireccionEnvio(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    MetodosMenu.borrarFabricaAlternativa(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    MetodosMenu.borrarFabrica(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    MetodosMenu.borrarLineaPedido(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    MetodosMenu.borrarPedido(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case ATRAS:
                                    break;
                            }
                        } while (opcionElegidaDelete != MenuOption4.ATRAS);
                        break;
                    case QUERY_UPDATE:
                        do {
                            printOptionsUpdate();
                            opcionElegidaUpdate = readChoice5();
                            switch (opcionElegidaUpdate) {
                                case QUERY_ARTICULOS:
                                    MetodosMenu.actualizarArticulo(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    MetodosMenu.actualizarArticuloFabrica(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_CLIENTES:
                                    MetodosMenu.actualizarCliente(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    MetodosMenu.actualizarDireccionEnvio(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    MetodosMenu.actualizarFabricaAlternativa(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    MetodosMenu.actualizarFabrica(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    MetodosMenu.actualizarLineaPedido(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    MetodosMenu.actualizarPedido(dam);
                                    MetodosMenu.esperarIntro();
                                    break;
                                case ATRAS:
                                    break;
                            }
                        } while (opcionElegidaUpdate != MenuOption5.ATRAS);
                        break;
                    case QUERY_TOTALARTICULOSFABRICA:
                        MetodosMenu.getTotalArticulosPorFabrica(dam);
                         MetodosMenu.esperarIntro();
                        break;
                    case QUERY_LISTARCOMANDES:
                        SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
                        MetodosMenu.esperarIntro();
                        break;
                    case QUERY_BORRARFABRICASNOCOMANDA:
                        BorrarFabricasSinArticuloPedido2.borrarFabricasSinArticuloPedido(dam);
                        MetodosMenu.esperarIntro();
                        break;
                    case QUERY_ARTICULOSAÑO:
                        CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño(dam);
                        MetodosMenu.esperarIntro();
                    case EXIT:
                        break;
                }
            } while (opcionElegida != MenuOption.EXIT);

        } catch (SQLException sqe) {
            System.out.println("Error de acceso a datos: " + sqe.getMessage());
        }

        System.out.println("\n\n  PROGRAMA CERRADO \n\n");
        tcl.close();
    }

    //**************** MÉTODOS PRINTEAR ********************//
    private static void printOptions() {
        StringBuilder sb = new StringBuilder()
                .append("\n\n\nElija una opción:\n")
                .append("\t1)Consultar todos...\n")
                .append("\t2)Consultar por codigos...\n")
                .append("\t3)Insertar...\n")
                .append("\t4)Borrar...\n")
                .append("\t5)Actualizar...\n")
                .append("\t6)Ver cuantos articulos provee cada fabrica \n")
                .append("\t7)Listar pedidos cliente (importe + descuento) \n")
                .append("\t8)Borrar fabricas sin artículos asociados a pedidos\n")
                .append("\t9)Total de artículos incluidos en todos los pedidos de un año\n")
                .append("\t10)Salir\n")
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

    private static void printOptionsInsert() {
        StringBuilder sb = new StringBuilder()
                .append("\n\n\nElija donde quieres INSERTAR datos:\n")
                .append("\t1)Insertar articulo\n")
                .append("\t2)Insertar articulo asociados a una fabrica\n")
                .append("\t3)Insertar cliente\n")
                .append("\t4)Insertar direccion de envio\n")
                .append("\t5)Insertar una fabrica alternativa\n")
                .append("\t6)Insertar una fabrica\n")
                .append("\t7)Insertar una linea de pedido\n")
                .append("\t8)Insertar un pedido\n")
                .append("\t9)Atrás\n")
                .append("Opción: ");
        System.out.print(sb.toString());
    }

    private static void printOptionsDelete() {
        StringBuilder sb = new StringBuilder()
                .append("\n\n\nElija donde quieres BORRAR datos:\n")
                .append("\t1)Borrar articulo por id\n")
                .append("\t2)Borrar articulo de fabrica por ids\n")
                .append("\t3)Borrar cliente por id\n")
                .append("\t4)Borrar direccion de envio por id\n")
                .append("\t5)Borrar fabrica alternativa por ids\n")
                .append("\t6)Borrar fabrica por id\n")
                .append("\t7)Borrar linea de pedido por id\n")
                .append("\t8)Borrar pedido por id\n")
                .append("\t9)Atrás\n")
                .append("Opción: ");
        System.out.print(sb.toString());
    }

    private static void printOptionsUpdate() {
        StringBuilder sb = new StringBuilder()
                .append("\n\n\nElija donde quieres ACTUALIZAR datos:\n")
                .append("\t1)Actualizar articulo por id\n")
                .append("\t2)Actualizar articulo de fabrica por ids\n")
                .append("\t3)Actualizar cliente por id\n")
                .append("\t4)Actualizar direccion de envio por id\n")
                .append("\t5)Actualizar fabrica alternativa por ids\n")
                .append("\t6)Actualizar fabrica por id\n")
                .append("\t7)Actualizar linea de pedido por id\n")
                .append("\t8)Actualizar pedido por id\n")
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

    private static MenuOption3 readChoice3() {
        try {
            int choiceInt = Integer.valueOf(tcl.nextLine());
            return MenuOption3.values()[choiceInt - 1];
        } catch (RuntimeException re) {
            System.out.println("Opción inválida... Inténtelo otra vez.");
            return readChoice3();
        }
    }

    private static MenuOption4 readChoice4() {
        try {
            int choiceInt = Integer.valueOf(tcl.nextLine());
            return MenuOption4.values()[choiceInt - 1];
        } catch (RuntimeException re) {
            System.out.println("Opción inválida... Inténtelo otra vez.");
            return readChoice4();
        }
    }

    private static MenuOption5 readChoice5() {
        try {
            int choiceInt = Integer.valueOf(tcl.nextLine());
            return MenuOption5.values()[choiceInt - 1];
        } catch (RuntimeException re) {
            System.out.println("Opción inválida... Inténtelo otra vez.");
            return readChoice5();
        }
    }

}
