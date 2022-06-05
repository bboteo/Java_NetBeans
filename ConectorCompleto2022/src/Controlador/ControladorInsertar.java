/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Extras;
import Modelo.PaisDAO;
import Modelo.PaisVO;
import Vista.Frm_insertar;
import java.awt.FocusTraversalPolicy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

/**
 *
 * @author bboteo
 */
public class ControladorInsertar implements ActionListener{

    Frm_insertar vIn = new Frm_insertar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorInsertar(Frm_insertar vIn, PaisVO pvo, PaisDAO pdao) {
        this.vIn = vIn;
        this.pvo = pvo;
        this.pdao = pdao;
        
        vIn.jButton_registrar.addActionListener(this);
        vIn.jButton_cancelar_registro.addActionListener(this);
        
    }
    
    private void registrarPais(){
        this.pvo.setNombrePais(vIn.jTextArea_nombre_pais.getText());
        this.pvo.setCapital(vIn.jTextArea_nombre_capital.getText());
        this.pvo.setPoblacionPais(Long.parseLong(this.vIn.jTextArea_poblacion.getText()));
        //this.pvo.setFechaIngPais(Date.valueOf(Extras.fechaHoy()));
        this.pvo.setFechaIngPais(Extras.fechaHoy());
        
        /*Codigo de prueba: Focus del tabulador
        this.vIn.setFocusTraversalPolicy(
                new FocusTraversalOnArray(new Component[]{});
        );
        */
        
        if(pdao.insertar(pvo)== true){
            vIn.jopMensage.showMessageDialog(vIn,"Datos Registrado");
            this.vIn.jTextArea_nombre_pais.setText("");
            this.vIn.jTextArea_nombre_capital.setText("");
            this.vIn.jTextArea_poblacion.setText("");
        }else {
            vIn.jopMensage.showMessageDialog(vIn,"Error, Datos no Registrados");
            this.vIn.jTextArea_nombre_pais.setText("");
            this.vIn.jTextArea_nombre_capital.setText("");
            this.vIn.jTextArea_poblacion.setText("");
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (e.getSource()==vIn.jButton_registrar){
            if(!this.vIn.jTextArea_nombre_pais.getText().equals("")&&
               !this.vIn.jTextArea_nombre_capital.getText().equals("")&&
               !this.vIn.jTextArea_poblacion.getText().equals("")){
                this.registrarPais();
            }else{
                this.vIn.jopMensage.showMessageDialog(vIn, "Debe llenar todos los campos");
            }
        }
        if (e.getSource()==vIn.jButton_cancelar_registro){
            vIn.dispose();
        }
    }
    
}
