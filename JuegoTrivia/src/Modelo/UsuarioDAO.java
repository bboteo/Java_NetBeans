
package Modelo;

import Conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO implements TablaUsuario{

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
        return false;
    }

    @Override
    public boolean actualizarU(UsuarioVO u) {
        return false;
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
                           "WHERE u.usuario LIKE '"+
                            u.getContrasena()+"'";
            
            result = c.consultaDatos(query);
            
            while(result.next()){
                u.setId(result.getInt(1));
                row++;
            }
            
            if(row==0) return false; //Cero coincidencias encontradas
            if(row==1) return true; //Una coincidencia encontrada
            if(row>1) return false; //hay usuarios duplicados
            
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


    
}
