/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.PaisDAO;
import Modelo.PaisVO;
import Vista.FrmEliminar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author bboteo
 */
public class ControladorEliminar implements ActionListener, WindowListener, MouseListener{

    FrmEliminar vEl = new FrmEliminar();
    PaisDAO pdao = new PaisDAO();
    PaisVO pvo = new PaisVO();
    
    public ControladorEliminar(FrmEliminar vEl, PaisVO pvo, PaisDAO pdao ) {
        this.vEl = vEl;
        this.pdao = pdao;
        this.pvo = pvo;
        
        vEl.btnEliminarCancelar.addActionListener(this);
        vEl.addWindowListener(this);
        vEl.tblEliminarMostrar.addMouseListener(this);
    }
    
    private void mostrarEliminar(){
        //Modificaciones para la tabla
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id del Pais");
        m.addColumn("Nombre del Pais");
        m.addColumn("Capital del Pais");
        m.addColumn("Poblacion del Pais");
        
        for(PaisVO pvo : pdao.consultar()){
            m.addRow(new Object[] {pvo.getIdPais(), pvo.getNombrePais(),
                pvo.getCapital(),pvo.getPoblacionPais()});
        }
        
        vEl.tblEliminarMostrar.setModel(m);
        //Para modificar el ancho de las columnas de la tabla
        TableColumn cCero = vEl.tblEliminarMostrar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        cCero.setMinWidth(75);
        
        TableColumn cUno = vEl.tblEliminarMostrar.getColumnModel().getColumn(0);
        cUno.setMaxWidth(120);
        cUno.setMinWidth(120);
        
        //Parametros para manejar la tabla
        
    }
    
    private void seleccionarId(){
        int r = vEl.tblEliminarMostrar.getSelectedRow();
        int idTable = (int) vEl.tblEliminarMostrar.getValueAt(r, 0);
        pvo.setIdPais(idTable);
        pdao.eliminar(pvo);
        vEl.jopEliminar.showMessageDialog(this.vEl, "Id Eliminado: "+ idTable);
        mostrarEliminar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (e.getSource()==vEl.btnEliminarCancelar){
            vEl.dispose();
        }       
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.mostrarEliminar();
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
        this.mostrarEliminar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Acciones del Mouse Listener

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getClickCount()==2){
            seleccionarId();
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
