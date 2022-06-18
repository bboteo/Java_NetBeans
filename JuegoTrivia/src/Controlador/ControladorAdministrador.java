
package Controlador;

import Modelo.BitacoraDAO;
import Modelo.BitacoraVO;
import Modelo.EstadoDAO;
import Modelo.EstadoVO;
import Modelo.PunteoDAO;
import Modelo.PunteoVO;
import Modelo.TipoUsuarioDAO;
import Modelo.TipoUsuarioVO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import Vista.FrmAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ControladorAdministrador implements ActionListener, MouseListener, WindowListener,
        ItemListener{

    FrmAdministrador vAd = new FrmAdministrador();
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();
    TipoUsuarioDAO tdao = new TipoUsuarioDAO();
    TipoUsuarioVO tvo = new TipoUsuarioVO();
    PunteoDAO pdao = new PunteoDAO();
    PunteoVO pvo = new PunteoVO();
    EstadoDAO edao = new EstadoDAO();
    EstadoVO evo = new EstadoVO();
    BitacoraDAO bdao = new BitacoraDAO();
    BitacoraVO bvo = new BitacoraVO();
    
    //Variables locales
    private int humanEr = 0;
    private String guarAct = "";

    public ControladorAdministrador(FrmAdministrador vAd, UsuarioDAO udao, UsuarioVO uvo,
            TipoUsuarioDAO tdao, TipoUsuarioVO tvo, PunteoDAO pdao, PunteoVO pvo,
            EstadoDAO edao, EstadoVO evo, BitacoraDAO bdao, BitacoraVO bvo) {
        
        this.vAd = vAd;
        this.udao = udao;
        this.uvo = uvo;
        this.tdao = tdao;
        this.tvo = tvo;
        this.pdao = pdao;
        this.pvo = pvo;
        this.edao = edao;
        this.evo = evo;
        this.bdao = bdao;
        this.bvo = bvo;
        
        this.vAd.addWindowListener(this);
        this.vAd.btnAdminGuardar.addActionListener(this);
        this.vAd.btnAdminReporte.addActionListener(this);
        this.vAd.jcbAdminEstado.addActionListener(this);
        this.vAd.jcbAdminLista.addItemListener(this);
        this.vAd.tblAdminMostrar.addMouseListener(this);
        
    }
    
    private void inicializarF(){
        vAd.jcbAdminEstado.setVisible(false);
        vAd.btnAdminGuardar.setVisible(false);
        vAd.btnAdminReporte.setVisible(false);
        vAd.tblAdminMostrar.setVisible(false);
        
        //Desactivar los txb hasta que se quiera modificar
        vAd.txbAdminNombre.setEditable(false);
        vAd.txbAdminApellido.setEditable(false);
        vAd.txbAdminEdad.setEditable(false);
        vAd.txbAdminUsuario.setEditable(false);
        vAd.txbAdminContrasena.setEditable(false);
        
        //Agregar las tareas al jcb
        vAd.jcbAdminLista.removeAllItems();
        vAd.jcbAdminLista.addItem("Seleccione su tarea");
        vAd.jcbAdminLista.addItem("Ingresar Usuario");
        vAd.jcbAdminLista.addItem("Borrar Usuario");
        vAd.jcbAdminLista.addItem("Modificar Usuario");
        vAd.jcbAdminLista.addItem("Mostrar Usuarios");
        
    }
    
    private void ingresarU(){
        inicializarF();
        //Habilitar los txb para ingresar los datos
        vAd.txbAdminNombre.setEditable(true);
        vAd.txbAdminApellido.setEditable(true);
        vAd.txbAdminEdad.setEditable(true);
        vAd.txbAdminUsuario.setEditable(true);
        vAd.txbAdminContrasena.setEditable(true);

        vAd.btnAdminGuardar.setText("Guardar");        
        vAd.btnAdminGuardar.setVisible(true);
                        
        humanEr=0;
    }
    
    private boolean guardarDatos(){
        ArrayList<PunteoVO> punteo = new ArrayList<>();
        
        //Validar que todos los datos esten completos
        if(vAd.txbAdminNombre.getText().isEmpty() || 
                vAd.txbAdminApellido.getText().isEmpty() || 
                vAd.txbAdminContrasena.getText().isEmpty() || 
                vAd.txbAdminUsuario.getText().isEmpty() ||
                vAd.txbAdminEdad.getText().isEmpty()){
            
            vAd.jopAdminMensaje.showMessageDialog(vAd, "Complete todos los datos para registrar");
            
            return false;
        }            
        
        //Tomar la informacion de las casillas
        uvo.setNombre(vAd.txbAdminNombre.getText().toString());
        uvo.setApellido(vAd.txbAdminApellido.getText().toString());
        uvo.setContrasena(vAd.txbAdminContrasena.getText().toString());
        uvo.setUsuario(vAd.txbAdminUsuario.getText().toString());
        uvo.setEdad(Integer.valueOf(vAd.txbAdminEdad.getText()));
        
        //Validar que el usuario sea unico
        if(udao.validarU(uvo) && guarAct=="guardar"){
            vAd.jopAdminMensaje.showMessageDialog(vAd, "El usuario ya existe");
            return false;
        }else{
            //Vamos a la base de datos
            
            if(guarAct=="guardar"){
                //1ro Hay que crear la entrada en la tabla de punteo 
                pvo.setPunteo(0);
                pdao.insertarP(pvo);
                //2do Hay que consultar por el id asignado
                punteo = pdao.consultarPnuevo(pvo);
                uvo.setFkPunteoId(punteo.get(0).getId());//Se asigna la nueva entrada en punteo
                uvo.setFkTipoUsuarioId(2);//Principiante
                uvo.setFkEstadoId(1);//Usuario Activo
                udao.insertarU(uvo);
            }
            if(guarAct=="actualizar"){
                udao.actualizarU(uvo);
            }            
        }       
        return true;
    }
    
    private void mostrarU(){
        inicializarF();
        vAd.tblAdminMostrar.setVisible(true);
        //Modificaciones para la tabla
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre");
        m.addColumn("Apellido");
        m.addColumn("Edad");
        m.addColumn("Usuario");
        m.addColumn("Contrasena");
        
        for(UsuarioVO uvo : udao.consultarU()){
            m.addRow(new Object[] {uvo.getId(), uvo.getNombre(), uvo.getApellido(),
            uvo.getEdad(),uvo.getUsuario(),uvo.getContrasena()});
        }
        
        vAd.tblAdminMostrar.setModel(m);
        //Para modificar el ancho de las columnas de la tabla
        TableColumn cCero = vAd.tblAdminMostrar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        cCero.setMinWidth(75);
        
        humanEr=0;
    }
    
    private void seleccionarId(){
        int r = vAd.tblAdminMostrar.getSelectedRow();
        int idTable = (int) vAd.tblAdminMostrar.getValueAt(r, 0);
        uvo.setId(idTable);
    }
    
    private boolean modificarU(){
        ArrayList<UsuarioVO> info = new ArrayList<>();
        humanEr=0;
        
        //Habilitar los txb para ingresar los datos
        vAd.txbAdminNombre.setEditable(true);
        vAd.txbAdminApellido.setEditable(true);
        vAd.txbAdminEdad.setEditable(true);
        vAd.txbAdminUsuario.setEditable(true);
        vAd.txbAdminContrasena.setEditable(true);

        vAd.btnAdminGuardar.setText("Actualizar");        
        vAd.btnAdminGuardar.setVisible(true);
        
        //Consultar la informacion del usuario
        info = udao.consultarUexacto(uvo);
        
        //Info contiene toda la informacion
        vAd.txbAdminNombre.setText(info.get(0).getNombre());
        vAd.txbAdminApellido.setText(info.get(0).getApellido());
        vAd.txbAdminEdad.setText(String.valueOf(info.get(0).getEdad()));
        vAd.txbAdminUsuario.setText(info.get(0).getUsuario());
        vAd.txbAdminContrasena.setText(info.get(0).getContrasena());
        
        //Pasamos a la base de datos
        uvo.setFkEstadoId(info.get(0).getFkEstadoId());
        uvo.setFkTipoUsuarioId(info.get(0).getFkTipoUsuarioId());
        uvo.setFkPunteoId(info.get(0).getFkPunteoId());
        
        return guardarDatos();
    }
    
    private void eliminarU(){
        inicializarF();
        System.out.println("Eliminando usuarios");
        humanEr=0;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vAd.btnAdminGuardar){
           if(guarAct == "guardar"){
                if(guardarDatos()){
                    vAd.jopAdminMensaje.showMessageDialog(vAd, "El usuario a sido creado exitosamente");
                    inicializarF();
                }else{
                    vAd.jopAdminMensaje.showMessageDialog(vAd, "El usuario no pudo ser creado");
                }
           }
           if(guarAct == "actualizar"){
               if(modificarU()){
                   vAd.jopAdminMensaje.showMessageDialog(vAd, "Usuario Actualizado con exito");
                   inicializarF();
               }else{
                   vAd.jopAdminMensaje.showMessageDialog(vAd, "El usuario no pudo ser Actualizado");
               }
           }
           
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2){
            seleccionarId();
            modificarU();
        }
 
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        //Para capturar el item cambiado
            if(e.getSource()==vAd.jcbAdminLista){
            switch (vAd.jcbAdminLista.getSelectedIndex()) {
                case 1://Ingresar usuario
                    humanEr++;
                    guarAct = "guardar";
                    if (humanEr==2) ingresarU();
                    break;
                case 2://Borrar usuario
                    humanEr++;
                    if (humanEr==2) eliminarU();
                    break;
                case 3://Modificar usuario
                    humanEr++;
                    guarAct = "actualizar";
                    if (humanEr==2)mostrarU(); //Para que muestre la tabla de usuarios
                     //modificarU();
                    break;
                case 4://Mostrar usuarios
                    humanEr++;
                    if (humanEr==2) mostrarU();
                    break;
                //default:
                }
            } 
    }
}
