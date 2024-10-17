/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1App;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.InputMismatchException;
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

/**
 *
 * @author angsaegim
 */
public class MetodosMenu {

    static Scanner tcl = new Scanner(System.in);

    public static void esperarIntro() {
        System.out.println("Presione Enter para continuar...");
        tcl.nextLine();
    }

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

    private static String requestContentDelete() {
        System.out.print("Escriba el id a borrar; ");
        return readNotEmptyString();
    }

    //***************************** FUNCIONES LANZADAS - DATA ACCESS MANAGER *****************************/
    public static void verArticulos(DataAccessManager dam) throws SQLException {
        List<Articulo> allArticulos = dam.loadAllArticulos();
        printArticulos(allArticulos);
    }

    public static void printArticulos(List<Articulo> articulos) {
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

    public static void verArticulosFabrica(DataAccessManager dam) throws SQLException {
        List<ArticuloFabrica> allArticulosFabrica = dam.loadAllArticulosFabrica();
        printArticulosFabrica(allArticulosFabrica);
    }

    public static void printArticulosFabrica(List<ArticuloFabrica> articulosFabrica) {
        if (articulosFabrica == null || articulosFabrica.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (ArticuloFabrica articuloFabrica : articulosFabrica) {
            System.out.println("\t" + articuloFabrica);
        }
        System.out.println();
    }

    public static void verClientes(DataAccessManager dam) throws SQLException {
        List<Cliente> allClientes = dam.loadAllClientes();
        printClientes(allClientes);
    }

    public static void printClientes(List<Cliente> clientes) {
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println("\t" + cliente);
        }
        System.out.println();
    }

    public static void verDireccionesEnvio(DataAccessManager dam) throws SQLException {
        List<DireccionEnvio> allDireccionesEnvio = dam.loadAllDireccionesEnvio();
        printDireccionesEnvio(allDireccionesEnvio);
    }

    public static void printDireccionesEnvio(List<DireccionEnvio> direccionesEnvio) {
        if (direccionesEnvio == null || direccionesEnvio.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (DireccionEnvio direccionEnvio : direccionesEnvio) {
            System.out.println("\t" + direccionEnvio);
        }
        System.out.println();
    }

    public static void verFabricasAlternativas(DataAccessManager dam) throws SQLException {
        List<FabricaAlternativa> allFabricasAlternativas = dam.loadAllFabricasAlternativas();
        printFabricasAlternativas(allFabricasAlternativas);
    }

    public static void printFabricasAlternativas(List<FabricaAlternativa> fabricasAlternativas) {
        if (fabricasAlternativas == null || fabricasAlternativas.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (FabricaAlternativa fabricaAlternativa : fabricasAlternativas) {
            System.out.println("\t" + fabricaAlternativa);
        }
        System.out.println();
    }

    public static void verFabricas(DataAccessManager dam) throws SQLException {
        List<Fabrica> allFabricas = dam.loadAllFabricas();
        printFabricas(allFabricas);
    }

    public static void printFabricas(List<Fabrica> fabricas) {
        if (fabricas == null || fabricas.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (Fabrica fabrica : fabricas) {
            System.out.println("\t" + fabrica);
        }
        System.out.println();
    }

    public static void verLineasPedido(DataAccessManager dam) throws SQLException {
        List<LineaPedido> allLineasPedido = dam.loadAllLineasPedido();
        printLineasPedido(allLineasPedido);
    }

    public static void printLineasPedido(List<LineaPedido> lineasPedido) {
        if (lineasPedido == null || lineasPedido.isEmpty()) {
            System.out.println("No hay registros...");
            return;
        }

        for (LineaPedido lineaPedido : lineasPedido) {
            System.out.println("\t" + lineaPedido);
        }
        System.out.println();
    }

    public static void verPedidos(DataAccessManager dam) throws SQLException {
        List<Pedido> allPedidos = dam.loadAllPedidos();
        printPedidos(allPedidos);
    }

    public static void printPedidos(List<Pedido> pedidos) {
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

    /*SOLICITAR TODO*/
    public static void solicitarArticulos(DataAccessManager dam) throws SQLException {

        System.out.print("- Quieres ver los articulos actuales de la base de datos?\n 1 - sí / 0 - no ");
        int respuesta = tcl.nextInt();
        if (respuesta == 1) {
            verArticulos(dam);
        }
    }

    public static void solicitarArticulosFabrica(DataAccessManager dam) throws SQLException {

        System.out.print("- Quieres ver los articulos de fabrica actuales de la base de datos?\n 1 - sí / 0 - no ");
        int respuesta = tcl.nextInt();
        if (respuesta == 1) {
            verArticulosFabrica(dam);
        }
    }

    public static void solicitarClientes(DataAccessManager dam) throws SQLException {
        System.out.print("- Quieres ver los clientes actuales de la base de datos?\n 1 - sí / 0 - no ");
        int respuesta = tcl.nextInt();
        if (respuesta == 1) {
            verClientes(dam);
        }
    }

    public static void solicitarDireccionesEnvio(DataAccessManager dam) throws SQLException {

        System.out.print("- Quieres ver las direcciones de envio actuales de la base de datos?\n 1 - sí / 0 - no ");
        int respuesta = tcl.nextInt();
        if (respuesta == 1) {
            verDireccionesEnvio(dam);
        }
    }

    public static void solicitarFabricasAlternativas(DataAccessManager dam) throws SQLException {

        System.out.print("- Quieres ver las fabricas alternativas de la base de datos?\n 1 - sí / 0 - no ");
        int respuesta = tcl.nextInt();
        if (respuesta == 1) {
            verFabricasAlternativas(dam);
        }
    }

    public static void solicitarFabricas(DataAccessManager dam) throws SQLException {

        System.out.print("- Quieres ver las fabricas actuales de la base de datos?\n 1 - sí / 0 - no");
        int respuesta = tcl.nextInt();
        if (respuesta == 1) {
            verFabricas(dam);
        }
    }

    public static void solicitarLineasPedido(DataAccessManager dam) throws SQLException {

        System.out.print("- Quieres ver las lineas pedidos actuales de la base de datos?\n 1 - sí / 0 - no ");
        int respuesta = tcl.nextInt();
        if (respuesta == 1) {
            verLineasPedido(dam);
        }
    }

    public static void solicitarPedidos(DataAccessManager dam) throws SQLException {

        System.out.print("- Quieres ver los pedidos actuales de la base de datos?\n 1 - sí / 0 - no ");
        int respuesta = tcl.nextInt();
        if (respuesta == 1) {
            verPedidos(dam);
        }
    }

    //DEVUELVEN LISTAS (MOSTRAR POR...)
    public static void searchArticuloByCode(DataAccessManager dam) throws SQLException {
        System.out.println("Vamos a filtar un articulo concreto por su ID");
        solicitarArticulos(dam);
        String idArticulo = requestContentLike();
        List<Articulo> articulosFilteredByCode = dam.loadArticulosContaining(idArticulo);
        if (articulosFilteredByCode != null) {
            printArticulos(articulosFilteredByCode);
        } else {
            System.out.println("No se encontraron articulos con el código especificado.");
        }
    }

    public static void searchArticuloFabricaByCode(DataAccessManager dam) throws SQLException {
        
        System.out.println("Vamos a filtar un articulo de fabrica concreto por su ID");
        solicitarArticulosFabrica(dam);
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

    public static void searchClienteByCode(DataAccessManager dam) throws SQLException {
        System.out.println("Vamos a filtar un cliente concreto por su ID");
        solicitarClientes(dam);
        String idCliente = requestContentLike();
        List<Cliente> clientesFilteredByCode = dam.loadClientesContaining(idCliente);
        if (clientesFilteredByCode != null) {
            printClientes(clientesFilteredByCode);
        } else {
            System.out.println("No se encontraron articulos con el código especificado.");
        }
    }

    public static void searchDireccionEnvioByCode(DataAccessManager dam) throws SQLException {
        System.out.println("Vamos a filtar una direccion concreta por su ID");
        solicitarDireccionesEnvio(dam);
        String idDireccionEnvio = requestContentLike();
        List<DireccionEnvio> direccionesEnvioFilteredByCode = dam.loadDireccionEnvioContaining(idDireccionEnvio);
        if (direccionesEnvioFilteredByCode != null) {
            printDireccionesEnvio(direccionesEnvioFilteredByCode);
        } else {
            System.out.println("No se encontraron direcciones de envío con el código especificado.");
        }
    }

    public static void searchFabricaAlternativaByCode(DataAccessManager dam) throws SQLException {
        System.out.println("Vamos a filtar una fabrica alternativa concreta por sus IDs");
        solicitarFabricasAlternativas(dam);
        System.out.println("ID de la fabrica principal");
        String idFabricaPrincipal = requestContentLike();
        System.out.println("ID de la fabrica alternativa asociada a esa fabrica principal");
        String idFabricaAlternativa = requestContentLike();
        System.out.println("Valores leídos -> Fabrica Principal: " + idFabricaPrincipal + ", - Su fabrica alternativa: " + idFabricaAlternativa);

        List<FabricaAlternativa> fabricaAlternativaFilteredByCode = dam.loadFabricaAlternativaContaining(idFabricaPrincipal, idFabricaAlternativa);
        if (fabricaAlternativaFilteredByCode != null) {
            printFabricasAlternativas(fabricaAlternativaFilteredByCode);
        } else {
            System.out.println("No se encontraron fabricas alternativas con esas ids");
        }
    }

    public static void searchFabricaByCode(DataAccessManager dam) throws SQLException {
        System.out.println("Vamos a filtar una fabrica concreta por sus IDs");
        solicitarFabricas(dam);
        String idFabrica = requestContentLike();
        List<Fabrica> fabricasFilteredByCode = dam.loadFabricasContaining(idFabrica);
        if (fabricasFilteredByCode != null) {
            printFabricas(fabricasFilteredByCode);
        } else {
            System.out.println("No se encontraron fábricas con el código especificado.");
        }
    }

    public static void searchLineaPedidoByCode(DataAccessManager dam) throws SQLException {
        System.out.println("Vamos a filtar una linea pedido concreta por sus ID");
        solicitarLineasPedido(dam);
        String idLineaPedido = requestContentLike();
        List<LineaPedido> lineasPedidoFilteredByCode = dam.loadLineasPedidoContaining(idLineaPedido);
        if (lineasPedidoFilteredByCode != null) {
            printLineasPedido(lineasPedidoFilteredByCode);
        } else {
            System.out.println("No se encontraron líneas de pedido con el código especificado.");
        }
    }

    public static void searchPedidoByCode(DataAccessManager dam) throws SQLException {
        System.out.println("Vamos a filtar un pedido concreto por su ID");
        solicitarPedidos(dam);
        String idPedido = requestContentLike();
        List<Pedido> pedidosFilteredByCode = dam.loadPedidosContaining(idPedido);
        if (pedidosFilteredByCode != null) {
            printPedidos(pedidosFilteredByCode);
        } else {
            System.out.println("No se encontraron pedidos con el código especificado.");
        }
    }

//*INSERT*/
    public static void insertarArticulo(DataAccessManager dam) throws SQLException {

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

    public static void insertarArticuloFabrica(DataAccessManager dam) throws SQLException {

        System.out.println("Cual es la id del articulo de esta fabrica");
        solicitarArticulos(dam);
        System.out.println("Id del articulo:");
        int idArticulo = tcl.nextInt();

        if (!dam.articuloExiste(idArticulo)) {
            System.out.println("Error: El articulo con id " + idArticulo + " no existe.");
            esperarIntro();
            return;
        }

        System.out.println("A que fabrica pertenece este nuevo articulo: ");
        solicitarFabricas(dam);
        System.out.println("Id de fabrica: ");
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

    public static void insertarCliente(DataAccessManager dam) throws SQLException {

        System.out.print("Escriba el saldo del cliente ");
        double saldo = tcl.nextDouble();

        System.out.print("Escriba el limite de credito del cliente (no puede superar 18,000) ");
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

    public static void insertarDireccionEnvio(DataAccessManager dam) throws SQLException {

        System.out.print("Escriba el número de la dirección: ");
        int numero = tcl.nextInt();

        System.out.print("Escriba la calle de la dirección: ");
        String calle = tcl.next();

        System.out.print("Escriba la comuna de la dirección: ");
        String comuna = tcl.next();

        System.out.print("Escriba la ciudad de la dirección: ");
        String ciudad = tcl.next();

        System.out.print("Escriba el ID del cliente asociado a esa direccion: ");
        solicitarClientes(dam);
        System.out.println("Id del cliente asociado a esa direccion");
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

    public static void insertarFabricaAlternativa(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de insertar una fabrica alternativa, te recomiendo consultar las fabricas actuales ");
        solicitarFabricas(dam);

        System.out.print("Escriba el id de la fabrica principal asociada a esa fabrica alternativa ");
        int idFabricaPrincipal = tcl.nextInt();

        System.out.print("Escriba el id de la fabrica alternativa (no puede ser el mismo que la fabrica principal)");
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

    public static void insertarFabrica(DataAccessManager dam) throws SQLException {

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

    public static void insertarLineaPedido(DataAccessManager dam) throws SQLException {

        System.out.print("Escriba el ID del pedido: ");
        solicitarPedidos(dam);
        System.out.print("Escriba el ID del pedido: ");
        int idPedido = tcl.nextInt();

        if (!dam.pedidoExiste(idPedido)) {
            System.out.println("Error: El pedido con ID " + idPedido + " no existe.");
            esperarIntro();
            return;
        }

        System.out.print("Escriba el ID del artículo: ");
        solicitarArticulos(dam);
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

    public static void insertarPedido(DataAccessManager dam) throws SQLException {

        System.out.println("Se creará un pedido");

        System.out.println("Ingrese fecha (formato: YYYY-MM-DD HH:MM:SS) (dejar vacío para poner la fecha actual):");
        String fechaStr = tcl.nextLine();
        Timestamp fechaPedido;

        if (!fechaStr.isEmpty()) {
            try {
                fechaPedido = Timestamp.valueOf(fechaStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Fecha no válida. Asegúrese de usar el formato correcto: YYYY-MM-DD HH:MM:SS");
                return;
            }
        } else {
            // Si no damos fecha - fecha actual
            fechaPedido = new Timestamp(System.currentTimeMillis());
        }

        System.out.print("Escriba el número de la comanda: ");
        int numeroComanda = tcl.nextInt();

        System.out.print("Escriba el ID del cliente: ");
        solicitarClientes(dam);
        System.out.print("Escriba el ID del cliente: ");
        int idCliente = tcl.nextInt();

        if (!dam.clienteExiste(idCliente)) {
            System.out.println("Error: El cliente con ID " + idCliente + " no existe.");
            esperarIntro();
            return;
        }

        System.out.print("Escriba el ID de la dirección de envío: ");
        solicitarDireccionesEnvio(dam);
        System.out.print("Escriba el ID de la dirección de envío: ");
        int idDireccion = tcl.nextInt();

        if (!dam.direccionExiste(idDireccion)) {
            System.out.println("Error: La dirección de envío con ID " + idDireccion + " no existe.");
            esperarIntro();
            return;
        }

        Pedido nuevoPedido = new Pedido(fechaPedido, numeroComanda, idCliente, idDireccion);

        try {
            dam.insertarPedido(nuevoPedido);
            System.out.println("El pedido ha sido insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el pedido: " + e.getMessage());
            throw e;
        }

    }

    //*DELETE*//
    //SOLUCIONAR DEPENDENCIAS AL BORRAR - ON DELETE CASCADE
    public static void borrarArticulo(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de borrar;");
        solicitarArticulos(dam);
        String idArticulo = requestContentDelete();
        int columnasAfectadas = dam.borrarArticulo(idArticulo);
        if (columnasAfectadas > 0) {
            System.out.println("Articulo borrado exitosamente");
        } else {
            System.out.println("No se encontraron articulos con el código especificado para borrar.");
        }
    }

    public static void borrarArticuloFabrica(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de borrar;");
        solicitarArticulosFabrica(dam);
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

    public static void borrarCliente(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de borrar;");
        solicitarClientes(dam);
        String idCliente = requestContentDelete();
        int columnasAfectadas = dam.borrarCliente(idCliente);
        if (columnasAfectadas > 0) {
            System.out.println("Cliente borrado exitosamente");
        } else {
            System.out.println("No se encontraron clientes con el código especificado para borrar.");
        }
    }

    public static void borrarDireccionEnvio(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de borrar;");
        solicitarDireccionesEnvio(dam);
        String idDireccion = requestContentDelete();
        int columnasAfectadas = dam.borrarDireccionEnvio(idDireccion);
        if (columnasAfectadas > 0) {
            System.out.println("Direccion borrada exitosamente");
        } else {
            System.out.println("No se encontraron direcciones con el código especificado para borrar.");
        }
    }

    public static void borrarFabricaAlternativa(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de borrar;");
        solicitarFabricasAlternativas(dam);

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

    public static void borrarFabrica(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de borrar;");
        solicitarFabricas(dam);

        String idFabrica = requestContentDelete();
        int columnasAfectadas = dam.borrarFabrica(idFabrica);
        if (columnasAfectadas > 0) {
            System.out.println("Fabrica borrada exitosamente");
        } else {
            System.out.println("No se encontraron fabricas con el código especificado para borrar.");
        }
    }

    public static void borrarLineaPedido(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de borrar;");
        solicitarLineasPedido(dam);

        String idLineaPedido = requestContentDelete();
        int columnasAfectadas = dam.borrarLineaPedido(idLineaPedido);
        if (columnasAfectadas > 0) {
            System.out.println("Linea de pedido borrada exitosamente");
        } else {
            System.out.println("No se encontraron lineas de pedido con el código especificado para borrar.");
        }
    }

    public static void borrarPedido(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de borrar;");
        solicitarPedidos(dam);

        String idPedido = requestContentDelete();
        int columnasAfectadas = dam.borrarPedido(idPedido);
        if (columnasAfectadas > 0) {
            System.out.println("Pedido borrado exitosamente");
        } else {
            System.out.println("No se encontraron pedidos con el código especificado para borrar.");
        }
    }

    /* UPDATE */
    public static void actualizarArticulo(DataAccessManager dam) throws SQLException {

        Scanner tcl = new Scanner(System.in);

        System.out.println("Antes de actualizar = ");
        solicitarArticulos(dam);

        int idArticulo = 0;
        try {
            System.out.println("Dime la id del articulo a actualizar");
            idArticulo = tcl.nextInt();
            tcl.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número entero válido.");
            tcl.next();
            return;
        }
        String idArticuloAActualizarStr = Integer.toString(idArticulo);
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

    public static void actualizarArticuloFabrica(DataAccessManager dam) throws SQLException {
        
        Scanner tcl = new Scanner(System.in);
  
        System.out.println("Antes de actualizar = ");
        solicitarArticulosFabrica(dam);
        
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

    public static void actualizarCliente(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de actualizar = ");
        solicitarClientes(dam);

        int idCliente = 0;
        try {
            System.out.println("Ingrese el ID del cliente que desea actualizar: ");
            idCliente = tcl.nextInt();
            tcl.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número entero válido.");
            tcl.next();
            return;
        }
        String idClienteAActualizarStr = Integer.toString(idCliente);

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

    public static void actualizarDireccionEnvio(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de actualizar = ");
        solicitarDireccionesEnvio(dam);
        
        int idDireccionEnvio = 0;
        try {
            System.out.println("Ingrese el ID de la direccion de envio que desea actualizar: ");
            idDireccionEnvio = tcl.nextInt();
            tcl.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número entero válido.");
            tcl.next();
            return;
        }
        String idDireccionAActualizarStr = Integer.toString(idDireccionEnvio);

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

    public static void actualizarFabricaAlternativa(DataAccessManager dam) throws SQLException {

        Scanner tcl = new Scanner(System.in);
        
        System.out.println("Antes de actualizar = ");
        solicitarFabricasAlternativas(dam);
        
        System.out.println("Antes de actualizar = ");
        solicitarFabricas(dam);

        System.out.print("Ingrese el ID de la fábrica principal que desea actualizar: ");
        String idFabricaPrincipalStr = tcl.nextLine().trim();;
        System.out.print("Ingrese el ID de la fábrica alternativa que desea actualizar: ");
        String idFabricaAlternativaStr = tcl.nextLine().trim();;

        FabricaAlternativa fabricaAlternativaAActualizar = dam.loadFabricaAlternativaByCode(idFabricaPrincipalStr, idFabricaAlternativaStr);

        if (fabricaAlternativaAActualizar == null) {
            System.out.println("La fábrica alternativa con ID principal " + idFabricaPrincipalStr + " y alternativa " + idFabricaAlternativaStr + " no existe.");
            return;
        } else {
            System.out.println("Ingrese el nuevo ID de la fábrica principal (dejar vacío para no cambiar):");
            String nuevoIdFabricaPrincipalStr = tcl.nextLine().trim();
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
            String nuevoIdFabricaAlternativaStr = tcl.nextLine().trim();
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

            System.out.println("Actualizando la fábrica alternativa con ID principal " + idFabricaPrincipalStr + " y alternativa " + idFabricaAlternativaStr);

            int columnasAfectadas = dam.updateFabricaAlternativa(idFabricaPrincipalStr, idFabricaAlternativaStr, fabricaAlternativaAActualizar);
            if (columnasAfectadas > 0) {
                System.out.println("Fábrica alternativa actualizada exitosamente.");
                FabricaAlternativa fabricaAlternativaActualizada = dam.loadFabricaAlternativaByCode(idFabricaPrincipalStr, idFabricaAlternativaStr);
            } else {
                System.out.println("No se actualizó nada.");
            }
        }
    }

    public static void actualizarFabrica(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de actualizar = ");
        solicitarFabricas(dam);
        
        int idFabrica = 0;
        try {
            System.out.println("Ingrese el ID de la fabrica que desea actualizar: ");
            idFabrica = tcl.nextInt();
            tcl.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número entero válido.");
            tcl.next();
            return;
        }
        String idFabricaAActualizarStr = Integer.toString(idFabrica);
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

    public static void actualizarLineaPedido(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de actualizar = ");
        solicitarLineasPedido(dam);
        
        int idLineaPedido = 0;
        try {
             System.out.print("Ingrese el ID de la línea de pedido que desea actualizar: ");
            idLineaPedido = tcl.nextInt();
            tcl.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número entero válido.");
            tcl.next();
            return;
        }
         String idLineaPedidoAActualizar = Integer.toString(idLineaPedido);
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

    public static void actualizarPedido(DataAccessManager dam) throws SQLException {

        System.out.println("Antes de actualizar = ");
        solicitarPedidos(dam);
        int idPedido = 0;
        try {
             System.out.print("Ingrese el ID del pedido que desea actualizar: ");
            idPedido = tcl.nextInt();
            tcl.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número entero válido.");
            tcl.next();
            return;
        }
         String idPedidoAActualizar = Integer.toString(idPedido);

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

    public static void getTotalArticulosPorFabrica(DataAccessManager dam) throws SQLException {

        try {
            List<Fabrica> listaFabricasTotalArticulos = dam.getTotalArticulosPorFabrica();
            
        } catch (SQLException e) {
            System.err.println("Error al obtener los artículos por fábrica: " + e.getMessage());
        }
    }

}
