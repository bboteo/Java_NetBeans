
package Modelo;

import Conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;


public class TipoUsuarioDAO implements TablaTipoUsuario{

    @Override
    public boolean insertarTu(TipoUsuarioVO tu) {
        return false;
    }

    @Override
    public ArrayList<TipoUsuarioVO> consultarTu() {
        ArrayList<TipoUsuarioVO> info = new ArrayList<>();
        ResultSet result = null;
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT tu.id, tu.nombre, tu.descripcion " +
                           "FROM dbjuego.tbl_tipo_usuario AS tu";
            
            result = c.consultaDatos(query);
            
            while(result.next()){
                TipoUsuarioVO tu = new TipoUsuarioVO();
                tu.setId(result.getInt(1));
                tu.setNombre(result.getString(2));
                tu.setDescrip(result.getString(3));
                info.add(tu);
            }
            
        } catch (Exception e) {
            System.err.println("Error en ConsultarTU: "+e);
            c.desconectar();
        }
        return info;
    }

    @Override
    public boolean eliminarTu(TipoUsuarioVO tu) {
        return false;
    }

    @Override
    public boolean actualizarTu(TipoUsuarioVO tu) {
        return false;
    }

    @Override
    public ArrayList<TipoUsuarioVO> consultarTuexacto(TipoUsuarioVO tu) {
        ArrayList<TipoUsuarioVO> info = new ArrayList<>();
        ResultSet result = null;
        Conector c = new Conector();
        
        try {
            c.conectar();
            String query = "SELECT tu.id, tu.nombre, tu.descripcion " +
                           "FROM dbjuego.tbl_tipo_usuario AS tu " +
                           "WHERE tu.id = "+tu.getId();
            result = c.consultaDatos(query);
            
            while(result.next()){
                tu.setId(result.getInt(1));
                tu.setNombre(result.getString(2));
                tu.setDescrip(result.getString(3));
                info.add(tu);
            }
            
        } catch (Exception e) {
            System.err.println("Error consultarTuexacto: "+e);
            c.desconectar();
        }
        return info;
    }
    
}
