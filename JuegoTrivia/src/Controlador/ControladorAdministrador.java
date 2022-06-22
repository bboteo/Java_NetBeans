
package Controlador;

import Modelo.BitacoraDAO;
import Modelo.BitacoraVO;
import Modelo.EstadoDAO;
import Modelo.EstadoVO;
import Modelo.PunteoDAO;
import Modelo.PunteoVO;
import Modelo.TipoUsuarioDAO;
import Modelo.TipoUsuarioVO;
import Modelo.UsuarioCVO;
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
    UsuarioCVO ucvo = new UsuarioCVO();
    TipoUsuarioDAO tdao = new TipoUsuarioDAO();
    TipoUsuarioVO tvo = new TipoUsuarioVO();
    PunteoDAO pdao = new PunteoDAO();
    PunteoVO pvo = new PunteoVO();
    EstadoDAO edao = new EstadoDAO();
    EstadoVO evo = new EstadoVO();
    BitacoraDAO bdao = new BitacoraDAO();
    BitacoraVO bvo = new BitacoraVO();
    
    //Variables locales
    private int humanEr = 0;//Para que el jcbox solo seleccione una vez
    private boolean jcbselect = true;//Para que el jcbox ponga la seleccion
    private String tarea = "";

    public ControladorAdministrador(FrmAdministrador vAd, UsuarioDAO udao, UsuarioVO uvo, UsuarioCVO ucvo,
            TipoUsuarioDAO tdao, TipoUsuarioVO tvo, PunteoDAO pdao, PunteoVO pvo,
            EstadoDAO edao, EstadoVO evo, BitacoraDAO bdao, BitacoraVO bvo) {
        
        this.vAd = vAd;
        this.udao = udao;
        this.uvo = uvo;
        this.ucvo = ucvo;
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
        vAd.jpnAdminAvanzado.setVisible(false);
        vAd.jcbAdminEstado.setVisible(false);
        vAd.btnAdminGuardar.setVisible(false);
        vAd.btnAdminReporte.setVisible(false);
        vAd.tblAdminMostrar.setVisible(false);
        vAd.jpnAdminActualizar.setVisible(false);
        vAd.jlbAdminModificar.setVisible(false);
                
        //Desactivar los txb hasta que se quiera modificar
        vAd.txbAdminNombre.setEditable(false);
        vAd.txbAdminNombre.setText("");
        vAd.txbAdminApellido.setEditable(false);
        vAd.txbAdminApellido.setText("");
        vAd.txbAdminEdad.setEditable(false);
        vAd.txbAdminEdad.setText("");
        vAd.txbAdminUsuario.setEditable(false);
        vAd.txbAdminUsuario.setText("");
        vAd.txbAdminContrasena.setEditable(false);
        vAd.txbAdminContrasena.setText("");
        
        //Agregar las tareas al jcb
        vAd.jcbAdminLista.removeAllItems();
        vAd.jcbAdminLista.addItem("Seleccione su tarea");//item 0
        vAd.jcbAdminLista.addItem("(C) Crar Usuario");//item 1
        vAd.jcbAdminLista.addItem("(R) Mostrar Usuarios");//item 2
        vAd.jcbAdminLista.addItem("(U) Modificar Usuario");//item 3
        vAd.jcbAdminLista.addItem("(D) Borrar Usuario");//item 4
        
        //Agregar items al jcb de estado y nivel
        vAd.jcbAdminEstado.setEnabled(true);
        vAd.jcbAdminTipoJugador.setEnabled(true);
        vAd.jcbAdminEstado.removeAllItems();
        vAd.jcbAdminTipoJugador.removeAllItems();
        vAd.jcbAdminEstado.setEnabled(false);
        vAd.jcbAdminTipoJugador.setEnabled(false);
                
    }
    
    private void ingresarU(){
        inicializarF();
        //vAd.jcbAdminLista.setSelectedIndex(1);
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
        
        //Validar que todos los datos esten completos solo para usuarios nuevos
        if(vAd.txbAdminNombre.getText().isEmpty() || 
                vAd.txbAdminApellido.getText().isEmpty() || 
                vAd.txbAdminContrasena.getText().isEmpty() || 
                vAd.txbAdminUsuario.getText().isEmpty() ||
                vAd.txbAdminEdad.getText().isEmpty()){
            
            vAd.jopAdminMensaje.showMessageDialog(vAd, "Complete todos los datos para "+tarea);
            
            return false;
        }            
        
        //Tomar la informacion de las casillas
        uvo.setNombre(vAd.txbAdminNombre.getText().toString());
        uvo.setApellido(vAd.txbAdminApellido.getText().toString());
        uvo.setContrasena(vAd.txbAdminContrasena.getText().toString());
        uvo.setUsuario(vAd.txbAdminUsuario.getText().toString());
        uvo.setEdad(Integer.valueOf(vAd.txbAdminEdad.getText()));
        uvo.setFkEstadoId(vAd.jcbAdminEstado.getSelectedIndex()+1);
        uvo.setFkTipoUsuarioId(vAd.jcbAdminTipoJugador.getSelectedIndex()+1);
        
        //Validar que el usuario sea unico para usuarios nuevos
        if(udao.validarU(uvo) && tarea.equals("guardar")){
            vAd.jopAdminMensaje.showMessageDialog(vAd, "El usuario ya existe");
            return false;
        }else{
            //Vamos a la base de datos
            if(tarea.equals("guardar")){
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
            if(tarea.equals("actualizar")){
                uvo.setFkEstadoId(vAd.jcbAdminEstado.getSelectedIndex()+1);
                uvo.setFkTipoUsuarioId(vAd.jcbAdminTipoJugador.getSelectedIndex()+1);
                udao.actualizarU(uvo);
                tarea = "mostrar";
            }
            if(tarea.equals("eliminar")){
                pvo.setId(uvo.getFkPunteoId());
                udao.eliminarU(uvo);
                pdao.eliminarP(pvo);
                tarea = "mostrar";
            }
        }       
        return true;
    }
    
    private void mostrarU(){
        inicializarF();
        vAd.tblAdminMostrar.setVisible(true);
        vAd.jpnAdminActualizar.setVisible(true);
        vAd.jpnAdminAvanzado.setVisible(true);
        vAd.jcbAdminEstado.setVisible(true);
        vAd.jlbAdminModificar.setVisible(true);
        
        if(tarea.equals("actualizar")){
            //Habilitar los txb para ingresar los datos
            vAd.txbAdminNombre.setEditable(true);
            vAd.txbAdminApellido.setEditable(true);
            vAd.txbAdminEdad.setEditable(true);
            vAd.txbAdminUsuario.setEditable(true);
            vAd.txbAdminContrasena.setEditable(true);

            vAd.btnAdminGuardar.setText("Actualizar");        
            vAd.btnAdminGuardar.setVisible(true);
            vAd.jcbAdminEstado.setEnabled(true);
            vAd.jcbAdminTipoJugador.setEnabled(true);
                                   
            vAd.btnAdminReporte.setVisible(false);
            
            vAd.jlbAdminModificar.setText("Haga Doble Click sobre el usuario que desea modificar");
        }
        
        if(tarea.equals("eliminar")){
            vAd.jlbAdminModificar.setText("Haga Doble Click sobre el usuario que desea Eliminar");
            vAd.btnAdminGuardar.setText("Eliminar");        
            vAd.btnAdminGuardar.setVisible(true);
        }
        
        if(tarea.equals("mostrar")){
            vAd.jlbAdminModificar.setText("Usuarios de la base de datos");
            vAd.btnAdminReporte.setVisible(true);
        }
        
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
        m.addColumn("Tipo Jugador");
        m.addColumn("Estado"); //Se va mostrar en la lista desplegable
        m.addColumn("Punteo");
               
        for(UsuarioCVO ucvo : udao.consultarUjoin(uvo, evo, tvo, pvo)){
            m.addRow(new Object[] {ucvo.getId(), ucvo.getNombre(), ucvo.getApellido(),
            ucvo.getEdad(),ucvo.getUsuario(),ucvo.getContrasena(), 
            ucvo.getEstado(), ucvo.getTipoUsuario(), ucvo.getPunteo()});
        }
        
        vAd.tblAdminMostrar.setModel(m);
        //Para modificar el ancho de las columnas de la tabla
        TableColumn cCero = vAd.tblAdminMostrar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(20);
        cCero.setMinWidth(20);
        
        TableColumn cTres = vAd.tblAdminMostrar.getColumnModel().getColumn(3);
        cTres.setMaxWidth(50);
        cTres.setMinWidth(50);
        
        TableColumn cSeis = vAd.tblAdminMostrar.getColumnModel().getColumn(6);
        cSeis.setMaxWidth(100);
        cSeis.setMinWidth(100);
        
        humanEr=0;
    }
    
    private void seleccionarId(){
        ArrayList<UsuarioVO> info = new ArrayList<>();
        ArrayList<EstadoVO> info2 = new ArrayList<>();
        ArrayList<TipoUsuarioVO> info3 = new ArrayList<>();
        int r = vAd.tblAdminMostrar.getSelectedRow();
        int idTable = (int) vAd.tblAdminMostrar.getValueAt(r, 0);
        uvo.setId(idTable);
        
        //Para llenar los items del jcbox estado y tipo de jugador
        jcbAvanzado();
        if(tarea.equals("actualizar")){
            vAd.jcbAdminEstado.setEnabled(true);
            vAd.jcbAdminTipoJugador.setEnabled(true);
        }
              
        //Consultar la informacion del usuario
        info = udao.consultarUexacto(uvo);
        
        //Info contiene toda la informacion
        vAd.txbAdminNombre.setText(info.get(0).getNombre());
        vAd.txbAdminApellido.setText(info.get(0).getApellido());
        vAd.txbAdminEdad.setText(String.valueOf(info.get(0).getEdad()));
        vAd.txbAdminUsuario.setText(info.get(0).getUsuario());
        vAd.txbAdminContrasena.setText(info.get(0).getContrasena());
        //
        vAd.jcbAdminEstado.getSelectedItem();
        
        //Informacion de tablas foraneas
        uvo.setFkEstadoId(info.get(0).getFkEstadoId());
        uvo.setFkTipoUsuarioId(info.get(0).getFkTipoUsuarioId());
        uvo.setFkPunteoId(info.get(0).getFkPunteoId());
        
        //Llenar los jcbEstado, jcbTipo
        evo.setId(uvo.getFkEstadoId());
        info2 = edao.consultarEexacto(evo);
        vAd.jcbAdminEstado.setSelectedItem(evo.getNombre());
        
        tvo.setId(uvo.getFkTipoUsuarioId());
        info3 = tdao.consultarTuexacto(tvo);
        vAd.jcbAdminTipoJugador.setSelectedItem(tvo.getNombre());
        
    }
    
    private boolean modificarU(){
        humanEr=0;
        guardarDatos();
        mostrarU();
        return true;
    }
    
    private boolean eliminarU(){
        humanEr=0;
        guardarDatos();
        mostrarU();
        return true;
    }
       
    private void jcbAvanzado(){
        vAd.jcbAdminEstado.setEnabled(true);
        vAd.jcbAdminTipoJugador.setEnabled(true);
        vAd.jcbAdminEstado.removeAllItems();
        vAd.jcbAdminTipoJugador.removeAllItems();
        
        for(EstadoVO evo : edao.consultarE()){
            vAd.jcbAdminEstado.addItem(evo.getNombre());
        }
        
        for(TipoUsuarioVO tvo : tdao.consultarTu()){
            vAd.jcbAdminTipoJugador.addItem(tvo.getNombre());
        }
        vAd.jcbAdminEstado.setEnabled(false);
        vAd.jcbAdminTipoJugador.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vAd.btnAdminGuardar){
           if(tarea.equals("guardar")){
                if(guardarDatos()){
                    vAd.jopAdminMensaje.showMessageDialog(vAd, "El usuario a sido creado exitosamente");
                    inicializarF();
                }else{
                    vAd.jopAdminMensaje.showMessageDialog(vAd, "El usuario no pudo ser creado");
                }
           }
           if(tarea.equals("actualizar")){
               if(modificarU()){
                   vAd.jopAdminMensaje.showMessageDialog(vAd, "Usuario Actualizado con exito");
               }else{
                   vAd.jopAdminMensaje.showMessageDialog(vAd, "El usuario no pudo ser Actualizado");
               }
           }
           if(tarea.equals("eliminar")){
               if(eliminarU()){
                   vAd.jopAdminMensaje.showMessageDialog(vAd, "Usuario eliminado con exito");
               }else{
                   vAd.jopAdminMensaje.showMessageDialog(vAd, "El usuario no pudo ser eliminado");
               }
           }
           
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2){
            seleccionarId();
            //tarea="actualizar";
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
                case 1://Create User
                    humanEr++;
                    if (humanEr==2 && jcbselect) {
                        tarea = "guardar";
                        ingresarU();
                    }
                    break;
                case 2://Read Usuario
                    humanEr++;
                    if (humanEr==2 && jcbselect) {
                        tarea = "mostrar";
                        mostrarU();
                    }
                    break;
                case 3://Update User
                    humanEr++;
                    if (humanEr==2 && jcbselect){
                        tarea = "actualizar";
                        mostrarU();
                    }
                    break;
                case 4://Delete User
                    humanEr++;
                    if (humanEr==2 && jcbselect) {
                        tarea = "eliminar";
                        mostrarU();
                    }
                    break;
                //default:
                }
            } 
    }
}
