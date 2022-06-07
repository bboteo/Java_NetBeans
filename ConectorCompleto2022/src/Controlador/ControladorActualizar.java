/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Extras;
import Modelo.PaisDAO;
import Modelo.PaisVO;
import Vista.FrmActualizar;
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
public class ControladorActualizar implements ActionListener, WindowListener, MouseListener{

    FrmActualizar vAc = new FrmActualizar();
    PaisDAO pdao = new PaisDAO();
    PaisVO pvo = new PaisVO();

    public ControladorActualizar(FrmActualizar vAc, PaisVO pvo, PaisDAO pdao) {
        this.vAc = vAc;
        this.pdao = pdao;
        this.pvo = pvo;
        
        
        vAc.btnActualizarCancelar.addActionListener(this);
        vAc.addWindowListener(this);
        vAc.btnActualizarActualizar.addActionListener(this);
        vAc.tblActualizarMostrar.addMouseListener(this);
        
    }
    
    private void mostrarActualizar(){
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
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
        
        vAc.tblActualizarMostrar.setModel(m);
        //Para modificar el ancho de las columnas de la tabla
        TableColumn cCero = vAc.tblActualizarMostrar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        cCero.setMinWidth(75);
        
        TableColumn cUno = vAc.tblActualizarMostrar.getColumnModel().getColumn(0);
        cUno.setMaxWidth(120);
        cUno.setMinWidth(120);
                
    }
    
    private void seleccionarId(){
        int r = vAc.tblActualizarMostrar.getSelectedRow();     
        //Mostrar datos en la tabla
        String c0 = (String) vAc.tblActualizarMostrar.getValueAt(r, 0).toString();
        String c1 = (String) vAc.tblActualizarMostrar.getValueAt(r, 1).toString();
        String c2 = (String) vAc.tblActualizarMostrar.getValueAt(r, 2).toString();
        String c3 = (String) vAc.tblActualizarMostrar.getValueAt(r, 3).toString();
        
        vAc.txbActualizarIdPais.setText(c0);
        vAc.txbActualizarNombrePais.setText(c1);
        vAc.txbActualizarCapital.setText(c2);
        vAc.txbActualizarPoblacion.setText(c3);
        
        //Set id
        int idTable = (int) vAc.tblActualizarMostrar.getValueAt(r, 0);
        pvo.setIdPais(idTable);       
        
    }
    
    private void actualizar(){
        pvo.setNombrePais(vAc.txbActualizarNombrePais.getText());
        pvo.setCapital(vAc.txbActualizarCapital.getText());
        //int i = Integer.parseInt(vAc.txbActualizarPoblacion.getText());
        pvo.setPoblacionPais(Long.parseLong(vAc.txbActualizarPoblacion.getText()));
        pvo.setFechaActPais(Extras.fechaHoy());
        pdao.actualizar(pvo);
        
        vAc.jopActualizar.showMessageDialog(this.vAc, "Id Actualizado" + pvo.getIdPais());
        
        mostrarActualizar();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getSource()==vAc.btnActualizarCancelar){
            vAc.dispose();
        }
        
        if(e.getSource()==vAc.btnActualizarActualizar){
            actualizar();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.mostrarActualizar();
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
        this.mostrarActualizar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
