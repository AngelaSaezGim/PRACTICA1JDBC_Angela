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
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author angsaegim
 */
public class MenuPractica1App {

    private static Scanner tcl = new Scanner(System.in);

    //Opciones del menú principal
    private enum MenuOption {
        QUERY_ALL, QUERY_BY_CODE, QUERY_INSERT, QUERY_DELETE, QUERY_UPDATE, QUERY_LISTARCOMANDES, QUERY_BORRARFABRICASNOCOMANDA,
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

    public static void main(String[] args) {

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
                                    searchArticuloByCode(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    searchArticuloFabricaByCode(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_CLIENTES:
                                    searchClienteByCode(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    searchDireccionEnvioByCode(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    searchFabricaAlternativaByCode(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    searchFabricaByCode(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    searchLineaPedidoByCode(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    searchPedidoByCode(dam);
                                    esperarIntro();
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
                                    insertarArticulo(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    insertarArticuloFabrica(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_CLIENTES:
                                    insertarCliente(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    insertarDireccionEnvio(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    insertarFabricaAlternativa(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    insertarFabrica(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    insertarLineaPedido(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    insertarPedido(dam);
                                    esperarIntro();
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
                                    borrarArticulo(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    borrarArticuloFabrica(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_CLIENTES:
                                    borrarCliente(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    borrarDireccionEnvio(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    borrarFabricaAlternativa(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    borrarFabrica(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    borrarLineaPedido(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    borrarPedido(dam);
                                    esperarIntro();
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
                                    actualizarArticulo(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_ARTICULOSFABRICA:
                                    actualizarArticuloFabrica(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_CLIENTES:
                                    actualizarCliente(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_DIRECCIONESENVIO:
                                    actualizarDireccionEnvio(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICASALTERNATIVAS:
                                    actualizarFabricaAlternativa(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_FABRICAS:
                                    actualizarFabrica(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_LINEASPEDIDO:
                                    actualizarLineaPedido(dam);
                                    esperarIntro();
                                    break;
                                case QUERY_PEDIDOS:
                                    actualizarPedido(dam);
                                    esperarIntro();
                                    break;
                                case ATRAS:
                                    break;
                            }
                        } while (opcionElegidaUpdate != MenuOption5.ATRAS);
                        break;
                    case QUERY_LISTARCOMANDES:
                        printImporteTotalCliente(dam);
                        esperarIntro();
                        break;
                    case QUERY_BORRARFABRICASNOCOMANDA:
                        borrarFabricasSinArticuloPedido(dam);
                        esperarIntro();
                        break;
                    case QUERY_ARTICULOSAÑO:
                        System.out.println("Cantidad articulos de las comandas en x año");
                        filtrarPedidosAño(dam);
                        esperarIntro();
                    case EXIT:
                        break;
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
                .append("\t3)Insertar...\n")
                .append("\t4)Borrar...\n")
                .append("\t5)Actualizar...\n")
                .append("\t6)Listar pedidos cliente (importe + descuento) \n")
                .append("\t7)Borrar fabricas sin artículos asociados a pedidos\n")
                .append("\t8)Total de artículos incluidos en todos los pedidos de un año\n")
                .append("\t9)Salir\n")
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

    public static void printArticulo(Articulo articulo) {
        System.out.println("Descripción: " + articulo.getDescripcion());
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
    private static String requestContentLike() {
        System.out.print("Escriba el id a buscar; ");
        return readNotEmptyString();
    }

    private static String readNotEmptyString() {
        String input = null;
        //prevenir texto vacío
        while (input == null || input.length() == 0) {
            input = tcl.nextLine();
            if (input.length() == 0) {
                System.out.println("escriba algo...");
            }
        }
        return input;
    }

    //DEVUELVEN LISTAS (MOSTRAR POR...)
    private static void searchArticuloByCode(DataAccessManager dam) throws SQLException {
        String idArticulo = requestContentLike();
        List<Articulo> articulosFilteredByCode = dam.loadArticulosContaining(idArticulo);
        if (articulosFilteredByCode != null) {
            printArticulos(articulosFilteredByCode);
        } else {
            System.out.println("No se encontraron articulos con el código especificado.");
        }
    }

    private static void searchArticuloFabricaByCode(DataAccessManager dam) throws SQLException {
        System.out.println("ID del articulo");
        String idArticulo = requestContentLike();
        System.out.println("ID de la Fabrica asociada al articulo");
        String idFabrica = requestContentLike();
        System.out.println("Valores leídos -> idArticulo: " + idArticulo + ", Asociado a la fabrica: " + idFabrica);

        List<ArticuloFabrica> articulosFabricaFilteredByCode = dam.loadArticulosFabricaContaining(idArticulo, idFabrica);
        if (articulosFabricaFilteredByCode != null) {
            printArticulosFabrica(articulosFabricaFilteredByCode);
        } else {
            System.out.println("No se encontraron articulos de esa fabrica");
        }
    }

    private static void searchClienteByCode(DataAccessManager dam) throws SQLException {
        String idCliente = requestContentLike();
        List<Cliente> clientesFilteredByCode = dam.loadClientesContaining(idCliente);
        if (clientesFilteredByCode != null) {
            printClientes(clientesFilteredByCode);
        } else {
            System.out.println("No se encontraron articulos con el código especificado.");
        }
    }

    private static void searchDireccionEnvioByCode(DataAccessManager dam) throws SQLException {
        String idDireccionEnvio = requestContentLike();
        List<DireccionEnvio> direccionesEnvioFilteredByCode = dam.loadDireccionEnvioContaining(idDireccionEnvio);
        if (direccionesEnvioFilteredByCode != null) {
            printDireccionesEnvio(direccionesEnvioFilteredByCode);
        } else {
            System.out.println("No se encontraron direcciones de envío con el código especificado.");
        }
    }

    private static void searchFabricaAlternativaByCode(DataAccessManager dam) throws SQLException {
        System.out.println("ID de la fabrica principal");
        String idFabricaPrincipal = requestContentLike();
        System.out.println("ID de la fabrica alternativa asociada a esa fabrica princiapl");
        String idFabricaAlternativa = requestContentLike();
        System.out.println("Valores leídos -> Fabrica Principal: " + idFabricaPrincipal + ", - Su fabrica alternativa: " + idFabricaAlternativa);

        List<FabricaAlternativa> fabricaAlternativaFilteredByCode = dam.loadFabricaAlternativaContaining(idFabricaPrincipal, idFabricaAlternativa);
        if (fabricaAlternativaFilteredByCode != null) {
            printFabricasAlternativas(fabricaAlternativaFilteredByCode);
        } else {
            System.out.println("No se encontraron fabricas alternativas con esas ids");
        }
    }

    private static void searchFabricaByCode(DataAccessManager dam) throws SQLException {
        String idFabrica = requestContentLike();
        List<Fabrica> fabricasFilteredByCode = dam.loadFabricasContaining(idFabrica);
        if (fabricasFilteredByCode != null) {
            printFabricas(fabricasFilteredByCode);
        } else {
            System.out.println("No se encontraron fábricas con el código especificado.");
        }
    }

    private static void searchLineaPedidoByCode(DataAccessManager dam) throws SQLException {
        String idLineaPedido = requestContentLike();
        List<LineaPedido> lineasPedidoFilteredByCode = dam.loadLineasPedidoContaining(idLineaPedido);
        if (lineasPedidoFilteredByCode != null) {
            printLineasPedido(lineasPedidoFilteredByCode);
        } else {
            System.out.println("No se encontraron líneas de pedido con el código especificado.");
        }
    }

    private static void searchPedidoByCode(DataAccessManager dam) throws SQLException {
        String idPedido = requestContentLike();
        List<Pedido> pedidosFilteredByCode = dam.loadPedidosContaining(idPedido);
        if (pedidosFilteredByCode != null) {
            printPedidos(pedidosFilteredByCode);
        } else {
            System.out.println("No se encontraron pedidos con el código especificado.");
        }

    }

    //*INSERT*/
    private static void insertarArticulo(DataAccessManager dam) throws SQLException {

        System.out.print("Escriba la descripción del nuevo artículo: ");
        String descripcion = tcl.nextLine();

        Articulo nuevoArticulo = new Articulo(descripcion);

        try {
            dam.insertarArticulo(nuevoArticulo);
            System.out.println("El artículo ha sido insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el artículo: " + e.getMessage());
            throw e;
        }
    }

    private static void insertarArticuloFabrica(DataAccessManager dam) throws SQLException {

        System.out.println("Cual es la id del articulo de esta fabrica");
        int idArticulo = tcl.nextInt();

        if (!dam.articuloExiste(idArticulo)) {
            System.out.println("Error: El articulo con id " + idArticulo + " no existe.");
            esperarIntro();
            return;
        }

        System.out.print("A que fabrica pertenece este nuevo articulo: ");
        int idFabrica = tcl.nextInt();

        if (!dam.fabricaExiste(idFabrica)) {
            System.out.println("Error: La fábrica con ID " + idFabrica + " no existe.");
            esperarIntro();
            return;
        }
        System.out.print("Existencias : ");
        int existencias = tcl.nextInt();

        System.out.print("Precio : ");
        double precio = tcl.nextDouble();

        ArticuloFabrica nuevoArticuloFabrica = new ArticuloFabrica(idArticulo, idFabrica, existencias, precio);

        try {
            dam.insertarArticuloFabrica(nuevoArticuloFabrica);
            System.out.println("El artículo de la fabrica" + idFabrica + " ha sido insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el artículo: " + e.getMessage());
            throw e;
        }
    }

    private static void insertarCliente(DataAccessManager dam) throws SQLException {

        System.out.print("Escriba el saldo del cliente ");
        double saldo = tcl.nextDouble();

        System.out.print("Escriba el limite de credito del cliente ");
        double limiteCredito = tcl.nextDouble();

        if (limiteCredito > 18000) {
            System.out.println("Error: El límite de crédito no puede superar 18,000 euros.");
            esperarIntro();
            return;
        }

        System.out.println("Escriba el descuento aplicado al cliente");
        double descuento = tcl.nextDouble();

        Cliente nuevoCliente = new Cliente(saldo, limiteCredito, descuento);

        try {
            dam.insertarCliente(nuevoCliente);
            System.out.println("El cliente ha sido insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente: " + e.getMessage());
            throw e;
        }

    }

    private static void insertarDireccionEnvio(DataAccessManager dam) throws SQLException {

        System.out.print("Escriba el número de la dirección: ");
        int numero = tcl.nextInt();

        System.out.print("Escriba la calle de la dirección: ");
        String calle = tcl.next();

        System.out.print("Escriba la comuna de la dirección: ");
        String comuna = tcl.next();

        System.out.print("Escriba la ciudad de la dirección: ");
        String ciudad = tcl.next();

        System.out.print("Escriba el ID del cliente asociado a esa direccion: ");
        int idCliente = tcl.nextInt();

        if (!dam.clienteExiste(idCliente)) {
            System.out.println("Error: El cliente con ID " + idCliente + " no existe.");
            esperarIntro();
            return;
        }

        DireccionEnvio nuevaDireccionEnvio = new DireccionEnvio(numero, calle, comuna, ciudad, idCliente);

        try {
            dam.insertarDireccionEnvio(nuevaDireccionEnvio);
            System.out.println("La direccion de envio asociada al cliente " + idCliente + " ha sido insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la direccion: " + e.getMessage());
            throw e;
        }

    }

    private static void insertarFabricaAlternativa(DataAccessManager dam) throws SQLException {

        System.out.print("Escriba el id de la fabrica principal asociada a esa fabrica alternativa ");
        int idFabricaPrincipal = tcl.nextInt();

        System.out.print("Escriba el id de la fabrica alternativa ");
        int idFabricaAlternativa = tcl.nextInt();

        FabricaAlternativa nuevaFabricaAlternativa = new FabricaAlternativa(idFabricaPrincipal, idFabricaAlternativa);

        if (idFabricaPrincipal == idFabricaAlternativa) {
            System.out.println("Error: El ID de la fábrica principal no puede ser el mismo que el ID de la fábrica alternativa.");
            esperarIntro();
            return;
        }

        if (!dam.fabricaExiste(idFabricaPrincipal)) {
            System.out.println("Error: La fábrica principal con ID " + idFabricaPrincipal + " no existe.");
            esperarIntro();
            return;
        }

        if (!dam.fabricaExiste(idFabricaAlternativa)) {
            System.out.println("Error: La fábrica alternativa con ID " + idFabricaAlternativa + " no existe.");
            esperarIntro();
            return;
        }

        try {
            dam.insertarFabricaAlternativa(nuevaFabricaAlternativa);
            System.out.println("La fábrica alternativa ha sido insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la fábrica: " + e.getMessage());
            throw e;
        }

    }

    private static void insertarFabrica(DataAccessManager dam) throws SQLException {

        System.out.print("Escriba el teléfono de contacto de la fábrica: ");
        String telefonoContacto = tcl.nextLine();

        Fabrica nuevaFabrica = new Fabrica(telefonoContacto);

        try {
            dam.insertarFabrica(nuevaFabrica);
            System.out.println("La fábrica ha sido insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la fábrica: " + e.getMessage());
            throw e;
        }

    }

    private static void insertarLineaPedido(DataAccessManager dam) throws SQLException {

        System.out.print("Escriba el ID del pedido: ");
        int idPedido = tcl.nextInt();

        if (!dam.pedidoExiste(idPedido)) {
            System.out.println("Error: El pedido con ID " + idPedido + " no existe.");
            esperarIntro();
            return;
        }

        System.out.print("Escriba el ID del artículo: ");
        int idArticulo = tcl.nextInt();

        if (!dam.articuloExiste(idArticulo)) {
            System.out.println("Error: El artículo con ID " + idArticulo + " no existe.");
            esperarIntro();
            return;
        }

        System.out.print("Escriba la cantidad del artículo: ");
        int cantidad = tcl.nextInt();

        LineaPedido nuevaLineaPedido = new LineaPedido(idPedido, idArticulo, cantidad);

        try {
            dam.insertarLineaPedido(nuevaLineaPedido);
            System.out.println("La línea de pedido ha sido insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la línea de pedido: " + e.getMessage());
            throw e;
        }
    }

    private static void insertarPedido(DataAccessManager dam) throws SQLException {

        System.out.println("Se creará un pedido con la fecha actual");
        System.out.print("Escriba el número de la comanda: ");
        int numeroComanda = tcl.nextInt();

        System.out.print("Escriba el ID del cliente: ");
        int idCliente = tcl.nextInt();

        if (!dam.clienteExiste(idCliente)) {
            System.out.println("Error: El cliente con ID " + idCliente + " no existe.");
            esperarIntro();
            return;
        }

        System.out.print("Escriba el ID de la dirección de envío: ");
        int idDireccion = tcl.nextInt();

        if (!dam.direccionExiste(idDireccion)) {
            System.out.println("Error: La dirección de envío con ID " + idDireccion + " no existe.");
            esperarIntro();
            return;
        }

        Pedido nuevoPedido = new Pedido(new Timestamp(System.currentTimeMillis()), numeroComanda, idCliente, idDireccion);

        try {
            dam.insertarPedido(nuevoPedido);
            System.out.println("El pedido ha sido insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el pedido: " + e.getMessage());
            throw e;
        }

    }

    //*DELETE*//
    private static String requestContentDelete() {
        System.out.print("Escriba el id a borrar; ");
        return readNotEmptyString();
    }

    private static void borrarArticulo(DataAccessManager dam) throws SQLException {
        String idArticulo = requestContentDelete();
        int columnasAfectadas = dam.borrarArticulo(idArticulo);
        if (columnasAfectadas > 0) {
            System.out.println("Articulo borrado exitosamente");
        } else {
            System.out.println("No se encontraron articulos con el código especificado para borrar.");
        }
    }

    private static void borrarArticuloFabrica(DataAccessManager dam) throws SQLException {

        System.out.println("Id articulo");
        String idArticulo = requestContentDelete();
        System.out.println("Id fabrica");
        String idFabrica = requestContentDelete();
        int columnasAfectadas = dam.borrarArticuloFabrica(idArticulo, idFabrica);
        if (columnasAfectadas > 0) {
            System.out.println("Articulo" + idArticulo + " asociado a la fabrica" + idFabrica + " borrado exitosamente");
        } else {
            System.out.println("No se encontraron articulos de esa fabrica con el código especificado para borrar.");
        }
    }

    private static void borrarCliente(DataAccessManager dam) throws SQLException {
        String idCliente = requestContentDelete();
        int columnasAfectadas = dam.borrarCliente(idCliente);
        if (columnasAfectadas > 0) {
            System.out.println("Cliente borrado exitosamente");
        } else {
            System.out.println("No se encontraron clientes con el código especificado para borrar.");
        }
    }

    private static void borrarDireccionEnvio(DataAccessManager dam) throws SQLException {
        String idDireccion = requestContentDelete();
        int columnasAfectadas = dam.borrarDireccionEnvio(idDireccion);
        if (columnasAfectadas > 0) {
            System.out.println("Direccion borrada exitosamente");
        } else {
            System.out.println("No se encontraron direcciones con el código especificado para borrar.");
        }
    }

    private static void borrarFabricaAlternativa(DataAccessManager dam) throws SQLException {

        System.out.println("Id fabrica principal asociada a esa fabrica alternativa");
        String idFabricaPrincipal = requestContentDelete();
        System.out.println("Id fabrica alternativa");
        String idFabricaAlternativa = requestContentDelete();
        int columnasAfectadas = dam.borrarFabricaAlternativa(idFabricaPrincipal, idFabricaAlternativa);
        if (columnasAfectadas > 0) {
            System.out.println("Fabrica alternativa " + idFabricaAlternativa + " asociada a " + idFabricaPrincipal + " borrada exitosamente");
        } else {
            System.out.println("No se encontraron fabricas alternativas con los codigos especificados para borrar.");
        }
    }

    private static void borrarFabrica(DataAccessManager dam) throws SQLException {
        String idFabrica = requestContentDelete();
        int columnasAfectadas = dam.borrarFabrica(idFabrica);
        if (columnasAfectadas > 0) {
            System.out.println("Fabrica borrada exitosamente");
        } else {
            System.out.println("No se encontraron fabricas con el código especificado para borrar.");
        }
    }

    private static void borrarLineaPedido(DataAccessManager dam) throws SQLException {
        String idLineaPedido = requestContentDelete();
        int columnasAfectadas = dam.borrarLineaPedido(idLineaPedido);
        if (columnasAfectadas > 0) {
            System.out.println("Linea de pedido borrada exitosamente");
        } else {
            System.out.println("No se encontraron lineas de pedido con el código especificado para borrar.");
        }
    }

    private static void borrarPedido(DataAccessManager dam) throws SQLException {
        String idPedido = requestContentDelete();
        int columnasAfectadas = dam.borrarPedido(idPedido);
        if (columnasAfectadas > 0) {
            System.out.println("Pedido borrado exitosamente");
        } else {
            System.out.println("No se encontraron pedidos con el código especificado para borrar.");
        }
    }

    /* UPDATE */
    private static void actualizarArticulo(DataAccessManager dam) throws SQLException {

        System.out.print("Ingrese el ID del artículo que desea actualizar: ");
        String idArticuloAActualizarStr = tcl.nextLine();

        // Carga el artículo actual desde la base de datos
        Articulo articuloAActualizar = dam.loadArticuloByCode(idArticuloAActualizarStr);

        if (articuloAActualizar == null) {
            System.out.println("El artículo con ID " + idArticuloAActualizarStr + " no existe.");
        } else {
            System.out.println("Ingrese la nueva descripción del artículo (dejar vacío para no cambiar):");
            String nuevaDescripcion = tcl.nextLine();
            if (!nuevaDescripcion.isEmpty()) {
                articuloAActualizar.setDescripcion(nuevaDescripcion);
            }

            System.out.println("Actualizando el artículo " + idArticuloAActualizarStr);
            int columnasAfectadas = dam.updateArticulo(idArticuloAActualizarStr, articuloAActualizar);

            if (columnasAfectadas > 0) {
                System.out.println("Artículo actualizado exitosamente.");
                Articulo articuloActualizado = dam.loadArticuloByCode(idArticuloAActualizarStr);
                System.out.println(articuloActualizado.toString());
            } else {
                System.out.println("No se actualizó nada.");
            }
        }
    }

    private static void actualizarArticuloFabrica(DataAccessManager dam) throws SQLException {

        System.out.print("Ingrese el ID del artículo asociado a una fabrica que desea actualizar: ");
        String idArticuloFabrica1AActualizarStr = tcl.nextLine();

        System.out.print("Ingrese el ID de la fabrica asociada a ese articulo ");
        String idArticuloFabrica2AActualizarStr = tcl.nextLine();

        ArticuloFabrica articuloFabricaAActualizar = dam.loadArticuloFabricaByCode(idArticuloFabrica1AActualizarStr, idArticuloFabrica2AActualizarStr);

        if (articuloFabricaAActualizar == null) {
            System.out.println("El artículo con ID " + idArticuloFabrica1AActualizarStr + "y id Fabrica " + idArticuloFabrica2AActualizarStr + "no existe.");
        } else {
            System.out.println("Ingrese sus nuevas existencias (dejar vacio para no cambiar):");
            String nuevaExistencia = tcl.nextLine();
            if (!nuevaExistencia.isEmpty()) {
                try {
                    int existencias = Integer.parseInt(nuevaExistencia);
                    articuloFabricaAActualizar.setExistencias(existencias);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no válido para existencias.");
                }
            }

            System.out.println("Ingrese su nuevo precio (dejar vacio para no cambiar):");
            String nuevoPrecio = tcl.nextLine();
            if (!nuevoPrecio.isEmpty()) {
                try {
                    double precio = Double.parseDouble(nuevoPrecio);
                    articuloFabricaAActualizar.setPrecio(precio);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no válido para el precio.");
                }
            }

            System.out.println("Actualizando el artículo " + idArticuloFabrica1AActualizarStr + " de la fabrica " + idArticuloFabrica2AActualizarStr);
            int columnasAfectadas = dam.updateArticuloFabrica(idArticuloFabrica1AActualizarStr, idArticuloFabrica2AActualizarStr, articuloFabricaAActualizar);

            if (columnasAfectadas > 0) {
                System.out.println("Artículo actualizado exitosamente.");
                ArticuloFabrica articuloFabricaActualizado = dam.loadArticuloFabricaByCode(idArticuloFabrica1AActualizarStr, idArticuloFabrica2AActualizarStr);
                System.out.println(articuloFabricaActualizado.toString());
            } else {
                System.out.println("No se actualizó nada.");
            }
        }
    }

    private static void actualizarCliente(DataAccessManager dam) throws SQLException {

        System.out.print("Ingrese el ID del cliente que desea actualizar: ");
        String idClienteAActualizarStr = tcl.nextLine();

        Cliente clienteAActualizar = dam.loadClienteByCode(idClienteAActualizarStr);

        if (clienteAActualizar == null) {
            System.out.println("El cliente con ID " + idClienteAActualizarStr + " no existe.");
        } else {
            System.out.println("Ingrese el nuevo saldo (dejar vacío para no cambiar):");
            String nuevoSaldoStr = tcl.nextLine();
            if (!nuevoSaldoStr.isEmpty()) {
                try {
                    double nuevoSaldo = Double.parseDouble(nuevoSaldoStr);
                    clienteAActualizar.setSaldo(nuevoSaldo);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no válido para el saldo.");
                }
            }

            System.out.println("Ingrese el nuevo límite de crédito (dejar vacío para no cambiar):");
            String nuevoLimiteCreditoStr = tcl.nextLine();
            if (!nuevoLimiteCreditoStr.isEmpty()) {
                try {
                    double nuevoLimiteCredito = Double.parseDouble(nuevoLimiteCreditoStr);
                    clienteAActualizar.setLimiteCredito(nuevoLimiteCredito);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no válido para el límite de crédito.");
                }
            }

            System.out.println("Ingrese el nuevo descuento (dejar vacío para no cambiar):");
            String nuevoDescuentoStr = tcl.nextLine();
            if (!nuevoDescuentoStr.isEmpty()) {
                try {
                    double nuevoDescuento = Double.parseDouble(nuevoDescuentoStr);
                    clienteAActualizar.setDescuento(nuevoDescuento);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no válido para el descuento.");
                }
            }

            System.out.println("Actualizando el cliente con ID " + idClienteAActualizarStr);
            int columnasAfectadas = dam.updateCliente(idClienteAActualizarStr, clienteAActualizar);

            if (columnasAfectadas > 0) {
                System.out.println("Cliente actualizado exitosamente.");
                Cliente clienteActualizado = dam.loadClienteByCode(idClienteAActualizarStr);
                System.out.println(clienteActualizado.toString());
            } else {
                System.out.println("No se actualizó nada.");
            }
        }

    }

    private static void actualizarDireccionEnvio(DataAccessManager dam) throws SQLException {

        System.out.print("Ingrese el ID de la dirección de envío que desea actualizar: ");
        String idDireccionAActualizarStr = tcl.nextLine();

        DireccionEnvio direccionEnvioAActualizar = dam.loadDireccionEnvioByCode(idDireccionAActualizarStr);

        if (direccionEnvioAActualizar == null) {
            System.out.println("La dirección de envío con ID " + idDireccionAActualizarStr + " no existe.");
        } else {
            System.out.println("Ingrese el nuevo número (dejar vacío para no cambiar):");
            String nuevoNumeroStr = tcl.nextLine();
            if (!nuevoNumeroStr.isEmpty()) {
                try {
                    int nuevoNumero = Integer.parseInt(nuevoNumeroStr);
                    direccionEnvioAActualizar.setNumero(nuevoNumero);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no válido para el número.");
                }
            }

            System.out.println("Ingrese la nueva calle (dejar vacío para no cambiar):");
            String nuevaCalleStr = tcl.nextLine();
            if (!nuevaCalleStr.isEmpty()) {
                direccionEnvioAActualizar.setCalle(nuevaCalleStr);
            }

            System.out.println("Ingrese la nueva comuna (dejar vacío para no cambiar):");
            String nuevaComunaStr = tcl.nextLine();
            if (!nuevaComunaStr.isEmpty()) {
                direccionEnvioAActualizar.setComuna(nuevaComunaStr);
            }

            System.out.println("Ingrese la nueva ciudad (dejar vacío para no cambiar):");
            String nuevaCiudadStr = tcl.nextLine();
            if (!nuevaCiudadStr.isEmpty()) {
                direccionEnvioAActualizar.setCiudad(nuevaCiudadStr);
            }

            System.out.println("Ingrese el ID del cliente asociado (dejar vacío para no cambiar):");
            String nuevoIdClienteStr = tcl.nextLine();
            if (!nuevoIdClienteStr.isEmpty()) {
                int nuevoIdCliente = Integer.parseInt(nuevoIdClienteStr);
                if (dam.clienteExiste(nuevoIdCliente)) {
                    direccionEnvioAActualizar.setIdCliente(nuevoIdCliente);
                } else {
                    System.out.println("El cliente con ID " + nuevoIdCliente + " no existe.");
                    return;
                }
            }

            System.out.println("Actualizando la dirección de envío con ID " + idDireccionAActualizarStr);
            int columnasAfectadas = dam.updateDireccionEnvio(idDireccionAActualizarStr, direccionEnvioAActualizar);

            if (columnasAfectadas > 0) {
                System.out.println("Dirección de envío actualizada exitosamente.");
                DireccionEnvio direccionEnvioActualizada = dam.loadDireccionEnvioByCode(idDireccionAActualizarStr);
                System.out.println(direccionEnvioActualizada.toString());
            } else {
                System.out.println("No se actualizó nada.");
            }
        }

    }

    private static void actualizarFabricaAlternativa(DataAccessManager dam) throws SQLException {

        System.out.print("Ingrese el ID de la fábrica principal que desea actualizar: ");
        String idFabricaPrincipalStr = tcl.nextLine();
        System.out.print("Ingrese el ID de la fábrica alternativa que desea actualizar: ");
        String idFabricaAlternativaStr = tcl.nextLine();

        FabricaAlternativa fabricaAlternativaAActualizar = dam.loadFabricaAlternativaByCode(idFabricaPrincipalStr, idFabricaAlternativaStr);

        if (fabricaAlternativaAActualizar == null) {
            System.out.println("La fábrica alternativa con ID principal " + idFabricaPrincipalStr + " y alternativa " + idFabricaAlternativaStr + " no existe.");
            return;
        } else {
            System.out.println("Ingrese el nuevo ID de la fábrica principal (dejar vacío para no cambiar):");
            String nuevoIdFabricaPrincipalStr = tcl.nextLine();
            if (!nuevoIdFabricaPrincipalStr.isEmpty()) {
                int nuevoIdFabricaPrincipal = Integer.parseInt(nuevoIdFabricaPrincipalStr);
                if (!dam.fabricaExiste(nuevoIdFabricaPrincipal)) {
                    System.out.println("Error: La fábrica principal con ID " + nuevoIdFabricaPrincipal + " no existe.");
                    esperarIntro();
                    return;
                }
                fabricaAlternativaAActualizar.setIdFabricaPrincipal(nuevoIdFabricaPrincipal);
            }
            System.out.println("Ingrese el nuevo ID de la fábrica alternativa asociada a esa fabrica principal (dejar vacío para no cambiar):");
            String nuevoIdFabricaAlternativaStr = tcl.nextLine();
            if (!nuevoIdFabricaAlternativaStr.isEmpty()) {
                int nuevoIdFabricaAlternativa = Integer.parseInt(nuevoIdFabricaAlternativaStr);
                if (!dam.fabricaExiste(nuevoIdFabricaAlternativa)) {
                    System.out.println("Error: La fábrica alternativa con ID " + nuevoIdFabricaAlternativa + " no existe.");
                    esperarIntro();
                    return;
                }
                fabricaAlternativaAActualizar.setIdFabricaAlternativa(nuevoIdFabricaAlternativa);
            }

            if (nuevoIdFabricaPrincipalStr.equals(nuevoIdFabricaAlternativaStr)) {
                System.out.println("Error: El ID de la fábrica principal no puede ser el mismo que el ID de la fábrica alternativa.");
                esperarIntro();
                return;
            }

            if (!dam.fabricaAlternativaExiste(nuevoIdFabricaPrincipalStr, nuevoIdFabricaAlternativaStr)) {
                System.out.println("Error: La combinación de ID principal " + nuevoIdFabricaPrincipalStr + " y ID alternativa " + nuevoIdFabricaAlternativaStr + " ya existe.");
                return;
            }

            System.out.println("Actualizando la fábrica alternativa con ID principal " + idFabricaPrincipalStr + " y alternativa " + idFabricaAlternativaStr);

            int columnasAfectadas = dam.updateFabricaAlternativa(idFabricaPrincipalStr, idFabricaAlternativaStr, fabricaAlternativaAActualizar);
            if (columnasAfectadas > 0) {
                System.out.println("Fábrica alternativa actualizada exitosamente.");
                FabricaAlternativa fabricaAlternativaActualizada = dam.loadFabricaAlternativaByCode(idFabricaPrincipalStr, idFabricaAlternativaStr);
                System.out.println(fabricaAlternativaActualizada.toString());
            } else {
                System.out.println("No se actualizó nada.");
            }
        }
    }

    private static void actualizarFabrica(DataAccessManager dam) throws SQLException {

        System.out.print("Ingrese el ID de la fábrica que desea actualizar: ");
        String idFabricaAActualizarStr = tcl.nextLine();

        Fabrica fabricaAActualizar = dam.loadFabricaByCode(idFabricaAActualizarStr);

        if (fabricaAActualizar == null) {
            System.out.println("La fábrica con ID " + idFabricaAActualizarStr + " no existe.");
        } else {
            System.out.println("Ingrese el nuevo teléfono de contacto (dejar vacío para no cambiar):");
            String nuevoTelefonoStr = tcl.nextLine();
            if (!nuevoTelefonoStr.isEmpty()) {
                fabricaAActualizar.setTelefonoContacto(nuevoTelefonoStr);
            }

            System.out.println("Actualizando la fábrica con ID " + idFabricaAActualizarStr);
            int columnasAfectadas = dam.updateFabrica(idFabricaAActualizarStr, fabricaAActualizar);

            if (columnasAfectadas > 0) {
                System.out.println("Fábrica actualizada exitosamente.");
                Fabrica fabricaActualizada = dam.loadFabricaByCode(idFabricaAActualizarStr);
                System.out.println(fabricaActualizada.toString());
            } else {
                System.out.println("No se actualizó nada.");
            }
        }

    }

    private static void actualizarLineaPedido(DataAccessManager dam) throws SQLException {

        System.out.print("Ingrese el ID de la línea de pedido que desea actualizar: ");
        String idLineaPedidoAActualizar = tcl.nextLine();

        LineaPedido lineaPedidoAActualizar = dam.loadLineaPedidoByCode(idLineaPedidoAActualizar);

        if (lineaPedidoAActualizar == null) {
            System.out.println("La línea de pedido con ID " + idLineaPedidoAActualizar + " no existe.");
        } else {
            System.out.println("Ingrese el nuevo ID de pedido (dejar vacío para no cambiar):");
            String nuevoIdPedidoStr = tcl.nextLine();
            if (!nuevoIdPedidoStr.isEmpty()) {
                int nuevoIdPedido = Integer.parseInt(nuevoIdPedidoStr);
                if (dam.pedidoExiste(nuevoIdPedido)) {
                    lineaPedidoAActualizar.setIdPedido(nuevoIdPedido);
                } else {
                    System.out.println("El nuevo ID de pedido " + nuevoIdPedido + " no existe.");
                    return;
                }
            }

            System.out.println("Ingrese el nuevo ID de artículo (dejar vacío para no cambiar):");
            String nuevoIdArticuloStr = tcl.nextLine();
            if (!nuevoIdArticuloStr.isEmpty()) {
                int nuevoIdArticulo = Integer.parseInt(nuevoIdArticuloStr);
                if (dam.articuloExiste(nuevoIdArticulo)) {
                    lineaPedidoAActualizar.setIdArticulo(nuevoIdArticulo);
                } else {
                    System.out.println("El nuevo ID de articulo " + nuevoIdArticulo + " no existe.");
                    return;
                }
            }

            System.out.println("Ingrese la nueva cantidad (dejar vacío para no cambiar):");
            String nuevaCantidadStr = tcl.nextLine();
            if (!nuevaCantidadStr.isEmpty()) {
                lineaPedidoAActualizar.setCantidad(Integer.parseInt(nuevaCantidadStr));
            }

            System.out.println("Actualizando la línea de pedido con ID " + idLineaPedidoAActualizar);
            int columnasAfectadas = dam.updateLineaPedido(idLineaPedidoAActualizar, lineaPedidoAActualizar);

            if (columnasAfectadas > 0) {
                System.out.println("Línea de pedido actualizada exitosamente.");
                LineaPedido lineaPedidoActualizada = dam.loadLineaPedidoByCode(idLineaPedidoAActualizar);
                System.out.println(lineaPedidoActualizada.toString());
            } else {
                System.out.println("No se actualizó nada.");
            }
        }

    }

    private static void actualizarPedido(DataAccessManager dam) throws SQLException {

        System.out.print("Ingrese el ID del pedido que desea actualizar: ");
        String idPedidoAActualizar = tcl.nextLine();

        Pedido pedidoAActualizar = dam.loadPedidoByCode(idPedidoAActualizar);

        if (pedidoAActualizar == null) {
            System.out.println("El pedido con ID " + idPedidoAActualizar + " no existe.");
        } else {
            System.out.println("Ingrese la nueva fecha (formato: YYYY-MM-DD HH:MM:SS) (dejar vacío para no cambiar):");
            String nuevaFechaStr = tcl.nextLine();
            if (!nuevaFechaStr.isEmpty()) {
                try {
                    Timestamp nuevaFecha = Timestamp.valueOf(nuevaFechaStr);
                    pedidoAActualizar.setFecha(nuevaFecha);
                } catch (IllegalArgumentException e) {
                    System.out.println("Fecha no válida. Asegúrese de usar el formato correcto: YYYY-MM-DD HH:MM:SS");
                    return;
                }
            }

            System.out.println("Ingrese el nuevo número de comanda (dejar vacío para no cambiar):");
            String nuevoNumeroComandaStr = tcl.nextLine();
            if (!nuevoNumeroComandaStr.isEmpty()) {
                int nuevoNumeroComanda = Integer.parseInt(nuevoNumeroComandaStr);
                pedidoAActualizar.setNumeroComanda(nuevoNumeroComanda);
            }

            System.out.println("Ingrese el nuevo ID de cliente (dejar vacío para no cambiar):");
            String nuevoIdClienteStr = tcl.nextLine();
            if (!nuevoIdClienteStr.isEmpty()) {
                int nuevoIdCliente = Integer.parseInt(nuevoIdClienteStr);
                if (dam.clienteExiste(nuevoIdCliente)) {
                    pedidoAActualizar.setIdCliente(nuevoIdCliente);
                } else {
                    System.out.println("El nuevo ID de cliente " + nuevoIdCliente + " no existe.");
                    return;
                }
            }

            System.out.println("Ingrese el nuevo ID de dirección (dejar vacío para no cambiar):");
            String nuevoIdDireccionStr = tcl.nextLine();
            if (!nuevoIdDireccionStr.isEmpty()) { 
                int nuevoIdDireccion = Integer.parseInt(nuevoIdDireccionStr);
                if (dam.direccionExiste(nuevoIdDireccion)) {
                    pedidoAActualizar.setIdDireccion(nuevoIdDireccion);
                } else {
                    System.out.println("El nuevo ID de dirección " + nuevoIdDireccion + " no existe.");
                    return;
                }
            }

            System.out.println("Actualizando el pedido con ID " + idPedidoAActualizar);
            int columnasAfectadas = dam.updatePedido(idPedidoAActualizar, pedidoAActualizar);

            if (columnasAfectadas > 0) {
                System.out.println("Pedido actualizado exitosamente.");
                Pedido pedidoActualizado = dam.loadPedidoByCode(idPedidoAActualizar);
                System.out.println(pedidoActualizado.toString()); 
            } else {
                System.out.println("No se actualizó nada.");
            }
        }
    }

    //METODO 1//

    //SACAMOS LA LISTA DE PEDIDOS DE ESE CLIENTE
    public static List<Pedido> consultarPedidosCliente(DataAccessManager dam, String idCliente) throws SQLException {

        List<Pedido> pedidosFilteredByClient = dam.listarPedidosCliente(idCliente);
        if (pedidosFilteredByClient != null) {
            System.out.println("Pedidos hechos por el cliente " + idCliente);
            printPedidos(pedidosFilteredByClient);
        } else {
            System.out.println("No se encontraron pedidos con el id de ese cliente.");
            
        }
        return pedidosFilteredByClient;
    }

    //CON LOS PEDIDOS DE ESE CLIENTE - SACAMOS LAS LINEAS Y LAS CALCULAMOS
    public static double sacarPrecioTotalClientePedidos(DataAccessManager dam, String idCliente) throws SQLException {

        List<Pedido> pedidosCliente = consultarPedidosCliente(dam, idCliente);
        List<LineaPedido> lineasPedidoCliente = dam.filtrarPedidos(pedidosCliente);
        double importeTotalCliente = 0;

        if (lineasPedidoCliente != null && !lineasPedidoCliente.isEmpty()) {
            System.out.println("Líneas de pedido asociadas a estos pedidos:");
            printLineasPedido(lineasPedidoCliente);

            for (LineaPedido linea : lineasPedidoCliente) {
                int idArticulo = linea.getIdArticulo();
                String idArticuloStr = String.valueOf(idArticulo);
                Articulo articulo = dam.loadArticuloByCode(idArticuloStr); //PARA PODER PONER LA DESCRIPCION (printearArticulo)

                if (articulo != null) {
                    System.out.println("----------------------------");
                    System.out.println("Información del artículo asociado (ID: " + idArticulo + "):");
                    printArticulo(articulo);
                    System.out.println(" - cantidad pedida = " + linea.getCantidad());

                    double precioPorArticulo = dam.sacarPrecioArticulo(idArticuloStr); //SACAMOS PRECIO (con IDArticulo)
                    double totalLinea = precioPorArticulo * linea.getCantidad();
                    importeTotalCliente += totalLinea;

                    System.out.println(" - Precio por artículo: " + precioPorArticulo);
                    System.out.println(" - Total por esta línea: " + String.format("%.2f",totalLinea));
                    System.out.println("----------------------------");
                } else {
                    System.out.println("No se encontró artículo con ID: " + idArticulo);
                }
            }
            System.out.println("");
        } else {
            System.out.println("No se encontraron líneas de pedido con los IDs de pedido asociados a ese cliente.");
        }

        return importeTotalCliente;
    }

    public static double precioTotalClienteDescontado(DataAccessManager dam, String idCliente) throws SQLException {

        //SACAR EL PRECIO ASOCIADO AL CLIENTE
        double precioTotalSinDescuento = sacarPrecioTotalClientePedidos(dam, idCliente);
        //SACAR DESCUENTO
        double descuento = dam.sacarDescuento(idCliente) / 100;

        //CALCULAR PRECIO CLIENTE + DESCUENTO
        double precioTotalConDescuento = precioTotalSinDescuento * (1 - descuento);

        System.out.println("El precio total sin descuento es: " + String.format("%.2f",precioTotalSinDescuento));
        System.out.println("El descuento aplicado es: " + (descuento * 100) + "%");
        System.out.println("El precio total con descuento es: " + String.format("%.2f", precioTotalConDescuento));
        System.out.println("Has pagado " + String.format("%.2f", (precioTotalSinDescuento - precioTotalConDescuento)) + " euros menos ");

        return precioTotalConDescuento;
    }

    //PRINTEAR LOS 3 METODOS A LA VEZ - dar cliente
    public static void printImporteTotalCliente(DataAccessManager dam) throws SQLException {

        System.out.println("Listado de comandas con importe y descuento");
        System.out.println("Escribeme el id del cliente al que queremos ver los pedidos");
        String idCliente = tcl.nextLine();
        precioTotalClienteDescontado(dam, idCliente);
    }

    
    //METODO 2
    /*
    ii. Método que borre todas las fábricas a las que no se haya pedido ningún artículo que se haya incluido en ningún pedido en el momento de consulta de la BD. (2 puntos)
    Fabricas(idFabrica) - borramos por aqui
    ArticuloFabrica(idFabrica,idArticulo)  - Las fabricas tienen articulos (lista idArticulos)
    -articulos vinculados a pedidos (lineaPedido-idPedido-idArticulo)  (de esos idArticulos revisar los que NO se encuentran en LineaPedido)
    */
    
    public static List<String> FiltrarFabricasSinPedido(DataAccessManager dam) throws SQLException{
        
        System.out.println("Mostramos las fabricas sin artículos asociados a pedidos.");
         List<String> fabricasSinPedidos = dam.filtrarFabricasSinPedido();

            // Imprimir los resultados
            if (fabricasSinPedidos.isEmpty()) {
                System.out.println("No se encontraron fábricas sin artículos asociados a pedidos.");
            } else {
                System.out.println("Id de las fábricas sin artículos asociados a pedidos:");
                for (String idFabrica : fabricasSinPedidos) {
                    System.out.println("Id fabrica = " +  idFabrica + " sin artículos asociados a pedidos");
                }
            }
            
        return fabricasSinPedidos;
    }

    public static void borrarFabricasSinArticuloPedido(DataAccessManager dam) throws SQLException {

        List<String> fabricasSinPedidos = FiltrarFabricasSinPedido(dam);
        
        System.out.println("Procedemos a borrar las fabricas sin artículos asociados a pedidos");
        int numFabricasBorradas = dam.borrarFabricasSinArticulosAsociadosAPedido(fabricasSinPedidos);

        if (numFabricasBorradas > 0) {
            System.out.println("Fabricas con articulos asociados a pedidos borradas exitosamente. Se borraron = " + numFabricasBorradas);
        } else {
            System.out.println("No se borró nada.");
        }
    }

     //METODO 3
    /*
    iii. Método que calcule la cantidad total de artículos incluidos en todos los pedidos de un año dado. (1 punto)
    ¿Cantidad de numero de articulos? (lapiz + boli) o (39 lapices + 40 bolis..)
    -PedidoDAO - atributo fecha - idPedido - (lista de pedidos de un año en concreto) 
    -LineaPedidoDAO - idPedido - idArticulo - CANTIDAD (lista de idsPedido - lista idArticulos + cantidad) = sumar esas cantidades
    */
    
    public static List<Pedido> filtrarPedidosAño(DataAccessManager dam) throws SQLException{ //calcularCantidadTotalArticulosPedidos
        
        int añoInput = 2024;
        //Filtro todos los pedidos de un año
        List<Pedido> listaPedidosAño = dam.listarPedidosPorAño(añoInput);
        
        // Imprimir los resultados
            if (listaPedidosAño .isEmpty()) {
                System.out.println("No se encontraron pedidos para ese año");
            } else {
                System.out.println("Pedidos realizados en el año " + añoInput);
            // Imprimir cada pedido filtrado
            for (Pedido pedido : listaPedidosAño) {
                System.out.println(pedido.toString());
            }
        }

        return listaPedidosAño;
    }

    public static double calcularCantidadTotalArticulosPedidosAño(DataAccessManager dam) throws SQLException {

        //Saco todos los articulos asociados a esos pedidos (lineaPedidoDAO)
        //Sumo las cantidades
        List<Pedido> listaPedidosAño = filtrarPedidosAño(dam);
        if (listaPedidosAño.isEmpty()) {
            System.out.println("La lista está vacia");
        } else {
            
            double totalArticulos = 0;

            /*
            // Recorremos los pedidos sacar todos los articulos diferentes
            for (Pedido pedido : listaPedidosAño) {
                // Obtener todas las líneas de pedido asociadas a este pedido
                List<LineaPedido> lineasPedido = dam.filtrarLineasPedidosIdPedido(pedido.getIdPedido());

                // Sumamos las cantidades de artículos en cada línea de pedido
                for (LineaPedido linea : lineasPedido) {
                    totalArticulos += linea.getCantidad();
                }
            }*/

            return totalArticulos;
        }

        return 0;

    }
}
