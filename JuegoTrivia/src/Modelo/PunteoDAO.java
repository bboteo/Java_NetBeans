
package Modelo;

import Conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PunteoDAO implements TablaPunteo{

    @Override
    public boolean insertarP(PunteoVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO dbjuego.tbl_punteo (punteo) VALUES ("
                    +p.getPunteo()+")";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [Insertar Punteo]: "+e);
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<PunteoVO> consultarP() {
        ArrayList<PunteoVO> info = new ArrayList<>();
        return info;
    }

    @Override
    public boolean eliminarP(PunteoVO p) {
        return false;
    }

    @Override
    public boolean actualizarP(PunteoVO p) {
        return false;
    }

    @Override
    public ArrayList<PunteoVO> consultarPnuevo(PunteoVO p) {
        ArrayList<PunteoVO> info = new ArrayList<>();
        ResultSet result = null;
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT p.id, p.punteo " 
                    +"FROM dbjuego.tbl_punteo AS p " 
                    +"WHERE id=(SELECT MAX(id) FROM dbjuego.tbl_punteo)";
            result = c.consultaDatos(query);
            while(result.next()){
                p.setId(result.getInt(1));
                p.setPunteo(result.getInt(2));
                info.add(p);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error consultarPnuevo: "+e);
            c.desconectar();
        }
        return info;
    }
    
}
