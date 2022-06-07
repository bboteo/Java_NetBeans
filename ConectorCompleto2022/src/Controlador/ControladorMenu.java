/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FrmActualizar;
import Vista.FrmEliminar;
import Vista.Frm_Mostrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Frm_insertar;
import Vista.Frm_menu;

/**
 *
 * @author bboteo
 */
public class ControladorMenu implements ActionListener {

    Frm_menu vMe = new Frm_menu();
    Frm_insertar vIn = new Frm_insertar();
    Frm_Mostrar vMo = new Frm_Mostrar();
    FrmEliminar vEl = new FrmEliminar();
    FrmActualizar vAc = new FrmActualizar();
    
    public ControladorMenu(Frm_menu vMe, Frm_insertar vIn, Frm_Mostrar vMo, FrmEliminar vEl, FrmActualizar vAc){
        this.vMe = vMe;
        this.vIn = vIn;
        this.vMo = vMo;
        this.vEl = vEl;
        this.vAc = vAc;
        
        vMe.jButton_insertar.addActionListener(this);
        vMe.jButton_mostrar.addActionListener(this);
        vMe.jButton_eliminar.addActionListener(this);
        vMe.jButton_actualizar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getSource() == this.vMe.jButton_insertar){
            this.vIn.setVisible(true);
            this.vIn.setLocationRelativeTo(vMo);
            this.vIn.setResizable(false);       
        }
        if(e.getSource() == this.vMe.jButton_mostrar){
            this.vMo.setVisible(true);
            this.vMo.setLocationRelativeTo(vMo);
            this.vMo.setResizable(false);       
        }
        if(e.getSource() == this.vMe.jButton_eliminar){
            this.vEl.setVisible(true);
            this.vEl.setLocationRelativeTo(vMo);
            this.vEl.setResizable(false);
        }
        
        if(e.getSource()==this.vMe.jButton_actualizar){
            this.vAc.setVisible(true);
            this.vAc.setLocationRelativeTo(vMo);
            this.vAc.setResizable(false);
        }
    }
    
}
