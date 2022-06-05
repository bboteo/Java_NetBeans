/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogico;
import vista.Vista;

/**
 *
 * @author bboteo
 */
public class Controlador implements ActionListener{
    
    //Objetos de la vista y el modelo
    Vista vis = new Vista();
    ModeloLogico mod = new ModeloLogico();
    
    //Constructor
    public Controlador(Vista vis, ModeloLogico mod) {
        this.mod = mod;
        this.vis = vis;
        
        //Para que el constructor guarde los eventos
        this.vis.btnTraducir.addActionListener(this);
        
    }
    
    private void traducir(){
        //Pasar informacion al modelo
        this.mod.setPalabra((String) this.vis.cbxPalabra.getSelectedItem());
 
        //Para pasar datos a la vista
        this.vis.ingles.showMessageDialog(this.vis, this.mod.Traductor());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getSource()==vis.btnTraducir){
            this.traducir();
        }
    }
    
}
