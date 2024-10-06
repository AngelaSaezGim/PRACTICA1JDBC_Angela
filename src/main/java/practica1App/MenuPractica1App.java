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

/**
 *
 * @author angsaegim
 */
public class MenuPractica1App {

    private static Scanner tcl = new Scanner(System.in);

    //Opciones del menú principal
    private enum MenuOption {
        QUERY_ALL, QUERY_BY_CODE, QUERY_INSERT,QUERY_DELETE,QUERY_UPDATE, EXIT
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

        try (DataAccessManager dam = DataAccessManager.getInstance()) {
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
                                    break;
                            }
                        } while (opcionElegidaUpdate != MenuOption5.ATRAS);
                        break;
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
                .append("\t6)Salir\n")
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
    
    private static String requestContentArticuloFabricaLike() {
        System.out.print("Escriba el id del articulo; ");
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
        String idFabrica = requestContentArticuloFabricaLike();
        System.out.println("Valores leídos -> idArticulo: " + idArticulo + ", Asociado a la fabrica: " + idFabrica);
        
        List<ArticuloFabrica> articulosFabricaFilteredByCode = dam.loadArticulosFabricaContaining(idArticulo,idFabrica);
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
        String idFabricaAlternativa = requestContentArticuloFabricaLike();
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

        ArticuloFabrica nuevoArticuloFabrica = new ArticuloFabrica(idFabrica,existencias,precio);

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
            System.out.println("La direccion de envio asociada al cliente "+ idCliente +" ha sido insertada correctamente.");
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

        // Verificar que ambos IDs no sean iguales
        if (idFabricaPrincipal == idFabricaAlternativa) {
            System.out.println("Error: El ID de la fábrica principal no puede ser el mismo que el ID de la fábrica alternativa.");
            esperarIntro();
            return; 
        }

        // Verificar que la fábrica principal existe
        if (!dam.fabricaExiste(idFabricaPrincipal)) {
            System.out.println("Error: La fábrica principal con ID " + idFabricaPrincipal + " no existe.");
            esperarIntro();
            return;
        }

        // Verificar que la fábrica alternativa existe
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
        String telefonoContacto = tcl.next();

        Fabrica nuevaFabrica = new Fabrica(telefonoContacto); 

        // Intentar insertar la nueva fábrica
        try {
            dam.insertarFabrica(nuevaFabrica);
            System.out.println("La fábrica ha sido insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la fábrica: " + e.getMessage());
            throw e;
        }

    }
     
     
    private static void insertarLineaPedido(DataAccessManager dam) throws SQLException {

        // Solicitar los datos al usuario
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
}
