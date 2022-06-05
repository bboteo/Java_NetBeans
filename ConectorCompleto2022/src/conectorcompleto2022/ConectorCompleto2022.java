/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conectorcompleto2022;

import Conexion.Conector;
import Controlador.ControladorEliminar;
import Controlador.ControladorInsertar;
import Controlador.ControladorMenu;
import Controlador.ControladorMostrar;
import Modelo.PaisDAO;
import Modelo.PaisVO;
import Vista.FrmEliminar;
import Vista.Frm_Mostrar;
import Vista.Frm_insertar;
import Vista.Frm_menu;

/**
 *
 * @author bboteo
 */
public class ConectorCompleto2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Conector c = new Conector();
        //c.conectar();
        
        //Vistas
        Frm_menu fm = new Frm_menu();
        Frm_insertar fi = new Frm_insertar();
        Frm_Mostrar fmo = new Frm_Mostrar();
        FrmEliminar fel = new FrmEliminar();
        
        PaisVO pvo = new PaisVO();
        PaisDAO pdao = new PaisDAO();
        
        //Controladores
        ControladorMenu cm = new ControladorMenu(fm, fi, fmo, fel);
        ControladorInsertar ci = new ControladorInsertar(fi,pvo,pdao);
        ControladorMostrar cmo = new ControladorMostrar(fmo,pvo,pdao);
        ControladorEliminar cel = new ControladorEliminar(fel,pvo,pdao);
        
        //Configuracion de pantallas
        fm.setVisible(true);
        fm.setLocationRelativeTo(null);
        fm.setResizable(false);
    }
    
}
