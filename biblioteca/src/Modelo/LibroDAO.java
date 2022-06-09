/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.ConectorBiblioteca;
import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public class LibroDAO implements TablaLibro{

    @Override
    public boolean insertarL(LibroVO l) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ConectorBiblioteca c = new ConectorBiblioteca();
        try {
            c.conectar();
            String query = "INSERT INTO dbbiblio.libro "
                    + "(nombre, saga, numero_libro, edicion, "
                    + "paginas, fecha_publicacion,autor_id_fk, ver_libro) VALUES ("
                    + "'"+l.getNombre()+"',"
                    + "'"+l.getSaga()+"',"
                    + l.getNumeroLibro()+","
                    + l.getEdicion()+","
                    + l.getPaginas()+","
                    + "'"+l.getFechaPublicacion()+"',"
                    + l.getAutorIdFk()+","
                    +"TRUE)";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [MC]: "+e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<LibroVO> consultarL() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ArrayList<LibroVO> info = new ArrayList<>();
        return info;
    }

    @Override
    public void eliminarL(LibroVO l) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarL(LibroVO l) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
