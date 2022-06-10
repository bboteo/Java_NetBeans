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
        ArrayList<LibroVO> infoL = ldao.consultarLxId(lvo);
        avo.setId(infoL.get(0).getAutorIdFk());
        ArrayList<AutorVO> infoA = adao.consultarAxId(avo);
        //Cargar inofrmacion actual
        vMaLb.txbActualizarLibroId.setText(String.valueOf(infoL.get(0).getId()));
        vMaLb.cbxActualizarLibroAutor.setEditable(true);
        vMaLb.cbxActualizarLibroAutor.setSelectedItem(infoA.get(0).getNombre1()+" "+
                infoA.get(0).getApellido1()+" ("+infoA.get(0).getAlias()+")");
        vMaLb.cbxActualizarLibroAutor.setEditable(false);
        vMaLb.txbActualizarLibroNombre.setText(infoL.get(0).getNombre());
        vMaLb.txbActualizarLibroSaga.setText(infoL.get(0).getSaga());
        vMaLb.jcbActualizarLibroNumLibro.setSelectedIndex(infoL.get(0).getNumeroLibro()-1);
        vMaLb.jcbActualizarLibroEdicion.setSelectedIndex(infoL.get(0).getEdicion()-1);
        vMaLb.txbActualizarLibroPaginas.setText(String.valueOf(infoL.get(0).getPaginas()));
        //Como Armar la fecha???
        String fechaPublicacion = infoL.get(0).getFechaPublicacion();
        vMaLb.txbActualizarLibroanio.setText(fechaPublicacion.substring(0, 4));
        vMaLb.txbActualizarLibroMes.setText(fechaPublicacion.substring(5, 7));
        vMaLb.txbActualizarLibroDia.setText(fechaPublicacion.substring(8, 10));
        
    }
    
    public void actualizarL(){
        lvo.setAutorIdFk(idAutor.get(vMaLb.cbxActualizarLibroAutor.getSelectedIndex()));
        lvo.setNombre(vMaLb.txbActualizarLibroNombre.getText());
        lvo.setSaga(vMaLb.txbActualizarLibroSaga.getText());
        
        lvo.setNumeroLibro(vMaLb.jcbActualizarLibroNumLibro.getSelectedIndex()+1);
        lvo.setEdicion(vMaLb.jcbActualizarLibroEdicion.getSelectedIndex()+1);
        lvo.setPaginas(Integer.parseInt(vMaLb.txbActualizarLibroPaginas.getText()));
        
        //Seleccionar la fecha
        String fecha = vMaLb.txbActualizarLibroanio.getText()+"-"
                +vMaLb.txbActualizarLibroMes.getText()+"-"
                +vMaLb.txbActualizarLibroDia.getText();
        lvo.setFechaPublicacion(fecha);
        
        if(lvo.getNombre().isEmpty()||lvo.getPaginas()==0||lvo.getFechaPublicacion()=="//"){
            vMaLb.jopActualizarLibroAlerta.showMessageDialog(vMaLb,"Datos Obligatorios incompletos");
        }else{
            ldao.actualizarL(lvo);
            vMaLb.jopActualizarLibroAlerta.showMessageDialog(vMaLb, "Libro Actualizado correctamente");
        }
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
