/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc.calculadora.pkg07abr2022;

import Controlador.Controlador;
import Modelo.Calculadora;
import Vista.Vista;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author bboteo
 */
public class MVCCalculadora07abr2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // Crear los objetos de MVC
        Vista vis = new Vista();
        Calculadora cal = new Calculadora();
        Controlador cont = new Controlador(vis, cal);
        
        //Mostar ventana principal
        vis.setVisible(true);
        vis.setLocationRelativeTo(null);
        
        //Mostrar la fecha
        LocalDate todayDate = LocalDate.now();             
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = todayDate.format(formatter);
        vis.txtFecha.setHorizontalAlignment(4);
        vis.txtFecha.setText(fecha);

    }
    
}
