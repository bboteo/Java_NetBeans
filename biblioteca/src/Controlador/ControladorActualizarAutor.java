/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AutorDAO;
import Modelo.AutorVO;
import Modelo.Extras;
import Vista.FrmActualizarAutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ControladorActualizarAutor implements ActionListener,WindowListener{

    FrmActualizarAutor vMaAt = new FrmActualizarAutor();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();

    public ControladorActualizarAutor(FrmActualizarAutor vMaAt, AutorDAO adao, AutorVO avo) {
        this.vMaAt = vMaAt;
        this.adao = adao;
        this.avo = avo;
        
        this.vMaAt.btnActualizarAutor.addActionListener(this);
        this.vMaAt.btnActualizarCancelar.addActionListener(this);
        this.vMaAt.addWindowListener(this);
    }
    
    public void mostrarActual(){
        ArrayList<AutorVO> info = adao.consultarAxId(avo);        
        //Cargar informacion previa      
        vMaAt.txbActualizarIdAutor.setText(String.valueOf(info.get(0).getId()));
        vMaAt.txbActualizarNombre1.setText(info.get(0).getNombre1());
        vMaAt.txbActualizarNombre2.setText(info.get(0).getNombre2());
        vMaAt.txbActualizarNombre3.setText(info.get(0).getNombre3());
        vMaAt.txbActualizarApellido1.setText(info.get(0).getApellido1());
        vMaAt.txbActualizarApellido2.setText(info.get(0).getApellido2());
        vMaAt.txbActualizarAlias.setText(info.get(0).getAlias());
        vMaAt.txbActualizarPais.setText(info.get(0).getPais());
        vMaAt.txbActualizarCorreo.setText(info.get(0).getCorreo());
    }
    
    public void actualizarA(){
        avo.setNombre1(vMaAt.txbActualizarNombre1.getText().toString());
        avo.setNombre2(vMaAt.txbActualizarNombre2.getText().toString());
        avo.setNombre3(vMaAt.txbActualizarNombre3.getText().toString());
        avo.setApellido1(vMaAt.txbActualizarApellido1.getText().toString());
        avo.setApellido2(vMaAt.txbActualizarApellido2.getText().toString());
        avo.setAlias(vMaAt.txbActualizarAlias.getText().toString());
        avo.setPais(vMaAt.txbActualizarPais.getText().toString());
        avo.setCorreo(vMaAt.txbActualizarCorreo.getText().toString());
        avo.setFecha_modificacion(Extras.fechaHoy());
        
        adao.actualizar(avo);
        vMaAt.jopActualizarAutorAlerta.showMessageDialog(vMaAt, "Autor Actualizado Correctamente");
        vMaAt.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vMaAt.btnActualizarCancelar){
            vMaAt.dispose();
        }
        if(e.getSource()==vMaAt.btnActualizarAutor){
            actualizarA();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //mostrarActual();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        mostrarActual();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
