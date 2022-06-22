
package juegotrivia;

import Controlador.ControladorAdministrador;
import Controlador.ControladorLogin;
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
import Vista.FrmJugadorAvanzado;
import Vista.FrmJugadorIntermedio;
import Vista.FrmJugadorPrincipiante;
import Vista.FrmLogin;

public class JuegoTrivia {

    public static void main(String[] args) {
        //Vista
        FrmLogin fLo = new FrmLogin();
        FrmAdministrador fAd = new FrmAdministrador();
        FrmJugadorPrincipiante fJp = new FrmJugadorPrincipiante();
        FrmJugadorIntermedio fJi = new FrmJugadorIntermedio();
        FrmJugadorAvanzado fJa = new FrmJugadorAvanzado();
        
        //Modelo
        BitacoraDAO bdao = new BitacoraDAO();
        BitacoraVO dvo = new BitacoraVO();
        EstadoDAO edao = new EstadoDAO();
        EstadoVO evo = new EstadoVO();
        PunteoDAO pdao = new PunteoDAO();
        PunteoVO pvo = new PunteoVO();
        TipoUsuarioDAO tdao = new TipoUsuarioDAO();
        TipoUsuarioVO tvo = new TipoUsuarioVO();
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioVO uvo = new UsuarioVO();
        UsuarioCVO ucvo = new UsuarioCVO();
        
        //controlador
        ControladorLogin cLo = new ControladorLogin(fLo, fAd, fJp, fJi, fJa, udao, uvo);
        ControladorAdministrador cAd = new ControladorAdministrador(fAd, udao, uvo, ucvo, tdao, tvo, pdao, pvo, edao, evo, bdao, dvo);
        
        //Iniciar la aplicacion
        fLo.setVisible(true);
        fLo.setLocationRelativeTo(null);
        fLo.setResizable(false);
        
    }
    
}
