package hallazgos_v1;

import Controlador.ControladorTodosHallazgos;
import Vista.FrmTodosHallazgos;

public class Hallazgos_v1 {


    public static void main(String[] args) {
        //Vista
        FrmTodosHallazgos fTh = new FrmTodosHallazgos();
        
        
        //Modelo
        
        
        //Controlador
        ControladorTodosHallazgos cTh = new ControladorTodosHallazgos(fTh);
        
        
        
        
        //Iniciar la aplicacion
        fTh.setVisible(true);
        fTh.setLocationRelativeTo(null);
        fTh.setResizable(false);
        
    }
    
}
