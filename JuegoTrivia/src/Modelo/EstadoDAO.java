
package Modelo;

import Conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;


public class EstadoDAO implements TablaEstado{

    @Override
    public boolean insertarE(EstadoVO e) {
        return false;
    }

    @Override
    public ArrayList<EstadoVO> consultarE() {
        ArrayList<EstadoVO> info = new ArrayList<>();
        ResultSet result = null;
        Conector c = new Conector();
        
        try {
            c.conectar();
            String query ="SELECT e.id, e.nombre, e.descripcion " +
                          "FROM dbjuego.tbl_estado AS e";
            result = c.consultaDatos(query);
            
            while(result.next()){
                EstadoVO e = new EstadoVO();
                e.setId(result.getInt(1));
                e.setNombre(result.getString(2));
                e.setDescrip(result.getString(3));
                info.add(e);
            }
            
        } catch (Exception e1) {
            System.err.println("Error [consultarE]: "+e1);
            c.desconectar();
        }
        
        return info;
    }

    @Override
    public boolean eliminarE(EstadoVO e) {
        return false;
    }

    @Override
    public boolean actualizarE(EstadoVO e) {
        return false;
    }

    @Override
    public ArrayList<EstadoVO> consultarEexacto(EstadoVO e) {
        ArrayList<EstadoVO> info = new ArrayList<>();
        ResultSet result = null;
        Conector c = new Conector();
        
        try {
            c.conectar();
            String query ="SELECT e.id, e.nombre, e.descripcion " +
                          "FROM dbjuego.tbl_estado AS e "+
                          "WHERE e.id = "+e.getId();
            result = c.consultaDatos(query);
            
            while(result.next()){
                //EstadoVO es = new EstadoVO();
                e.setId(result.getInt(1));
                e.setNombre(result.getString(2));
                e.setDescrip(result.getString(3));
                info.add(e);
            }
            
        } catch (Exception er) {
            System.err.println("Error [consultarE]: "+er);
            c.desconectar();
        }
    
        return info;
    }
    
}
