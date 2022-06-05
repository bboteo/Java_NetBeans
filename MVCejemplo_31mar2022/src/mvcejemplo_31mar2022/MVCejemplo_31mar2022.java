/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvcejemplo_31mar2022;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.frmOperaciones;

/**
 *
 * @author bboteo
 */
public class MVCejemplo_31mar2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmOperaciones op = new frmOperaciones();
        ModeloLogico ml = new ModeloLogico();
        Controlador c = new Controlador(op,ml);
        
        op.setVisible(true);
        op.setLocationRelativeTo(null);
    }
    
}
