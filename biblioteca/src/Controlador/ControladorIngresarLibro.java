/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AutorDAO;
import Modelo.AutorVO;
import Modelo.LibroDAO;
import Modelo.LibroVO;
import Vista.FrmIngresarLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Array;
import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public class ControladorIngresarLibro implements ActionListener, WindowListener{
    FrmIngresarLibro vMiLb = new FrmIngresarLibro();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();
    
    //Para guardar los id seleccionados
    ArrayList<Integer> idAutor = new ArrayList<>();
    
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();

    public ControladorIngresarLibro(FrmIngresarLibro vMiLb, LibroVO lvo, LibroDAO ldao, AutorVO avo, AutorDAO adao) {
        this.vMiLb = vMiLb;
        this.lvo = lvo;
        this.ldao = ldao;
        this.avo = avo;
        this.adao = adao;
        
        vMiLb.btnIngresarAutorRegistrar.addActionListener(this);
        vMiLb.btnIngresarAutorCancelar.addActionListener(this);
        vMiLb.addWindowListener(this);
    }
    
    private void registrarLibro(){        
        lvo.setAutorIdFk(idAutor.get(vMiLb.cbxIngresarLibroAutor.getSelectedIndex()));
        lvo.setNombre(vMiLb.txbIngresarLibroNombre.toString());
        lvo.setSaga(vMiLb.txbIngresarLibroSaga.toString());
        lvo.setNumeroLibro(vMiLb.jcbIngresarLibroNumLibro.getSelectedIndex()+1);
        lvo.setEdicion(vMiLb.jcbIngresarLibroEdicion.getSelectedIndex()+1);
        lvo.setPaginas(Integer.parseInt(vMiLb.txbIngresarLibroPaginas.getText()));
        
        //Seleccionar la fecha
        String fecha = vMiLb.txbIngresarLibroanio+"-"
                +vMiLb.txbIngresarLibroMes+"-"
                +vMiLb.txbIngresarLibroDia;
        lvo.setFechaPublicacion(fecha);
        
        if(lvo.getNombre().isEmpty()||lvo.getPaginas()==0||lvo.getFechaPublicacion()=="//"){
            vMiLb.jopInsertarLibroAlerta.showMessageDialog(vMiLb,"Datos Obligatorios incompletos");
        }else{
            if(ldao.insertarL(lvo)){
                vMiLb.jopInsertarLibroAlerta.showMessageDialog(vMiLb, "Libro Registrado correctamente");
                vMiLb.txbIngresarLibroNombre.setText("");
                vMiLb.txbIngresarLibroSaga.setText("");
                vMiLb.txbIngresarLibroPaginas.setText("");
                vMiLb.txbIngresarLibroDia.setText("");
                vMiLb.txbIngresarLibroMes.setText("");
                vMiLb.txbIngresarLibroanio.setText("");    
            }else{
                vMiLb.jopInsertarLibroAlerta.showMessageDialog(vMiLb, "Libro NO Registrado");
            }
        }
        
        
    }
    
    private void autores(){
        int i = 0;
        idAutor.clear();
        //vMiLb.cbxIngresarLibroAutor.
        for(AutorVO avo : adao.consultarA()){
            vMiLb.cbxIngresarLibroAutor.addItem(avo.getNombre1()+" "+avo.getApellido1()
                    +" ("+avo.getAlias()+")");
            idAutor.add(i, avo.getId());
            i++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getSource()==vMiLb.btnIngresarAutorRegistrar){
            registrarLibro();
        }
        if(e.getSource()==vMiLb.btnIngresarAutorCancelar){
            vMiLb.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.autores();
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
        //this.autores();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
