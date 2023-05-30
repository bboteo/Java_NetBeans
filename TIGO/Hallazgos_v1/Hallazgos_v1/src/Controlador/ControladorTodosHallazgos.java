
package Controlador;

import Vista.FrmTodosHallazgos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTodosHallazgos implements ActionListener {
    FrmTodosHallazgos vTh = new FrmTodosHallazgos();

    public ControladorTodosHallazgos(FrmTodosHallazgos vTh) {
        this.vTh = vTh;
        
        
        //Agregar metodos del Listener
        this.vTh.btnTodosSalir.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vTh.btnTodosSalir){
            vTh.dispose();
        }
    }
    
    
    
}
