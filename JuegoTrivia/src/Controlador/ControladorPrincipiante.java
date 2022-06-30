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
import Vista.FrmJugadorIntermedio;
import Vista.FrmJugadorPrincipiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ControladorPrincipiante implements ActionListener, WindowListener{
    FrmJugadorPrincipiante vJp = new FrmJugadorPrincipiante();
    FrmJugadorIntermedio vJi = new FrmJugadorIntermedio();
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
    int rM1,rM2,rM3,rM4,rM5,rM6;
    int rU1,rU2,rU3,rU4,rU5,rU6;
    
    //Agreagar preguntas:
    int q11,q12,q21,q22,q31,q32,q41,q42,q51,q52,q61,q62;
    
    int nota = 0;
    int numIntento = 0;
    boolean calificado = false;
      
    public ControladorPrincipiante(FrmJugadorPrincipiante vJp, FrmJugadorIntermedio vJi,
            UsuarioVO uvo, UsuarioDAO udao, PunteoVO pvo, PunteoDAO pdao,
            EstadoVO evo, EstadoDAO edao, TipoUsuarioVO tvo, TipoUsuarioDAO tdao,
            BitacoraVO bvo, BitacoraDAO bdao) {
        
        this.vJp = vJp;
        this.vJi = vJi;
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
        
        this.vJp.btnPrincipianteQ1Next.addActionListener(this);
        this.vJp.btnPrincipianteQ2Next.addActionListener(this);
        this.vJp.btnPrincipianteQ3Next.addActionListener(this);
        this.vJp.btnPrincipianteQ4Next.addActionListener(this);
        this.vJp.btnPrincipianteQ5Next.addActionListener(this);
        this.vJp.btnPrincipianteQ6End.addActionListener(this);
        this.vJp.btnPrincipianteRepetir.addActionListener(this);
        this.vJp.addWindowListener(this);
        
        bvo.setDateInicio(ext.fechaHoy());
      
    }
    
    private void inicializarF(){
        
        vJp.lblPrincipianteUsuario.setText("Usuario: "+uvo.getUsuario());
        //Hay que agregar la fecha y el ultimo punteo
        fechaBitacora();   

        vJp.bproJugadorPrincipiante.setValue(0);
        vJp.btnPrincipianteQ6End.setEnabled(true);
        
        //Respuestas
        rU1=0;
        rU2=0;
        rU3=0;
        rU4=0;
        rU5=0;
        rU6=0;
        
        rM1=0;
        rM2=0;
        rM3=0;
        rM4=0;
        rM5=0;
        rM6=0;
        
        //Para preguntas
        q11 = ext.aleatorio();
        q12 = 1;//ext.aleatorio();
        q21 = ext.aleatorio();
        q22 = 1;//ext.aleatorio();
        q31 = ext.aleatorio();
        q32 = 1;//ext.aleatorio();
        q41 = ext.aleatorio();
        q42 = 1;//ext.aleatorio();
        q51 = ext.aleatorio();
        q52 = 1;//ext.aleatorio();
        q61 = ext.aleatorio();
        q62 = 1; //ext.aleatorio(); 
        
        //Desabilitar los paneles
        vJp.jTabbedPane1.setEnabledAt(0, false);
        vJp.jTabbedPane1.setEnabledAt(1, false);
        vJp.jTabbedPane1.setEnabledAt(2, false);
        vJp.jTabbedPane1.setEnabledAt(3, false);
        vJp.jTabbedPane1.setEnabledAt(4, false);
        vJp.jTabbedPane1.setEnabledAt(5, false);
        
        //Enfocar la primera pregunta
        vJp.jTabbedPane1.setSelectedIndex(0);
        
        //poner las preguntas en el panel
        vJp.txaPrincipianteQ1Pregunta.setText(q11+" + "+q12+" = ?");
        vJp.txaPrincipianteQ2Pregunta.setText(q21+" + "+q22+" = ?");
        vJp.txaPrincipianteQ3Pregunta.setText(q31+" - "+q32+" = ?\n"
                + "(Use el signo (-) para respuestas negativas)");
        vJp.txaPrincipianteQ4Pregunta.setText(q41+" - "+q42+" = ?\n"
                + "(Use el signo (-) para respuestas negativas)");
        vJp.txaPrincipianteQ5Pregunta.setText(q51+" * "+q52+" = ?");
        vJp.txaPrincipianteQ6Pregunta.setText(q61+" / "+q62+" = ?\n"
                + "(solo responder con la parte entera)");
        
        //Respuestas:
        rM1 = q11 + q12;
        rM2 = q21 + q22;
        rM3 = q31 - q32;
        rM4 = q41 - q42;
        rM5 = q51 * q52;
        rM6 = q61 / q62;
        
        //Limpiar los paneles de respuestas
        vJp.txbPrincipianteQ1Res.setText("");
        vJp.txbPrincipianteQ2Res.setText("");
        vJp.txbPrincipianteQ3Res.setText("");
        vJp.txbPrincipianteQ4Res.setText("");
        vJp.txbPrincipianteQ5Res.setText("");
        vJp.txbPrincipianteQ6Res.setText("");
        
        nota = 0;
        calificado = false;
        numIntento++;
        
    }
    
    private void fechaBitacora(){
        ArrayList<BitacoraVO> info = new ArrayList<>();
        //Hay que encontrar el ultimo ID en bitacora
        bvo.setId(bdao.consutarBmaxId(uvo));
        info = bdao.consultarBintento(bvo);
        vJp.txbPrincipianteDate.setText(String.valueOf(info.get(0).getDateInicio()));
        vJp.txbPrincipiantePuntos.setText(String.valueOf(info.get(0).getPunteo()));
        vJp.txbPrincipianteIntentos.setText(String.valueOf(info.get(0).getNumeroIntento()));
    }
    
    private void calificacion(){
        if((rU1 == rM1)&& !vJp.txbPrincipianteQ1Res.getText().isEmpty()) nota = nota + 1;
        if((rU2 == rM2)&& !vJp.txbPrincipianteQ1Res.getText().isEmpty()) nota = nota + 1;
        if((rU3 == rM3)&& !vJp.txbPrincipianteQ1Res.getText().isEmpty()) nota = nota + 1;
        if((rU4 == rM4)&& !vJp.txbPrincipianteQ1Res.getText().isEmpty()) nota = nota + 1;
        if((rU5 == rM5)&& !vJp.txbPrincipianteQ1Res.getText().isEmpty()) nota = nota + 1;
        if((rU6 == rM6)&& !vJp.txbPrincipianteQ1Res.getText().isEmpty()) nota = nota + 1;
        
        if(nota == 6){
            vJp.jopPrincipianteMensaje.showMessageDialog(vJp, "Su nota es: "+nota+" \n"+
                                                              "Felicidades completo el nivel");
            
            
            guardarFinal();
            this.vJi.setVisible(true);
            this.vJi.setLocationRelativeTo(vJp);
            this.vJi.setResizable(false);
            this.vJp.setVisible(false);
            
            }else{
            vJp.jopPrincipianteMensaje.showMessageDialog(vJp,"Su nota es: "+nota+" \n"+
                                                             "Intentelo nuevamente\n"+ 
                                                             "Las respuestas corestas son: \n"+
                                                              q11+" + "+q12+" = "+rM1+"\n"+
                                                              q21+" + "+q22+" = "+rM2+"\n"+
                                                              q31+" + "+q32+" = "+rM3+"\n"+
                                                              q41+" + "+q42+" = "+rM4+"\n"+
                                                              q51+" + "+q52+" = "+rM5+"\n"+
                                                              q61+" + "+q62+" = "+rM6+"\n");
            guardarIntento();
            vJp.btnPrincipianteQ6End.setEnabled(false);
        }
        calificado = true;
    }
    
    private boolean guardarIntento(){
        //Guardar en Bitacora
        //bvo.setDateInicio(ext.fechaHoy());
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
        pvo.setPunteo(6);
        pdao.actualizarP(pvo);
        //modificar tipo de usuario tblTipoUsuario
        uvo.setFkTipoUsuarioId(3);
        udao.actualizarUtipoUsuario(uvo);
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vJp.btnPrincipianteQ1Next){
            try {
                rU1 = Integer.parseInt(vJp.txbPrincipianteQ1Res.getText());
                vJp.bproJugadorPrincipiante.setValue(15);
                vJp.jTabbedPane1.setSelectedIndex(1);
            } catch (Exception er) {
                vJp.jopPrincipianteMensaje.showMessageDialog(vJp, "El valor debe ser un entero");
            }
        }    
        if(e.getSource()==vJp.btnPrincipianteQ2Next){
            try {
                rU2 = Integer.parseInt(vJp.txbPrincipianteQ2Res.getText());
                vJp.bproJugadorPrincipiante.setValue(30);
                vJp.jTabbedPane1.setSelectedIndex(2);
            } catch (Exception er) {
                vJp.jopPrincipianteMensaje.showMessageDialog(vJp, "El valor debe ser un entero");
            }
        } 
        if(e.getSource()==vJp.btnPrincipianteQ3Next){
            try {
                rU3 = Integer.parseInt(vJp.txbPrincipianteQ3Res.getText());
                vJp.bproJugadorPrincipiante.setValue(45);
                vJp.jTabbedPane1.setSelectedIndex(3);
            } catch (Exception er) {
                vJp.jopPrincipianteMensaje.showMessageDialog(vJp, "El valor debe ser un entero");
            }
        }
        if(e.getSource()==vJp.btnPrincipianteQ4Next){
            try {
                rU4 = Integer.parseInt(vJp.txbPrincipianteQ4Res.getText());
                vJp.bproJugadorPrincipiante.setValue(60);
                vJp.jTabbedPane1.setSelectedIndex(4);
            } catch (Exception er) {
                vJp.jopPrincipianteMensaje.showMessageDialog(vJp, "El valor debe ser un entero");
            }
        } 
        if(e.getSource()==vJp.btnPrincipianteQ5Next){
            try {
                rU5 = Integer.parseInt(vJp.txbPrincipianteQ5Res.getText());
                vJp.bproJugadorPrincipiante.setValue(75);
                vJp.jTabbedPane1.setSelectedIndex(5);
            } catch (Exception er) {
                vJp.jopPrincipianteMensaje.showMessageDialog(vJp, "El valor debe ser un entero");
            }
        } 
        if(e.getSource()==vJp.btnPrincipianteQ6End){
            try {
                rU6 = Integer.parseInt(vJp.txbPrincipianteQ6Res.getText());
                vJp.bproJugadorPrincipiante.setValue(100);
                calificacion(); //Para hacer la calificacion
            } catch (Exception er) {
                vJp.jopPrincipianteMensaje.showMessageDialog(vJp, "El valor debe ser un entero");
            }
        }
        if(e.getSource()==vJp.btnPrincipianteRepetir){
            if(!calificado) calificacion();
            inicializarF();
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
        guardarIntento();
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
