
package Modelo;

import Conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class UsuarioDAO implements TablaUsuario{

    //Para utilizar el reporte
    public JasperViewer jv;
    
    @Override
    public boolean insertarU(UsuarioVO u) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO dbjuego.tbl_usuario (nombre,apellido,edad,"
                    +"usuario,contrasena,fk_estado_id,fk_tipo_usuario_id,fk_punteo_id )"
                    +"VALUES ('"
                    + u.getNombre()+"','"
                    + u.getApellido()+"',"
                    + u.getEdad()+",'"
                    + u.getUsuario()+"','"
                    + u.getContrasena()+"',"
                    + u.getFkEstadoId()+","
                    + u.getFkTipoUsuarioId()+","
                    + u.getFkPunteoId()+")";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("error [Insertando Usuario]: "+e);
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<UsuarioVO> consultarU() {
        ArrayList<UsuarioVO> info = new ArrayList<>();
        ResultSet result = null;
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT u.id, u.nombre, u.apellido, u.edad, u.usuario, u.contrasena,"
                    + "u.fk_estado_id, u.fk_tipo_usuario_id, u.fk_punteo_id "
                    + "FROM dbjuego.tbl_usuario AS u";
            result = c.consultaDatos(query);
            while(result.next()){
                UsuarioVO u = new UsuarioVO();
                u.setId(result.getInt(1));
                u.setNombre(result.getString(2));
                u.setApellido(result.getString(3));
                u.setEdad(result.getInt(4));
                u.setUsuario(result.getString(5));
                u.setContrasena(result.getString(6));
                u.setFkEstadoId(result.getInt(7));
                u.setFkTipoUsuarioId(result.getInt(8));
                u.setFkPunteoId(result.getInt(9));
                info.add(u);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error consultarPnuevo: "+e);
            c.desconectar();
        }
        return info;
    }

    @Override
    public boolean eliminarU(UsuarioVO u) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "DELETE FROM dbjuego.tbl_usuario " +
                           "WHERE id = "+u.getId();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [EliminarU]: "+e);
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public boolean actualizarU(UsuarioVO u) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE dbjuego.tbl_usuario AS u " +
                            "SET " +
                            "u.nombre = '"+u.getNombre()+"'," +
                            "u.apellido = '"+u.getApellido()+"'," +
                            "u.edad = "+u.getEdad()+"," +
                            "u.usuario = '"+u.getUsuario()+"'," +
                            "u.contrasena = '"+u.getContrasena()+"'," +
                            "u.fk_estado_id= "+u.getFkEstadoId()+"," +
                            "u.fk_tipo_usuario_id = "+u.getFkTipoUsuarioId()+"," +
                            "u.fk_punteo_id = "+u.getFkPunteoId()+" " +
                            "WHERE u.id = "+u.getId();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Erro [ActualizarU]: "+e);
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public boolean validarU(UsuarioVO u) {
        ResultSet result = null;
        int row = 0;
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT u.id "+
                           "FROM dbjuego.tbl_usuario AS u "+
                           "WHERE u.usuario LIKE '"+
                            u.getUsuario()+"'";
            result = c.consultaDatos(query);
            
            while(result.next()){
                u.setId(result.getInt(1));
                row++;
            }
            
            if(row==0) return false; //Cero coincidencias encontradas
            if(row==1) return true; //Una coincidencia encontrada
            if(row>1) return false; //hay usuarios duplicados
            
            
        } catch (Exception e) {
            System.err.println("Error [ValidarU]"+e);
            c.desconectar();
        }
               
        return false;
    }
    
    @Override
    public boolean validarUc(UsuarioVO u) {
        ResultSet result = null;
        int row = 0;
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT u.id "+
                           "FROM dbjuego.tbl_usuario AS u "+
                           "WHERE u.contrasena LIKE '"+
                            u.getContrasena()+"'";
            
            result = c.consultaDatos(query);
            
            while(result.next()){
                row++;
            }
            
            if(row==0) return false; //Cero coincidencias encontradas
            if(row >= 1) return true; //Por lo menos una coincidencia encontrada
            
        } catch (Exception e) {
            System.err.println("Error [ValidarC]"+e);
            c.desconectar();
        }
               
        return false;
    }
    
    @Override
    public ArrayList<UsuarioVO> consultarUexacto(UsuarioVO u) {
        ArrayList<UsuarioVO> info = new ArrayList<>();
        ResultSet result = null;
        Conector c = new Conector();
        
        try {
            c.conectar();
            String query="SELECT u.id, u.nombre, u.apellido, u.edad," +
                         "u.usuario, u.contrasena,"+
                         "u.fk_estado_id, u.fk_tipo_usuario_id, u.fk_punteo_id " +
                         "FROM dbjuego.tbl_usuario AS u " +
                         "WHERE u.id = "+u.getId();
            result = c.consultaDatos(query);
            
            while(result.next()){
                //UsuarioVO u1 = new UsuarioVO();
                u.setId(result.getInt(1));
                u.setNombre(result.getString(2));
                u.setApellido(result.getString(3));
                u.setEdad(result.getInt(4));
                u.setUsuario(result.getString(5));
                u.setContrasena(result.getString(6));
                u.setFkEstadoId(result.getInt(7));
                u.setFkTipoUsuarioId(result.getInt(8));
                u.setFkPunteoId(result.getInt(9));
                info.add(u);
            }
            
        } catch (Exception e) {
            System.err.println("Error [ConsultarUexacto]"+e);
            c.desconectar();
        }
        return info;
    }

    //Consultas JOIN

    @Override
    public ArrayList<UsuarioCVO> consultarUjoin(UsuarioVO u, EstadoVO e, TipoUsuarioVO tu, PunteoVO p) {
        ArrayList<UsuarioCVO> info = new ArrayList<>();     
        ResultSet result = null;
        Conector c = new Conector();
        
        try {
            c.conectar();
            String query="SELECT "
                    + "u.id, u.nombre, u.apellido, u.edad, u.usuario, u.contrasena, "
                    + "tu.nombre, "
                    + "e.nombre, "
                    + "p.punteo " 
                    + "FROM dbjuego.tbl_usuario AS u INNER JOIN dbjuego.tbl_tipo_usuario AS tu "
                    + "ON tu.id = u.fk_tipo_usuario_id INNER JOIN dbjuego.tbl_estado AS e "
                    + "ON e.id = u.fk_estado_id INNER JOIN dbjuego.tbl_punteo AS p "
                    + "ON p.id = u.fk_punteo_id";
            result = c.consultaDatos(query);
            
            while(result.next()){
                UsuarioCVO uc = new UsuarioCVO();
                uc.setId(result.getInt(1));
                uc.setNombre(result.getString(2));
                uc.setApellido(result.getString(3));
                uc.setEdad(result.getInt(4));
                uc.setUsuario(result.getString(5));
                uc.setContrasena(result.getString(6));
                uc.setEstado(result.getString(7));
                uc.setTipoUsuario(result.getString(8));
                uc.setPunteo(result.getInt(9));
            
                info.add(uc);
                                
            }
            
        } catch (Exception e1) {
            System.err.println("Error [ConsultarUexacto]"+e1);
            c.desconectar();
        }
        
        return info;
    
    } 

    @Override
    public boolean actualizarUtipoUsuario(UsuarioVO u) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE dbjuego.tbl_usuario AS u " +
                            "SET " +
                            "u.fk_tipo_usuario_id = "+u.getFkTipoUsuarioId() +" "+
                            "WHERE u.id = "+u.getId();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [ActualizarUpuntos]: "+e);
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public void reporte() {
        Conector c = new Conector();
        try {
            c.conectar();
            JasperReport reporte;
            String ruta = "C:\\Users\\bboteo\\Documents\\gitHubRepository\\Java_NetBeans\\JuegoTrivia\\src\\Reporte\\reporteJugadores.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(ruta, null , c.connection);
            JasperViewer jv = new JasperViewer(jp,false);
            //jv = new JasperViewer(jp,false);
            this.jv = jv;
        } catch (Exception e) {
            System.err.println("Error en Reporte: "+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
    }

}
