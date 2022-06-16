/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Mezcla de codigo Java y Sql
 * @author bboteo
 */
public class PaisDAO implements ConsultasPais {

    //Par poder utilizar en el metodo reporte
    public JasperViewer jv;
    
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

    //Para los reportes
    @Override
    public void reporte() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Conector c = new Conector();
        try {
            c.conectar();
            //Definir una variable que encuentra el reporte
            JasperReport reporte;
            //Ruta del Reporte
            String ruta = "C:\\Users\\bboteo\\Documents\\gitHubRepositorio\\Java_NetBeans\\ConectorCompleto2022\\src\\Reportes\\reportePaises.jasper";
            //String ruta = "src\\Reportes\\reportePaises.jasper";
            
            //Asignacion de ruta
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(ruta, null, c.connection);
            JasperViewer jv = new JasperViewer(jp, false);
            this.jv = jv;        
        } catch (Exception e) {
            System.err.println("Error en metodo Reporte: "+e.getMessage());
            c.desconectar();
        }
    }
}