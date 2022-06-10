/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.ConectorBiblioteca;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public class AutorDAO implements TablaAutor{

    @Override
    public boolean insertarA(AutorVO a) {
        ConectorBiblioteca c = new ConectorBiblioteca();
        try {
            c.conectar();
            String query = "INSERT INTO dbbiblio.autor "
                    + "(nombre1, nombre2, nombre3,"
                    + "apellido1, apellido2,"
                    + "alias, pais, correo, fecha_registro, ver_autor) VALUES ("
                    + "'"+a.getNombre1()+"',"
                    + "'"+a.getNombre2()+"',"
                    + "'"+a.getNombre3()+"',"
                    + "'"+a.getApellido1()+"',"
                    + "'"+a.getApellido2()+"',"
                    + "'"+a.getAlias()+"',"
                    + "'"+a.getPais()+"',"
                    + "'"+a.getCorreo()+"',"
                    + "'"+a.getFecha_registro()+"',"
                    + "TRUE)";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [MC]: "+e.getMessage());
            return false;
        }
        c.desconectar();
        return true;
    }
    
    @Override
    public ArrayList<AutorVO> consultarA() {
        ConectorBiblioteca c = new ConectorBiblioteca();
        ArrayList<AutorVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query ="SELECT "
                    + "a.id, a.nombre1, a.nombre2, a.nombre3, a.apellido1, a.apellido2,"
                    + "a.alias, a.pais, a.correo, a.fecha_registro, a.fecha_modificacion"
                    + " FROM dbbiblio.autor a WHERE a.ver_autor is TRUE";
            ResultSet rs = c.consultaDatos(query);
            
            while(rs.next()){
                AutorVO pvo = new AutorVO();
                pvo.setId(rs.getInt(1));
                pvo.setNombre1(rs.getString(2));
                pvo.setNombre2(rs.getString(3));
                pvo.setNombre3(rs.getString(4));
                pvo.setApellido1(rs.getString(5));
                pvo.setApellido2(rs.getString(6));
                pvo.setAlias(rs.getString(7));
                pvo.setPais(rs.getString(8));
                pvo.setCorreo(rs.getString(9));
                pvo.setFecha_registro(rs.getString(10));
                pvo.setFecha_modificacion(rs.getString(11));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Erro [MMostrar]: "+e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public void eliminarA(AutorVO a) {
        ConectorBiblioteca c = new ConectorBiblioteca();
        try {
            c.conectar();
            //Condicion para eliminar un autor es que no tenga libros asociados
            String query="UPDATE dbbiblio.autor SET ver_autor = FALSE "
                    + "WHERE id = "+a.getId();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [Eliminar]: "+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
    }

    @Override
    public void actualizar(AutorVO a) {
        ConectorBiblioteca c = new ConectorBiblioteca();
        try {
            c.conectar();
            //Condicion para eliminar un autor es que no tenga libros asociados
            String query="UPDATE dbbiblio.autor SET "
                    + "nombre1 = '"+a.getNombre1()+"',"
                    + "nombre2 = '"+a.getNombre2()+"',"
                    + "nombre3 = '"+a.getNombre3()+"',"
                    + "apellido1 = '"+a.getApellido1()+"',"
                    + "apellido2 = '"+a.getApellido2()+"',"
                    + "alias = '"+a.getAlias()+"',"
                    + "pais = '"+a.getPais()+"',"
                    + "correo = '"+a.getCorreo()+"',"
                    + "fecha_modificacion ='"+a.getFecha_modificacion()+"' "
                    + "WHERE id = "+a.getId();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [actualizar]: "+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
    }

    @Override
    public ArrayList<AutorVO> consultaEA(LibroVO l) {
        ConectorBiblioteca c = new ConectorBiblioteca();
        ArrayList<AutorVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query ="SELECT "
                    + "a.id, a.nombre1, a.nombre2, a.nombre3, a.apellido1, a.apellido2,"
                    + "a.alias, a.pais, a.correo "
                    + "FROM dbbiblio.autor a INNER JOIN dbbiblio.libro l "
                    + "ON a.id = l.autor_id_fk "
                    + "WHERE (a.ver_autor is TRUE) AND (l.id = "+l.getId()+")";
            ResultSet rs = c.consultaDatos(query);
            
            while(rs.next()){
                AutorVO pvo = new AutorVO();
                pvo.setId(rs.getInt(1));
                pvo.setNombre1(rs.getString(2));
                pvo.setNombre2(rs.getString(3));
                pvo.setNombre3(rs.getString(4));
                pvo.setApellido1(rs.getString(5));
                pvo.setApellido2(rs.getString(6));
                pvo.setAlias(rs.getString(7));
                pvo.setPais(rs.getString(8));
                pvo.setCorreo(rs.getString(9));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Erro [MMostrar]: "+e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public ArrayList<AutorVO> consultarAxId(AutorVO a) {
        ConectorBiblioteca c = new ConectorBiblioteca();
        ArrayList<AutorVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query ="SELECT "
                    + "a.id, a.nombre1, a.nombre2, a.nombre3, a.apellido1, a.apellido2,"
                    + "a.alias, a.pais, a.correo "
                    + "FROM dbbiblio.autor a "
                    + "WHERE (a.ver_autor is TRUE) AND (a.id = "+a.getId()+")";
            ResultSet rs = c.consultaDatos(query);
            
            while(rs.next()){
                AutorVO pvo = new AutorVO();
                pvo.setId(rs.getInt(1));
                pvo.setNombre1(rs.getString(2));
                pvo.setNombre2(rs.getString(3));
                pvo.setNombre3(rs.getString(4));
                pvo.setApellido1(rs.getString(5));
                pvo.setApellido2(rs.getString(6));
                pvo.setAlias(rs.getString(7));
                pvo.setPais(rs.getString(8));
                pvo.setCorreo(rs.getString(9));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Erro [MMostrar]: "+e.getMessage());
            c.desconectar();
        }
        return info;
    }
        
}
