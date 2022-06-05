/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc.ejercicio1.pkg01abr2022;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.Vista;

/**
 *
 * @author bboteo
 */
public class MVCEjercicio101abr2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista vis = new Vista();
        ModeloLogico mod = new ModeloLogico();
        Controlador con = new Controlador(vis, mod);
        
        vis.setVisible(true);
        vis.setLocationRelativeTo(null);
    }
    
}
