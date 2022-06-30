
package Modelo;

import Conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BitacoraDAO implements TablaBitacora{

    @Override
    public boolean insertarB(BitacoraVO b) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO dbjuego.tbl_bitacora "
                    + "(date_inicio, date_final, numero_intento, punteo, fk_usuario_id, fk_tipo_usuario_id) "
                    + "VALUES ('"
                    + b.getDateInicio()+"','"
                    + b.getDateFinal()+"',"
                    + b.getNumeroIntento()+","
                    + b.getPunteo()+","
                    + b.getFkUsuarioId()+","
                    + b.getFkTipoUsuarioId()+")";
            c.consultasMultiples(query);
            
        } catch (Exception e) {
            System.err.println("Error [InsertarB]:"+e);
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<BitacoraVO> consultarB() {
        ArrayList<BitacoraVO> info = new ArrayList<>();
        ResultSet result = null;
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT b.id, b.date_inicio, b.date_final, b.numero_intento, b.punteo, b.fk_usuario_id, b.fk_tipo_usuario_id "
                          +"FROM dbjuego.tbl_bitacora AS b;";
            result = c.consultaDatos(query);
            
            while(result.next()){
                BitacoraVO b1 = new BitacoraVO();
                b1.setId(result.getInt(1));
                b1.setDateInicio(result.getString(2));
                b1.setDateFinal(result.getString(3));
                b1.setNumeroIntento(result.getInt(4));
                b1.setPunteo(result.getInt(5));
                b1.setFkUsuarioId(result.getInt(6));
                b1.setFkTipoUsuarioId(result.getInt(7));
                info.add(b1);
            }
            
        } catch (Exception e) {
            System.err.println("Error [consultarB]: "+e);
            c.desconectar();
            return null;
        }
        return info;
    }

    @Override
    public boolean eliminarB(BitacoraVO b) {
        return false;
    }

    @Override
    public boolean actualizarB(BitacoraVO b) {
        return false;
    }

    @Override
    public int consutarBmaxId(UsuarioVO u) {
        ResultSet result = null;
        int maxId = 0;
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT MAX(b.id) " +
                           "FROM dbjuego.tbl_bitacora AS b INNER JOIN dbjuego.tbl_usuario AS u " +
                           "    ON u.id = b.fk_usuario_id " +
                           "WHERE u.id = "+u.getId();
            result = c.consultaDatos(query);
                        
            while(result.next()){
                maxId = result.getInt(1); 
            }
            
        } catch (Exception e) {
            System.err.println("Error [consultarB]: "+e);
            c.desconectar();
            return maxId;
        }
        return maxId;
    }

    @Override
    public ArrayList<BitacoraVO> consultarBintento(BitacoraVO b) {
        ArrayList<BitacoraVO> info = new ArrayList<>();
        ResultSet result = null;
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT b.date_inicio, b.date_final, b.numero_intento, b.punteo "
                          +"FROM dbjuego.tbl_bitacora AS b "
                          +"WHERE b.id = "+b.getId();
            result = c.consultaDatos(query);
            
            while(result.next()){
                BitacoraVO b1 = new BitacoraVO();
                b1.setDateInicio(result.getString(1));
                b1.setDateFinal(result.getString(2));
                b1.setNumeroIntento(result.getInt(3));
                b1.setPunteo(result.getInt(4));
                info.add(b1);
            }
            
        } catch (Exception e) {
            System.err.println("Error [consultarB]: "+e);
            c.desconectar();
            return null;
        }
        return info;
    }
    
}
