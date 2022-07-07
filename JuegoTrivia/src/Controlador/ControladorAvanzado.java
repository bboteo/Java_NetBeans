
package Controlador;

import Modelo.BitacoraDAO;
import Modelo.BitacoraVO;
import Modelo.EstadoDAO;
import Modelo.EstadoVO;
import Modelo.Extras;
import Modelo.PunteoDAO;
import Modelo.PunteoVO;
import Modelo.TipoUsuarioDAO;
import Modelo.TipoUsuarioVO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import Vista.FrmJugadorAvanzado;
import Vista.FrmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ControladorAvanzado implements ActionListener, WindowListener{
    FrmLogin vLo = new FrmLogin();
    FrmJugadorAvanzado vJa = new FrmJugadorAvanzado();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    PunteoVO pvo = new PunteoVO();
    PunteoDAO pdao = new PunteoDAO();
    EstadoVO evo = new EstadoVO();
    EstadoDAO edao = new EstadoDAO();
    TipoUsuarioVO tvo = new TipoUsuarioVO();
    TipoUsuarioDAO tdao = new TipoUsuarioDAO();
    BitacoraVO bvo = new BitacoraVO();
    BitacoraDAO bdao = new BitacoraDAO();
    
    //Para los extras
    Extras ext = new Extras();
    
    //Respuestas de la maquina
    int rM1;
    String rM2, rM3, rM4;
    //Respuestas del usuario
    int rU1;
    String rU2, rU3, rU4;
    
    //Para las preguntas
    int q1;
    String q2,q3,q4;
    
    int nota = 0;
    int numIntento = 0;
    boolean calificado = false;
    int q1Intento; //Para contar los 3 intentos de la pregunta 1

    public ControladorAvanzado(FrmLogin vLo ,FrmJugadorAvanzado vJa,
            UsuarioVO uvo, UsuarioDAO udao, PunteoVO pvo, PunteoDAO pdao, 
            EstadoVO evo, EstadoDAO edao, TipoUsuarioVO tvo, TipoUsuarioDAO tdao,
            BitacoraVO bvo, BitacoraDAO bdao) {
        
        this.vLo =vLo;
        this.vJa = vJa;
        this.uvo = uvo;
        this.udao = udao;
        this.pvo = pvo;
        this.pdao = pdao;
        this.evo = evo;
        this.edao = edao;
        this.tvo = tvo;
        this.tdao = tdao;
        this.bvo = bvo;
        this.bdao =bdao;
        
        this.vJa.btnAvanzadoQ1Next.addActionListener(this);
        this.vJa.btnAvanzadoQ2Next1.addActionListener(this);
        this.vJa.btnAvanzadoQ3Next2.addActionListener(this);
        this.vJa.btnAvanzadoQ4Next.addActionListener(this);
        this.vJa.btnAvanzadoRepetir.addActionListener(this);
        this.vJa.btnAvanzadoSalir.addActionListener(this);
        this.vJa.addWindowListener(this);
        
        bvo.setDateInicio(ext.fechaHoy());
        
    }
    
    private void fechaBitacora(){
        ArrayList<BitacoraVO> info = new ArrayList<>();
        //Hay que encontrar el ultimo ID en bitacora
        bvo.setId(bdao.consutarBmaxId(uvo));
        info = bdao.consultarBintento(bvo);
        if(info.size()==0){
            vJa.txbAvanzadoDate.setText(String.valueOf("-"));
            vJa.txbAvanzadoPuntos.setText(String.valueOf(0));
            vJa.txbAvanzadoIntentos.setText(String.valueOf(numIntento));
        }else{
            vJa.txbAvanzadoDate.setText(String.valueOf(info.get(0).getDateInicio()));
            vJa.txbAvanzadoPuntos.setText(String.valueOf(info.get(0).getPunteo()));
            vJa.txbAvanzadoIntentos.setText(String.valueOf(info.get(0).getNumeroIntento()));
        }
    }

    private void inicializarF(){
        vJa.lblAvanzadoUsuario.setText("Usuario: "+uvo.getUsuario());
        fechaBitacora();
        
        vJa.bproJugadorAvanzado.setValue(0);
        vJa.btnAvanzadoQ4Next.setEnabled(true);
        
        //Preguntas
        q1 = ext.aleatorio();
        q2 = "house";
        q3 = "dog";
        q4 = "cat";
        
        //Respuestas
        rU1=0;
        rU2="";
        rU3="";
        rU4="";
        
        rM1=q1;
        rM2="casa";
        rM3="perro";
        rM4="gato";
        
        
        
        //Desabilitar paneles
        vJa.jTabbedPane1.setEnabledAt(0, false);
        vJa.jTabbedPane1.setEnabledAt(1, false);
        vJa.jTabbedPane1.setEnabledAt(2, false);
        vJa.jTabbedPane1.setEnabledAt(3, false);
        
        //Enfocar la primer pregunta
        vJa.jTabbedPane1.setSelectedIndex(0);
        
        //Poner las preguntas en el panel
        vJa.txaAvanzadoQ1Pregunta.setText("Elija un numero entre 0 y 10\nHint: "+q1);
        vJa.txaAvanzadoQ2Pregunta.setText("Traduzca al Espanol: "+q2 );
        vJa.txaAvanzadoQ3Pregunta.setText("Traduzca al Espanol: "+q3 );
        vJa.txaAvanzadoQ4Pregunta.setText("Traduzca al Espanol: "+q4 );
        
        //Limpiar los paneles de respuestas
        vJa.txbAvanzadoQ1Res.setText("");
        vJa.txbAvanzadoQ2Res.setText("");
        vJa.txbAvanzadoQ3Res.setText("");
        vJa.txbAvanzadoQ4Res.setText("");
        
        nota = 0;
        q1Intento = 3;
        calificado = false;
        numIntento++;
        
    }
    
    private boolean guardarIntento(){
        //Guardar en Bitacora
        bvo.setDateFinal(ext.fechaHoy());
        bvo.setNumeroIntento(numIntento);
        bvo.setPunteo(nota);
        bvo.setFkUsuarioId(uvo.getId());
        bvo.setFkTipoUsuarioId(uvo.getFkTipoUsuarioId());
        
        bdao.insertarB(bvo);
        return true;
    }
    
    private boolean guardarFinal(){
        guardarIntento();
        //modificar nota en tblPunteo
        pvo.setId(uvo.getFkPunteoId());
        pvo.setPunteo(17);
        pdao.actualizarP(pvo);
        //modificar tipo de usuario tblTipoUsuario
        uvo.setFkTipoUsuarioId(5);
        udao.actualizarUtipoUsuario(uvo);
        return true;
    }
    
    private void calificacion(){
        //Proceso de if
        nota = nota +q1Intento;
        if(rU2.toLowerCase().equals(rM2)) nota = nota +1;
        if(rU3.toLowerCase().equals(rM3)) nota = nota +1;
        if(rU4.toLowerCase().equals(rM4)) nota = nota +1;
        
        if(nota == 6){
            guardarFinal();
            vJa.jopAvanzadoMensaje.showMessageDialog(vJa, "Felicidades completo el Juego\n"
                                                          +uvo.getNombre()+" "+uvo.getApellido()+"\n"
                                                          +"Punteo Final: "+pvo.getPunteo());
            
                                  
            vJa.dispose();
            vLo.setVisible(true);
            vLo.txbLoginUsuario.setEditable(true);
            vLo.txbLoginContrasena.setEditable(true);
            vLo.btnAdminLogin.setEnabled(true);
            
            }else{
            vJa.jopAvanzadoMensaje.showMessageDialog(vJa,"Su nota es: "+nota+" \n"+
                                                             "Intentelo nuevamente\n"+ 
                                                             "Las respuestas corestas son: \n"+
                                                             rM1 + "\n"+
                                                             rM2 + "\n"+
                                                             rM3 + "\n"+
                                                             rM4 + "\n");
            guardarIntento();
            vJa.btnAvanzadoQ4Next.setEnabled(false);
        }
        calificado = true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vJa.btnAvanzadoQ1Next){
            try {
                rU1 = Integer.parseInt(vJa.txbAvanzadoQ1Res.getText());
                if(rU1 == rM1){
                    vJa.bproJugadorAvanzado.setValue(25);
                    vJa.jTabbedPane1.setSelectedIndex(1);
                }else{
                    q1Intento--;
                    if(q1Intento==0){
                        vJa.bproJugadorAvanzado.setValue(25);
                        vJa.jTabbedPane1.setSelectedIndex(1);
                    }
                    if(q1Intento > 0){
                        vJa.jopAvanzadoMensaje.showMessageDialog(vJa, "Tiene "+q1Intento+" intentos mas");
                        vJa.txbAvanzadoQ1Res.setText("");    
                    }
                }
                                    
            } catch (Exception er) {
                vJa.jopAvanzadoMensaje.showMessageDialog(vJa, "El valor debe ser un entero");
                vJa.txbAvanzadoQ1Res.setText("");
            }
        }
        if(e.getSource()==vJa.btnAvanzadoQ2Next1){
            rU2 = vJa.txbAvanzadoQ2Res.getText();
            vJa.bproJugadorAvanzado.setValue(50);
            vJa.jTabbedPane1.setSelectedIndex(2);
        }
        if(e.getSource()==vJa.btnAvanzadoQ3Next2){
            rU3 = vJa.txbAvanzadoQ3Res.getText();
            vJa.bproJugadorAvanzado.setValue(75);
            vJa.jTabbedPane1.setSelectedIndex(3);
        }
        if(e.getSource()==vJa.btnAvanzadoQ4Next){
            rU4 = vJa.txbAvanzadoQ4Res.getText();
            vJa.bproJugadorAvanzado.setValue(100);
            calificacion();
        }
        if(e.getSource()==vJa.btnAvanzadoRepetir){
            if(!calificado) calificacion();
            inicializarF();
        }
        if(e.getSource()==vJa.btnAvanzadoSalir){
            if(!calificado) calificacion();
            inicializarF();
            vJa.dispose();
            vLo.setVisible(true);
            vLo.txbLoginUsuario.setEditable(true);
            vLo.txbLoginContrasena.setEditable(true);
            vLo.btnAdminLogin.setEnabled(true);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        inicializarF();
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        if(!calificado) guardarIntento();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    
    
}
