/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FrmActualizar;
import Vista.FrmActualizarAutor;
import Vista.FrmActualizarLibro;
import Vista.FrmEliminar;
import Vista.FrmIngresarAutor;
import Vista.FrmIngresarLibro;
import Vista.FrmMenu;
import Vista.FrmMostrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bboteo
 */
public class ControladorMenuPrincipal implements ActionListener{
    FrmMenu vMp = new FrmMenu();
    FrmIngresarAutor vMiAt = new FrmIngresarAutor();
    FrmIngresarLibro vMiLb = new FrmIngresarLibro();
    FrmMostrar vMm = new FrmMostrar();
    FrmActualizar vMa = new FrmActualizar();
    FrmActualizarAutor vMaAt = new FrmActualizarAutor();
    FrmActualizarLibro vMaLb = new FrmActualizarLibro();
    FrmEliminar vMe = new FrmEliminar();

    public ControladorMenuPrincipal(FrmMenu vMp, FrmIngresarAutor vMiAt, FrmIngresarLibro vMiLb, 
            FrmMostrar vMm, FrmActualizar vMa, FrmActualizarAutor vMaAt, FrmActualizarLibro vMaLb,
            FrmEliminar vMe) {
        
        this.vMp = vMp;
        this.vMiAt = vMiAt;
        this.vMiLb = vMiLb;
        this.vMm = vMm;
        this.vMa = vMa;
        this.vMaAt = vMaAt;
        this.vMaLb = vMaLb;
        this.vMe = vMe;
        
        this.vMp.btnMenuIngresoAutor.addActionListener(this);
        this.vMp.btnMenuIngresoLibro.addActionListener(this);
        this.vMp.btnMenuActualizar.addActionListener(this);
        this.vMp.btnMenuMostrar.addActionListener(this);
        this.vMp.btnMenuEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getSource()==vMp.btnMenuIngresoAutor){
            this.vMiAt.setVisible(true);
            this.vMiAt.setLocationRelativeTo(vMp);
            this.vMiAt.setResizable(false);
        }
        if(e.getSource()==vMp.btnMenuIngresoLibro){
            this.vMiLb.setVisible(true);
            this.vMiLb.setLocationRelativeTo(vMp);
            this.vMiLb.setResizable(false);
        }
        if(e.getSource()==vMp.btnMenuMostrar){
            this.vMm.setVisible(true);
            this.vMm.setLocationRelativeTo(vMp);
            this.vMm.setResizable(false);
        }
        if(e.getSource()==vMp.btnMenuActualizar){
            this.vMa.setVisible(true);
            this.vMa.setLocationRelativeTo(vMp);
            this.vMa.setResizable(false);
        }
        if(e.getSource()==vMp.btnMenuEliminar){
            this.vMe.setVisible(true);
            this.vMe.setLocationRelativeTo(vMp);
            this.vMe.setResizable(false);
        }
    }

    
    
    
}
