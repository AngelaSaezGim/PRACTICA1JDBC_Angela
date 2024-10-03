/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1DataAccess;

import java.sql.Connection;

/**
 *
 * @author angsaegim
 */
public class FabricaDAO extends DataAccessObject {
    
    FabricaDAO(Connection cnt) {
        super(cnt);
    }
    
    private class FabricaTableColumns {

        private final static String COLUMN_IDFABRICAPRINCIPAL = "idFabrica";
        private final static String COLUMN_IDFABRICAALTERNATIVA = "telefonoContacto";

    }
}
