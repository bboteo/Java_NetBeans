/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc.ejercicio2.pkg01abr2022;

import Model.Model;
import Vista.TextNote;
import Controlador.Controlador;
/**
 *
 * @author bboteo
 */
public class MVCEjercicio201abr2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TextNote note = new TextNote();
        Model mod = new Model();
        Controlador cont = new Controlador(note, mod);
        
        note.setVisible(true);
        note.setLocationRelativeTo(null);
       
    }
    
}
