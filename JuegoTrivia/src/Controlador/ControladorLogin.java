
package Controlador;

import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import Vista.FrmAdministrador;
import Vista.FrmJugadorAvanzado;
import Vista.FrmJugadorIntermedio;
import Vista.FrmJugadorPrincipiante;
import Vista.FrmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements ActionListener{
    FrmLogin vLo = new FrmLogin();
    FrmAdministrador vAd = new FrmAdministrador();
    FrmJugadorPrincipiante vJp = new FrmJugadorPrincipiante();
    FrmJugadorIntermedio vJi = new FrmJugadorIntermedio();
    FrmJugadorAvanzado vJa =new FrmJugadorAvanzado();
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();

    public ControladorLogin(FrmLogin vLo, FrmAdministrador vAd, FrmJugadorPrincipiante vJp, FrmJugadorIntermedio vJi, FrmJugadorAvanzado vJa, 
            UsuarioDAO udao, UsuarioVO uvo) {
        this.vLo = vLo;
        this.vAd = vAd;
        this.vJp = vJp;
        this.vJi = vJi;
        this.vJa = vJa;
        this.udao = udao;
        this.uvo = uvo;
        
        vLo.btnAdminLogin.addActionListener(this);
    }

    private boolean validarUsuario(){
        //Se trata de ver si el usuario y contrasena existe en la base de datos
        uvo.setUsuario(vLo.txbLoginUsuario.getText().toString());
        uvo.setContrasena(String.valueOf(vLo.txbLoginContrasena.getPassword()));
        
        //validando el usuario
        if(udao.validarU(uvo)){
            //validando la contrasena
            if(udao.validarUc(uvo)){
                return true;
            }
        }
                
        return false;
    }
    
    private void autorizarUsuario(){
        //Se debe realizar otra consulta para extraer el resto de info
        udao.consultarUexacto(uvo);
        
        vLo.jopLoginMensaje.showMessageDialog(vLo, "Bienvenido "+uvo.getNombre()+" "+ uvo.getApellido());
        vLo.txbLoginUsuario.setText("");
        vLo.txbLoginContrasena.setText("");
        vLo.txbLoginUsuario.setEditable(false);
        vLo.txbLoginContrasena.setEditable(false);
        vLo.btnAdminLogin.setEnabled(false);
        
        
        switch (uvo.getFkTipoUsuarioId()) {
            case 1://Administrador
                this.vAd.setVisible(true);
                this.vAd.setLocationRelativeTo(vLo);
                this.vAd.setResizable(false);
                //this.vLo.dispose();
                break;
            case 2://Principiante
                this.vJp.setVisible(true);
                this.vJp.setLocationRelativeTo(vLo);
                this.vJp.setResizable(false);
                //this.vLo.dispose();
                break;
            case 3://Intermedio
                this.vJi.setVisible(true);
                this.vJi.setLocationRelativeTo(vLo);
                this.vJi.setResizable(false);
                //this.vLo.dispose();
                break;
            case 4://Avanzado
                this.vJa.setVisible(true);
                this.vJa.setLocationRelativeTo(vLo);
                this.vJa.setResizable(false);
                //this.vLo.dispose();
                break;
            case 5://Libre
                this.vLo.jopLoginMensaje.showMessageDialog(vLo, "Usted ya completo todos los niveles");
                vLo.txbLoginUsuario.setText("");
                vLo.txbLoginContrasena.setText("");
                vLo.txbLoginUsuario.setEditable(true);
                vLo.txbLoginContrasena.setEditable(true);
                vLo.btnAdminLogin.setEnabled(true);
                break;
            default://su tipo de usuario no corresponde
                
        }

    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vLo.btnAdminLogin){
            if(validarUsuario()){
                autorizarUsuario();
            }else{
                vLo.jopLoginMensaje.showMessageDialog(vLo, "Usuario o Contrasena \n"
                                                         + "     Incorrectos");
                vLo.txbLoginUsuario.setText("");
                vLo.txbLoginContrasena.setText("");
            }
            
        }
    }
    
    
}
