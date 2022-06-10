/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AutorDAO;
import Modelo.AutorVO;
import Modelo.LibroDAO;
import Modelo.LibroVO;
import Vista.FrmActualizarLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ControladorActualizarLibro implements ActionListener, WindowListener{
    
    FrmActualizarLibro vMaLb = new FrmActualizarLibro();
    LibroDAO ldao = new LibroDAO();
    LibroVO lvo = new LibroVO();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();
    
    //Para guardar los id seleccionados
    ArrayList<Integer> idAutor = new ArrayList<>();

    public ControladorActualizarLibro(FrmActualizarLibro vMaLb, LibroDAO ldao, LibroVO lvo,
            AutorDAO adao, AutorVO avo) {
        this.vMaLb = vMaLb;
        this.ldao = ldao;
        this.lvo = lvo;
        this.adao = adao;
        this.avo = avo;
        
        
        this.vMaLb.btnIngresarAutorRegistrar.addActionListener(this);
        this.vMaLb.btnIngresarAutorCancelar.addActionListener(this);
        this.vMaLb.addWindowListener(this);
        
    }
    
    private void autores(){
        int i = 0;
        idAutor.clear();
        //vMiLb.cbxIngresarLibroAutor.
        for(AutorVO avo : adao.consultarA()){
            vMaLb.cbxActualizarLibroAutor.addItem(avo.getNombre1()+" "+avo.getApellido1()
                    +" ("+avo.getAlias()+")");
            idAutor.add(i, avo.getId());
            i++;
        }
    }
    
    public void mostrarActual(){
        ArrayList<LibroVO> info = this.ldao.consultarLxId(lvo);
        //Cargar inofrmacion actual
        vMaLb.txbActualizarLibroId.setText(String.valueOf(info.get(0).getId()));
        //Hay que sacar al autor, ya conozco autor_id_fk en tabla libro
        this.avo.setId(lvo.getAutorIdFk());
        this.adao.consultarAxId(avo);
        
        vMaLb.cbxActualizarLibroAutor.setSelectedItem(avo.getNombre1()+" "+avo.getApellido1()+" ("+avo.getAlias()+")");
        //vMaLb.txbActualizarLibroNombre.setText(String.valueOf(info.get(1).getNombre()));
        //vMaLb.txbActualizarLibroSaga.setText(String.valueOf(info.get(2).getSaga()));
        //vMaLb.jcbActualizarLibroNumLibro.setSelectedItem(info.get(3));
        //vMaLb.jcbActualizarLibroEdicion.setSelectedItem(info.get(4));
        //vMaLb.txbActualizarLibroPaginas.setText(String.valueOf(info.get(5).getPaginas()));
        
        //Como Armar la fecha???
        
        
    }
    
    public void actualizarL(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getSource()==vMaLb.btnIngresarAutorCancelar){
            vMaLb.dispose();
        }
        if(e.getSource()==vMaLb.btnIngresarAutorRegistrar){
            actualizarL();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        autores();
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
