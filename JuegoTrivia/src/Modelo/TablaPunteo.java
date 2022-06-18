
package Modelo;

import java.util.ArrayList;

public interface TablaPunteo {
    public boolean insertarP(PunteoVO p);
    public ArrayList<PunteoVO> consultarP();
    public boolean eliminarP(PunteoVO p);
    public boolean actualizarP(PunteoVO p);
    
    
    //Consultas Especificas
    public ArrayList<PunteoVO> consultarPnuevo(PunteoVO p);//Para las asignacion de tablas nuevas
}
