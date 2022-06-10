/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.ConectorBiblioteca;
import java.sql.ResultSet;
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
        ConectorBiblioteca c = new ConectorBiblioteca();
        ArrayList<LibroVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT "
                    + "l.id, l.nombre, l.saga, l.numero_libro, l.edicion, l.paginas, l.fecha_publicacion "
                    + "FROM dbbiblio.libro l WHERE l.ver_libro is TRUE";
            ResultSet rs = c.consultaDatos(query);
            
            while(rs.next()){
                LibroVO lvo = new LibroVO();
                lvo.setId(rs.getInt(1));
                lvo.setNombre(rs.getString(2));
                lvo.setSaga(rs.getString(3));
                lvo.setNumeroLibro(rs.getInt(4));
                lvo.setEdicion(rs.getInt(5));
                lvo.setPaginas(rs.getInt(6));
                lvo.setFechaPublicacion(rs.getString(7));
                info.add(lvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MC]: "+e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public void eliminarL(LibroVO l) {
        ConectorBiblioteca c = new ConectorBiblioteca();
        try {
            c.conectar();
            //Libros pueden eliminarse sin problemas
            String query="UPDATE dbbiblio.libro SET ver_libro = FALSE "
                    + "WHERE id = "+l.getId();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [Eliminar]: "+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
    }

    @Override
    public void actualizarL(LibroVO l) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<LibroVO> consultaEL(AutorVO a) {
        ConectorBiblioteca c = new ConectorBiblioteca();
        ArrayList<LibroVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT "
                    + "l.id, l.nombre, l.saga, l.numero_libro, l.edicion, l.paginas, l.fecha_publicacion "
                    + "FROM dbbiblio.libro l INNER JOIN dbbiblio.autor a "
                    + "ON l.autor_id_fk = a.id "
                    + "WHERE (l.ver_libro IS TRUE) AND (a.id = "+a.getId()+")";
            ResultSet rs = c.consultaDatos(query);
            
            while(rs.next()){
                LibroVO lvo = new LibroVO();
                lvo.setId(rs.getInt(1));
                lvo.setNombre(rs.getString(2));
                lvo.setSaga(rs.getString(3));
                lvo.setNumeroLibro(rs.getInt(4));
                lvo.setEdicion(rs.getInt(5));
                lvo.setPaginas(rs.getInt(6));
                lvo.setFechaPublicacion(rs.getString(7));
                info.add(lvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MC]: "+e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public ArrayList<LibroVO> consultarLxId(LibroVO l) {
        ConectorBiblioteca c = new ConectorBiblioteca();
        ArrayList<LibroVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query ="SELECT "
                    + "l.id, l.nombre, l.saga, l.numero_libro, l.edicion, l.paginas,"
                    + "l.fecha_publicacion, l.autor_id_fk "
                    + "FROM dbbiblio.libro l "
                    + "WHERE (l.ver_libro is TRUE) AND (l.id = "+l.getId()+")";
            ResultSet rs = c.consultaDatos(query);
            
            while(rs.next()){
                LibroVO lvo = new LibroVO();
                lvo.setId(rs.getInt(1));
                lvo.setNombre(rs.getString(2));
                lvo.setSaga(rs.getString(3));
                lvo.setNumeroLibro(rs.getInt(4));
                lvo.setEdicion(rs.getInt(5));
                lvo.setPaginas(rs.getInt(6));
                lvo.setFechaPublicacion(rs.getString(7));
                lvo.setAutorIdFk(rs.getInt(8));
                info.add(lvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Erro [MMostrar]: "+e.getMessage());
            c.desconectar();
        }
        return info;
    }
    
}
