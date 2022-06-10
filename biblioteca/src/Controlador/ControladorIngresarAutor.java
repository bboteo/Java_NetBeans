/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AutorDAO;
import Modelo.AutorVO;
import Modelo.Extras;
import Vista.FrmIngresarAutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorIngresarAutor implements ActionListener{
    FrmIngresarAutor vMiAt = new FrmIngresarAutor();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();

    public ControladorIngresarAutor(FrmIngresarAutor vMiAt, AutorVO avo, AutorDAO adao) {
        this.vMiAt = vMiAt;
        this.avo = avo;
        this.adao = adao;
        
        vMiAt.btnIngresarAutorRegistrar.addActionListener(this);
        vMiAt.btnIngresarAutorCancelar.addActionListener(this);
    }

    private void registrarAutor(){
        this.avo.setNombre1(vMiAt.txbIngresarAutorNombre1.getText());
        this.avo.setNombre2(vMiAt.txbIngresarAutorNombre2.getText());
        this.avo.setNombre3(vMiAt.txbIngresarAutorNombre3.getText());
        this.avo.setApellido1(vMiAt.txbIngresarAutorApellido1.getText());
        this.avo.setApellido2(vMiAt.txbIngresarAutorApellido2.getText());
        this.avo.setAlias(vMiAt.txbIngresarAutorAlias.getText());
        this.avo.setPais(vMiAt.txbIngresarAutorPais.getText());
        this.avo.setCorreo(vMiAt.txbIngresarAutorCorreo.getText());
        this.avo.setFecha_registro(Extras.fechaHoy());
        
        //Validacion de campos obligatorios
        if (avo.getNombre1().isEmpty() || avo.getApellido1().isEmpty() 
                || avo.getPais().isEmpty() || avo.getCorreo().isEmpty()){
            vMiAt.jopIngresarAutorIncompleto.showMessageDialog(vMiAt, "Datos Obligatorios incompletos");
        }else{
            if(adao.insertarA(avo)){
                vMiAt.jopIngresarAutorCompleto.showMessageDialog(vMiAt, "Autor Registrado Exitosamente");
                vMiAt.txbIngresarAutorNombre1.setText("");
                vMiAt.txbIngresarAutorNombre2.setText("");
                vMiAt.txbIngresarAutorNombre3.setText("");
                vMiAt.txbIngresarAutorApellido1.setText("");
                vMiAt.txbIngresarAutorApellido2.setText("");
                vMiAt.txbIngresarAutorAlias.setText("");
                vMiAt.txbIngresarAutorPais.setText("");
                vMiAt.txbIngresarAutorCorreo.setText("");
            }else{
                vMiAt.jopIngresarAutorIncompleto.showMessageDialog(vMiAt, "Autor NO registrado");
            }
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getSource()==vMiAt.btnIngresarAutorRegistrar){
            this.registrarAutor();
        }
        if(e.getSource()==vMiAt.btnIngresarAutorCancelar){
            this.vMiAt.dispose();
        }
    }
    
}
