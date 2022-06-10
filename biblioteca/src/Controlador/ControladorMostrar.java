/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AutorDAO;
import Modelo.AutorVO;
import Modelo.LibroDAO;
import Modelo.LibroVO;
import Vista.FrmMostrar;
import Vista.FrmMostrarAutor;
import Vista.FrmMostrarLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bboteo
 */
public class ControladorMostrar implements ActionListener, MouseListener{
    FrmMostrar vMm = new FrmMostrar();
    FrmMostrarAutor vMmA = new FrmMostrarAutor();
    FrmMostrarLibros vMmL = new FrmMostrarLibros();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();
    LibroDAO ldao = new LibroDAO();
    LibroVO lvo = new LibroVO();
    String seleccion = "";

    public ControladorMostrar(FrmMostrar vMm, FrmMostrarAutor vMmA, FrmMostrarLibros vMmL,
            AutorDAO adao, AutorVO avo, LibroDAO ldao, LibroVO lvo) {
        this.vMmA = vMmA;
        this.vMmL = vMmL;
        this.vMm = vMm;
        this.adao = adao;
        this.avo = avo;
        this.ldao = ldao;
        this.avo = avo;
        
        this.vMm.btnMostrarAutores.addActionListener(this);
        this.vMm.btnMostrarLibros.addActionListener(this);
        this.vMm.btnMostrarClave.addActionListener(this);
        this.vMm.tblMostrarMostrar.addMouseListener(this);
        
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
        
        vMm.tblMostrarMostrar.setModel(m);
        
        
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
        
        vMm.tblMostrarMostrar.setModel(m);
        
    }
    
    private void seleccionarId(){
        int r = vMm.tblMostrarMostrar.getSelectedRow();
        int idTable = (int) vMm.tblMostrarMostrar.getValueAt(r, 0);
        if (seleccion.contentEquals("autores")){
            avo.setId(idTable);
            avo.setNombre1(vMm.tblMostrarMostrar.getValueAt(r, 1).toString());
            avo.setApellido1(vMm.tblMostrarMostrar.getValueAt(r, 2).toString());
        }
        if (seleccion.contentEquals("libros")){
            lvo.setId(idTable);
            lvo.setNombre(vMm.tblMostrarMostrar.getValueAt(r, 1).toString());
        }
    }
    
    //Para mostrar los libros del autor seleccionado
    private void mostrarLibrosAutor(){
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
        
        for(LibroVO lvo : ldao.consultaEL(avo)){
            m.addRow(new Object[] {lvo.getId(), lvo.getNombre(),lvo.getSaga(),lvo.getNumeroLibro(),
                lvo.getEdicion(), lvo.getPaginas(), lvo.getFechaPublicacion() });
        }
        
        vMmA.lbMostrarAutor.setText(avo.getNombre1()+" "+avo.getApellido1());
        vMmA.tblMostrarAutor.setModel(m);
    }
    
    //Para mostrar los autores del libro seleccionado
    private void mostrarAutorLibros(){
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
        
        for(AutorVO avo : adao.consultaEA(lvo)){
            m.addRow(new Object[] {avo.getId(),avo.getNombre1(),
                avo.getApellido1(),avo.getAlias(),avo.getPais(), avo.getCorreo()});
        }
        
        vMmL.lbMostrarLibro.setText(lvo.getNombre());
        vMmL.tblMostrarLibro.setModel(m);
    }
    
    private void mostrarClave(){
        String clave = vMm.txbMostrarClave.getText();
        vMm.lbMostrarBuscando.setText("Buscando: " + clave);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vMm.btnMostrarAutores){
            this.mostrarAutores();
            seleccion = "autores";
        }
        if(e.getSource()==vMm.btnMostrarLibros){
            this.mostrarLibros();
            seleccion = "libros";
        }
        if(e.getSource()==vMm.btnMostrarClave){
            this.mostrarClave();
            seleccion = "clave";
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2 && seleccion.contentEquals("libros")){
            //mostrarAutorLibros();
            vMmL.setVisible(true);
            vMmL.setLocationRelativeTo(vMm);
            vMmL.setResizable(false);
            seleccionarId();
            mostrarAutorLibros();
        }
        if(e.getClickCount()==2 && seleccion.contentEquals("autores")){
            vMmA.setVisible(true);
            vMmA.setLocationRelativeTo(vMm);
            vMmA.setResizable(false);
            seleccionarId();
            mostrarLibrosAutor();
        }
        if(e.getClickCount()==2 && seleccion.contentEquals("clave")){
            
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
    
    
}
