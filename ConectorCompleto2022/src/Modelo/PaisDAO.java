/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Mezcla de codigo Java y Sql
 * @author bboteo
 */
public class PaisDAO implements ConsultasPais {

    @Override
    public boolean insertar(PaisVO p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO pais (nombre_pais, "
                    + "capital_pais, "
                    + "poblacion_pais, "
                    + "fecha_ingreso_pais, "
                    + "ver_pais)"
                    + "VALUES ("
                    + "'"+p.getNombrePais()+"',"
                    + "'"+p.getCapital()+"',"
                    + p.getPoblacionPais()+","
                    + "'"+p.getFechaIngPais()+"',"
                    + "TRUE)";
            
            c.consultasMultiples(query);
            
        } catch (Exception e){
            System.err.println("Error [MC]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<PaisVO> consultar() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Conector c = new Conector();
        ArrayList<PaisVO> info = new ArrayList<>(); 
        try{
            c.conectar();
            String query = "SELECT "+
                    "p.id_pais,"+
                    "p.nombre_pais,"+
                    "p.capital_pais,"+
                    "p.poblacion_pais"+
                    " FROM dbconector.pais p"+
                    " WHERE p.ver_pais IS NULL OR p.ver_pais IS TRUE";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                PaisVO pvo = new PaisVO();
                pvo.setIdPais(rs.getInt(1));
                pvo.setNombrePais(rs.getString(2));
                pvo.setCapital(rs.getString(3));
                pvo.setPoblacionPais(rs.getLong(4));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e){
            System.err.println("Error [MMostrar]: "+e.getMessage());
            c.desconectar();
            return info;
        }
    return info;
    }

    @Override
    public void eliminar(PaisVO p) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       Conector c = new Conector();
       try{
           c.conectar();
           String query = "UPDATE pais SET ver_pais = FALSE WHERE id_pais = "+
                   p.getIdPais();
           c.consultasMultiples(query);
       } catch (Exception e){
            System.err.println("Error [MMostrar]: "+e.getMessage());
            c.desconectar();
       }
       c.desconectar();
    }

    @Override
    public void actualizar(PaisVO p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE dbconector.pais SET"
                    + " nombre_pais= " + "'"+p.getNombrePais()+"',"
                    + " capital_pais= "+ "'"+p.getCapital()+"',"
                    + " poblacion_pais= "+p.getPoblacionPais()+","
                    + " fecha_actualizacion_pais= "+"'"+p.getFechaActPais()+"',"
                    + " ver_pais= TRUE"
                    + " WHERE id_pais="+p.getIdPais();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Erro [MUpdate]: "+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
    }
}