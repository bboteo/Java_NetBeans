/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AutorDAO;
import Modelo.AutorVO;
import Modelo.LibroDAO;
import Modelo.LibroVO;
import Vista.FrmActualizar;
import Vista.FrmActualizarAutor;
import Vista.FrmActualizarLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ControladorActualizar implements ActionListener, MouseListener, WindowListener{

    FrmActualizar vMa = new FrmActualizar();
    FrmActualizarAutor vMaAt = new FrmActualizarAutor();
    FrmActualizarLibro vMaLb = new FrmActualizarLibro();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();
    LibroDAO ldao = new LibroDAO();
    LibroVO lvo = new LibroVO();
    String seleccion = "";      
    
    public ControladorActualizar(FrmActualizar vMa, FrmActualizarAutor vMaAt, FrmActualizarLibro vMaLb,
            AutorDAO adao, AutorVO avo, LibroDAO ldao, LibroVO lvo) {
        this.vMa = vMa;
        this.vMaAt = vMaAt;
        this.vMaLb = vMaLb;
        this.adao = adao;
        this.avo = avo;
        this.ldao = ldao;
        this.lvo = lvo;
        
        this.vMa.btnActualizarAutores.addActionListener(this);
        this.vMa.btnActualizarLibros.addActionListener(this);
        this.vMa.btnActualizarClave.addActionListener(this);
        this.vMa.tblActualizarMostrar.addMouseListener(this);
        this.vMa.addWindowListener(this);
    }
    
    private void mostrarAutores(){
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id Autor");
        m.addColumn("Nombre");
        m.addColumn("Apellido");
        m.addColumn("Alias");
        m.addColumn("Nacionalidad");
        m.addColumn("Correo");
        
        for(AutorVO avo : adao.consultarA()){
            m.addRow(new Object[] {avo.getId(),avo.getNombre1(),
                avo.getApellido1(),avo.getAlias(),avo.getPais(), avo.getCorreo()});
        }
        
        
        vMa.tblActualizarMostrar.setModel(m);
            
    }
    
    private void mostrarLibros(){
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id Libro");
        m.addColumn("Nombre");
        m.addColumn("Saga");
        m.addColumn("#Libro");
        m.addColumn("Edicion");
        m.addColumn("#Paginas");
        m.addColumn("Fecha de Publicacion");
        
        for(LibroVO lvo : ldao.consultarL()){
            m.addRow(new Object[] {lvo.getId(), lvo.getNombre(),lvo.getSaga(),lvo.getNumeroLibro(),
                lvo.getEdicion(), lvo.getPaginas(), lvo.getFechaPublicacion() });
        }
        
        vMa.tblActualizarMostrar.setModel(m);
        
    }
    
    private void seleccionarId(){
        int r = vMa.tblActualizarMostrar.getSelectedRow();
        int idTable = ((int) vMa.tblActualizarMostrar.getValueAt(r, 0));
        if (seleccion.contentEquals("autores")){
            avo.setId(idTable);
        }
        if (seleccion.contentEquals("libros")){
            lvo.setId(idTable);
        }
    }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getSource()==vMa.btnActualizarAutores){
            this.mostrarAutores();
            seleccion = "autores";
        }
        if(e.getSource()==vMa.btnActualizarLibros){
            this.mostrarLibros();
            seleccion = "libros";
        }
        if(e.getSource()==vMa.btnActualizarClave){
            //this.mostrarClave();
            seleccion = "clave";
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getClickCount()==2 && seleccion.contentEquals("libros")){
            this.seleccionarId();
            vMaLb.setVisible(true);
            vMaLb.setLocationRelativeTo(vMa);
            vMaLb.setResizable(false);
        }
        if(e.getClickCount()==2 && seleccion.contentEquals("autores")){
            this.seleccionarId();
            vMaAt.setVisible(true);
            vMaAt.setLocationRelativeTo(vMa);
            vMaAt.setResizable(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        seleccion = "";
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        seleccion = "";
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
        if(seleccion.contentEquals("libros")){
            mostrarLibros();
        }
        if(seleccion.contentEquals("autores")){
            mostrarAutores();
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
