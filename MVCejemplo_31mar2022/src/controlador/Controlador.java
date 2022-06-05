/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogico;
import vista.frmOperaciones;

/**
 *
 * @author bboteo
 */
//Se hace la implementacion de ActionListener para que reciba los click de la vista
public class Controlador implements ActionListener{

    frmOperaciones vista = new frmOperaciones();
    ModeloLogico modelo = new ModeloLogico();
    
    //CONSTRUCTOR PARA EL CONTROLADOR
    public Controlador(frmOperaciones vista, ModeloLogico modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        //Para que vea las acciones del listener del boton
        this.vista.btnSumar.addActionListener(this);
        this.vista.btnRestar.addActionListener(this);
        this.vista.btnMulti.addActionListener(this);
        this.vista.btnDiv.addActionListener(this);
    }
    
    //FUNCIONAMIENTO DEL CONTROLADOR
    private void suma(){
        //PROCESO DEL CONTROLADOR PARA TRASLADAR INFORMACION AL MODELO
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        
        //PROCESO PARA TRASLADAR LA RESPUESTA A LA VISTA
        vista.result.showMessageDialog(this.vista, modelo.suma());
    }
    
    private void resta(){
        //PROCESO DEL CONTROLADOR PARA TRASLADAR INFORMACION AL MODELO
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        
        //PROCESO PARA TRASLADAR LA RESPUESTA A LA VISTA
        vista.result.showMessageDialog(this.vista, modelo.resta());
    }
    
    private void multiplicacion(){
        //PROCESO DEL CONTROLADOR PARA TRASLADAR INFORMACION AL MODELO
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        
        //PROCESO PARA TRASLADAR LA RESPUESTA A LA VISTA
        vista.result.showMessageDialog(this.vista, modelo.multiplicacion());
    }
    
    private void division(){
        //PROCESO DEL CONTROLADOR PARA TRASLADAR INFORMACION AL MODELO
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        
        //PROCESO PARA TRASLADAR LA RESPUESTA A LA VISTA
        vista.result.showMessageDialog(this.vista, modelo.division());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        if(e.getSource() == vista.btnSumar){
           this.suma();
        }
        if(e.getSource()== vista.btnRestar){
            this.resta();
        }
        if(e.getSource()== vista.btnMulti){
            this.multiplicacion();
        }
        if(e.getSource()== vista.btnDiv){
            this.division();
        }
    }
    
}
