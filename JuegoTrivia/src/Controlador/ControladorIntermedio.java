
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
import Vista.FrmJugadorIntermedio;
import Vista.FrmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ControladorIntermedio implements ActionListener, WindowListener{
    FrmLogin vLo = new FrmLogin();
    FrmJugadorIntermedio vJi = new FrmJugadorIntermedio();
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
    String rU1, rU2, rU3, rU4, rU5;
    String rM1, rM2, rM3, rM4, rM5;
    
    //Agregar preguntas
    String q1, q2, q3, q4, q5;
    
    int nota = 0;
    int numIntento = 0;
    boolean calificado = false;

    public ControladorIntermedio(FrmLogin vLo ,FrmJugadorIntermedio vJi, FrmJugadorAvanzado vJa, 
            UsuarioVO uvo, UsuarioDAO udao, PunteoVO pvo, PunteoDAO pdao, 
            EstadoVO evo, EstadoDAO edao, TipoUsuarioVO tvo, TipoUsuarioDAO tdao,
            BitacoraVO bvo, BitacoraDAO bdao) {
        
        this.vLo = vLo;
        this.vJi = vJi;
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
        
        this.vJi.btnIntermedioQ1Next.addActionListener(this);
        this.vJi.btnIntermedioQ2Next1.addActionListener(this);
        this.vJi.btnIntermedioQ3Next.addActionListener(this);
        this.vJi.btnIntermedioQ4Next.addActionListener(this);
        this.vJi.btnIntermedioQ5Next.addActionListener(this);
        this.vJi.btnIntermedioRepetir.addActionListener(this);
        this.vJi.btnIntermedioSalir.addActionListener(this);
        this.vJi.addWindowListener(this);
        
        bvo.setDateInicio(ext.fechaHoy());
        
    }
    
    private void fechaBitacora(){
        ArrayList<BitacoraVO> info = new ArrayList<>();
        //Hay que encontrar el ultimo ID en bitacora
        bvo.setId(bdao.consutarBmaxId(uvo));
        info = bdao.consultarBintento(bvo);
        if(info.size()==0){
            vJi.txbIntermedioDate.setText(String.valueOf("-"));
            vJi.txbIntermedioPuntos.setText(String.valueOf(0));
            vJi.txbIntermedioIntentos.setText(String.valueOf(numIntento));
        }else{
            vJi.txbIntermedioDate.setText(String.valueOf(info.get(0).getDateInicio()));
            vJi.txbIntermedioPuntos.setText(String.valueOf(info.get(0).getPunteo()));
            vJi.txbIntermedioIntentos.setText(String.valueOf(info.get(0).getNumeroIntento()));
        }
        
    }
    
    private void inicializarF(){
        vJi.lblIntermedioUsuario.setText("Usuario: "+uvo.getUsuario());
        fechaBitacora();
        
        vJi.bproJugadorIntermedio.setValue(0);
        vJi.btnIntermedioQ5Next.setEnabled(true);
        
           
        //Respuestas
        rM1 = "Flores";
        rU1 = "";
        vJi.jcbIntermedioQ1Res.removeAllItems();
        vJi.jcbIntermedioQ1Res.addItem("Santa Ana");
        vJi.jcbIntermedioQ1Res.addItem("Melchor de Mencos");
        vJi.jcbIntermedioQ1Res.addItem("Flores");
        
        rM2 = "Orquidea";
        rU2 = "";
        vJi.jcbIntermedioQ2Res.removeAllItems();
        vJi.jcbIntermedioQ2Res.addItem("Crisantemo");
        vJi.jcbIntermedioQ2Res.addItem("Anemona");
        vJi.jcbIntermedioQ2Res.addItem("Orquidea");
        
        rM3 = "22";
        rU3 = "";
        vJi.jcbIntermedioQ3Res.removeAllItems();
        vJi.jcbIntermedioQ3Res.addItem("23");
        vJi.jcbIntermedioQ3Res.addItem("21");
        vJi.jcbIntermedioQ3Res.addItem("22");
        
        rM4 = "Una Republica";
        rU4 = "";
        vJi.jcbIntermedioQ4Res.removeAllItems();
        vJi.jcbIntermedioQ4Res.addItem("Una Federacion");
        vJi.jcbIntermedioQ4Res.addItem("Una Monarquia");
        vJi.jcbIntermedioQ4Res.addItem("Una Republica");
       
        rM5 = "tres";
        rU5 = "";
        vJi.jcbIntermedioQ5Res.removeAllItems();
        vJi.jcbIntermedioQ5Res.addItem("uno");
        vJi.jcbIntermedioQ5Res.addItem("dos");
        vJi.jcbIntermedioQ5Res.addItem("tres");
               
        //Preguntas
        q1 = "En que Municipio de Peten se encuentra el parque arqueologico TIKAL";
        q2 = "Que tipo de Flor es la moja Blanca";
        q3 = "Cuantos departamentos tiene Guatemala";
        q4 = "Seguin el sistema de Gobierno, Guatemala es: ";
        q5 = "Seleccione la respuesta 3";

        //Deshabilitar los paneles
        vJi.jTabbedPane1.setEnabledAt(0, false);
        vJi.jTabbedPane1.setEnabledAt(1, false);
        vJi.jTabbedPane1.setEnabledAt(2, false);
        vJi.jTabbedPane1.setEnabledAt(3, false);
        vJi.jTabbedPane1.setEnabledAt(4, false);
        
        //Enfocar la primer pregunta
        vJi.jTabbedPane1.setSelectedIndex(0);
        
        //Poner las preguntas en el panel
        vJi.txaIntermedioQ1Pregunta.setText(q1);
        vJi.txaIntermedioQ2Pregunta.setText(q2);
        vJi.txaIntermedioQ3Pregunta.setText(q3);
        vJi.txaIntermedioQ4Pregunta.setText(q4);
        vJi.txaIntermedioQ5Pregunta.setText(q5);
        
               
        nota = 0;
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
        pvo.setPunteo(11);
        pdao.actualizarP(pvo);
        //modificar tipo de usuario tblTipoUsuario
        uvo.setFkTipoUsuarioId(4);
        udao.actualizarUtipoUsuario(uvo);
        return true;
    }
    
    private void calificacion(){
        //Realizar proceso de if
        if(rU1.equals(rM1)) nota = nota + 1;
        if(rU2.equals(rM2)) nota = nota + 1;
        if(rU3.equals(rM3)) nota = nota + 1;
        if(rU4.equals(rM4)) nota = nota + 1;
        if(rU5.equals(rM5)) nota = nota + 1;
        
        if(nota == 5){
            vJi.jopIntermedioMensaje.showMessageDialog(vJi, "Su nota es: "+nota+" \n"+
                                                              "Felicidades completo el nivel");
            
            
            guardarFinal();
            this.vJa.setVisible(true);
            this.vJa.setLocationRelativeTo(vJi);
            this.vJa.setResizable(false);
            this.vJi.setVisible(false);
            
            }else{
            vJi.jopIntermedioMensaje.showMessageDialog(vJi,"Su nota es: "+nota+" \n"+
                                                             "Intentelo nuevamente\n"+ 
                                                             "Las respuestas corestas son: \n"+
                                                             rM1 + "\n"+
                                                             rM2 + "\n"+
                                                             rM3 + "\n"+
                                                             rM4 + "\n"+
                                                             rM5);
            guardarIntento();
            vJi.btnIntermedioQ5Next.setEnabled(false);
        }
        calificado = true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vJi.btnIntermedioQ1Next){
            rU1 = String.valueOf(vJi.jcbIntermedioQ1Res.getSelectedItem());
            vJi.bproJugadorIntermedio.setValue(20);
            vJi.jTabbedPane1.setSelectedIndex(1);
        }
        if(e.getSource()==vJi.btnIntermedioQ2Next1){
            rU2 = String.valueOf(vJi.jcbIntermedioQ2Res.getSelectedItem());
            vJi.bproJugadorIntermedio.setValue(40);
            vJi.jTabbedPane1.setSelectedIndex(2);
        }
        if(e.getSource()==vJi.btnIntermedioQ3Next){
            rU3 = String.valueOf(vJi.jcbIntermedioQ3Res.getSelectedItem());
            vJi.bproJugadorIntermedio.setValue(60);
            vJi.jTabbedPane1.setSelectedIndex(3);
        }
        if(e.getSource()==vJi.btnIntermedioQ4Next){
            rU4 = String.valueOf(vJi.jcbIntermedioQ4Res.getSelectedItem());
            vJi.bproJugadorIntermedio.setValue(80);
            vJi.jTabbedPane1.setSelectedIndex(4);
        }
        if(e.getSource()==vJi.btnIntermedioQ5Next){
            rU5 = String.valueOf(vJi.jcbIntermedioQ5Res.getSelectedItem());
            vJi.bproJugadorIntermedio.setValue(100);
            calificacion();
        }
        if(e.getSource()==vJi.btnIntermedioRepetir){
            if(!calificado) calificacion();
            inicializarF();
        }
        if(e.getSource()==vJi.btnIntermedioSalir){
            if(!calificado) calificacion();
            inicializarF();
            vJi.dispose();
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
        //guardarIntento();
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
