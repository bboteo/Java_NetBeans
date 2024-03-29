/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import Controlador.ControladorActualizar;
import Controlador.ControladorActualizarAutor;
import Controlador.ControladorActualizarLibro;
import Controlador.ControladorEliminar;
import Controlador.ControladorIngresarAutor;
import Controlador.ControladorIngresarLibro;
import Controlador.ControladorMenuPrincipal;
import Controlador.ControladorMostrar;
import Modelo.AutorDAO;
import Modelo.AutorVO;
import Modelo.LibroDAO;
import Modelo.LibroVO;
import Vista.FrmActualizar;
import Vista.FrmActualizarAutor;
import Vista.FrmActualizarLibro;
import Vista.FrmEliminar;
import Vista.FrmIngresarAutor;
import Vista.FrmIngresarLibro;
import Vista.FrmMenu;
import Vista.FrmMostrar;
import Vista.FrmMostrarAutor;
import Vista.FrmMostrarLibros;

/**
 *
 * @author bboteo
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se crean los objetos de las vistas
        FrmMenu fMp = new FrmMenu();
        FrmIngresarAutor fMiAt = new FrmIngresarAutor();
        FrmIngresarLibro fMiLb = new FrmIngresarLibro();
        FrmMostrar fMm = new FrmMostrar();
        FrmMostrarAutor fMmA = new FrmMostrarAutor();
        FrmMostrarLibros fMmL = new FrmMostrarLibros();
        FrmActualizar fMa = new FrmActualizar();
        FrmActualizarAutor fMaAt = new FrmActualizarAutor();
        FrmActualizarLibro fMaLb = new FrmActualizarLibro();
        FrmEliminar fMe = new FrmEliminar();
        
        //Se crean los objetos de los modelos
        AutorVO avo = new AutorVO();
        AutorDAO adao = new AutorDAO();
        LibroVO lvo = new LibroVO();
        LibroDAO ldao = new LibroDAO();
        
        //Se crean los objetos de los controladores
        ControladorMenuPrincipal cMp = new ControladorMenuPrincipal(fMp, fMiAt, fMiLb, fMm, fMa, fMaAt, fMaLb, fMe);
        ControladorIngresarAutor cMiAt = new ControladorIngresarAutor(fMiAt, avo, adao);
        ControladorIngresarLibro cMiLb = new ControladorIngresarLibro(fMiLb, lvo, ldao, avo, adao);
        ControladorMostrar cMm = new ControladorMostrar(fMm, fMmA, fMmL, adao, avo, ldao, lvo);
        ControladorEliminar cMe = new ControladorEliminar(fMe, adao, avo, ldao, lvo);
        ControladorActualizar cMa = new ControladorActualizar(fMa, fMaAt, fMaLb, adao, avo, ldao, lvo);
        ControladorActualizarAutor cMaAt = new ControladorActualizarAutor(fMaAt, adao, avo);
        ControladorActualizarLibro cMaLb = new ControladorActualizarLibro(fMaLb, ldao, lvo, adao, avo);
        
        //Inicalizacion de la primera pantalla
        fMp.setVisible(true);
        fMp.setLocationRelativeTo(null);
        fMp.setResizable(false);
    }
    
}
