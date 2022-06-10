/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AutorDAO;
import Modelo.AutorVO;
import Modelo.LibroDAO;
import Modelo.LibroVO;
import Vista.FrmEliminar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bboteo
 */
public class ControladorEliminar implements ActionListener, MouseListener{

    FrmEliminar vMe = new FrmEliminar();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();
    LibroDAO ldao = new LibroDAO();
    LibroVO lvo = new LibroVO();
    String seleccion = "";

    public ControladorEliminar(FrmEliminar vMe, AutorDAO adao, AutorVO avo, LibroDAO ldao, LibroVO lvo) {
        this.vMe = vMe;
        this.adao = adao;
        this.avo = avo;
        this.ldao = ldao;
        this.lvo = lvo;
        
        this.vMe.btnEliminarAutores.addActionListener(this);
        this.vMe.btnEliminarLibros.addActionListener(this);
        this.vMe.btnEliminarClave.addActionListener(this);
        this.vMe.tbEliminarMostrar.addMouseListener(this);
        
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
        
        vMe.tbEliminarMostrar.setModel(m);
            
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
        
        vMe.tbEliminarMostrar.setModel(m);
        
    }
    
    private void seleccionarId(){
        int r = vMe.tbEliminarMostrar.getSelectedRow();
        int idTable = (int) vMe.tbEliminarMostrar.getValueAt(r, 0);
        if (seleccion.contentEquals("autores")){
            avo.setId(idTable);
            avo.setNombre1(vMe.tbEliminarMostrar.getValueAt(r, 1).toString());
            avo.setApellido1(vMe.tbEliminarMostrar.getValueAt(r, 2).toString());
        }
        if (seleccion.contentEquals("libros")){
            lvo.setId(idTable);
            lvo.setNombre(vMe.tbEliminarMostrar.getValueAt(r, 1).toString());
        }
    }
    
    private void eliminarA(){
        //Condicion para eliminar un autor es que no tenga libros asociados
        if(ldao.consultaEL(avo).isEmpty()){
            //Se puede eliminar el autor
            adao.eliminarA(avo);
            this.vMe.jopEliminarAlerta.showMessageDialog(vMe, "Autor Eliminado Correctamente");
            this.mostrarAutores();
        }else{
            //no se puede eliminar el autor
            this.vMe.jopEliminarAlerta.showMessageDialog(vMe, "El autor seleccionado"
                    + "aun tiene libros asignados, NO PUEDE ELIMINARSE");
        }
    }
    
    private void eliminarL(){
        //Libros pueden eliminarse sin problemas
        ldao.eliminarL(lvo);
        this.vMe.jopEliminarAlerta.showMessageDialog(vMe, "Libro Eliminado Correctamente");
        this.mostrarLibros();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vMe.btnEliminarAutores){
            this.mostrarAutores();
            seleccion = "autores";
        }
        if(e.getSource()==vMe.btnEliminarLibros){
            this.mostrarLibros();
            seleccion = "libros";
        }
        if(e.getSource()==vMe.btnEliminarClave){
            //this.mostrarClave();
            seleccion = "clave";
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2 && seleccion.contentEquals("libros")){
            this.seleccionarId();
            this.eliminarL();
        }
        if(e.getClickCount()==2 && seleccion.contentEquals("autores")){
            this.seleccionarId();
            this.eliminarA();
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
