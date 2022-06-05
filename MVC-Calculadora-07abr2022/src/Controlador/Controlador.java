/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Calculadora;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author bboteo
 */
public class Controlador implements ActionListener{
    Vista vis = new Vista();
    Calculadora cal = new Calculadora();    
    //Constructor con los objetos
    public Controlador(Vista vis, Calculadora cal) {
        //Inicializar los objetos
        this.vis = vis;
        this.cal = cal;
        
        //Alinear los paneles
        this.vis.txtPanelOperacion.setHorizontalAlignment(4);
        this.vis.txtResult.setHorizontalAlignment(4);
        
        //Activar los click en los botones
        //Digitos
        this.vis.btn0.addActionListener(this);
        this.vis.btn1.addActionListener(this);
        this.vis.btn2.addActionListener(this);
        this.vis.btn3.addActionListener(this);
        this.vis.btn4.addActionListener(this);
        this.vis.btn5.addActionListener(this);
        this.vis.btn6.addActionListener(this);
        this.vis.btn7.addActionListener(this);
        this.vis.btn8.addActionListener(this);
        this.vis.btn9.addActionListener(this);
        this.vis.btnPunto.addActionListener(this);
        //Operaciones
        this.vis.btnSuma.addActionListener(this);
        this.vis.btnResta.addActionListener(this);
        this.vis.btnMulti.addActionListener(this);
        this.vis.btnDiv.addActionListener(this);
        this.vis.btnMod.addActionListener(this);
        this.vis.btnPotencia.addActionListener(this);
        //Operaciones Especiales
        this.vis.jcbAvanzado.addActionListener(this);
        this.vis.btnIgual.addActionListener(this);
        this.vis.btnSigno.addActionListener(this);
        //Borrado
        this.vis.btnBorrar.addActionListener(this);
        this.vis.btnClearDato.addActionListener(this);
        this.vis.btnClearAll.addActionListener(this);
        //Guardar archivos
        this.vis.fileGuardar.addActionListener(this);
    }    
    //Para formar los numeros num1 y num2
    public void numero(String digito){
        String digitoActual ="";        
        //MANDAR Y RECIBIR INFORMACION DEL MODELO
        this.cal.setDigito(digito);
        digitoActual = this.cal.agregarDigito();       
        //MOSTRAR EN LA VISTA
        this.vis.txtResult.setText(digitoActual);       
    }    
    public void borrarDigito(){
        String digitoActual = "";
        digitoActual = this.cal.quitarDigito();        
        //MOSTRAR EN LA VISTA
        this.vis.txtResult.setText(digitoActual);
    }    
    public void borrarDato(){
        String digitoActual;
        digitoActual = this.cal.borrarDato();
        
        //MOSTRAR EN LA VISTA
        this.vis.txtResult.setText(digitoActual);
    }    
    public void borrarAll(){
        this.cal.borrarAll();
        this.vis.txtResult.setText("0");
        this.vis.txtPanelOperacion.setText("0");   
    }
    //Operacion 
    public void suma(){
        this.cal.setOperacion(" + ");
        this.cal.numero1();
        mostrarNumero();
    }    
    public void resta(){
        this.cal.setOperacion(" - ");
        this.cal.numero1();
        mostrarNumero();
    }    
    public void multiplicacion(){
        this.cal.setOperacion(" * ");
        this.cal.numero1();
        mostrarNumero();
    }    
    public void division(){
        this.cal.setOperacion(" / ");
        this.cal.numero1();
        mostrarNumero();
    }    
    public void modulo(){
        this.cal.setOperacion(" Mod ");
        this.cal.numero1();
        mostrarNumero();
    }    
    public void potencia(){
        this.cal.setOperacion(" Pot ");
        this.cal.numero1();
        mostrarNumero();
    }    
    public void avanzado(){
        //Unicamente utiliza un operando
        this.cal.setOperacion(this.vis.jcbAvanzado.getSelectedItem().toString());
        this.cal.numero1();                 
        switch(this.cal.getOperacion()){
            case " Abs ":
                mostrarResultadoAvanzado(this.cal.absoluto());
                break;
            case " Red ":
                mostrarResultadoAvanzado(this.cal.redondeo());
                break;
            case " Sen ":
                mostrarResultadoAvanzado(this.cal.seno());
                break;
            case " Cos ":
                mostrarResultadoAvanzado(this.cal.coseno());
                break;
            case " Tan ":
                mostrarResultadoAvanzado(this.cal.tangente());
                break;
        }
    }    
    public void resultado(){
        this.cal.numero2();        
        switch (this.cal.getOperacion()){
            case " + ":
                mostrarResultado(this.cal.suma());
                break;
            case " - ":
                mostrarResultado(this.cal.resta());
                break;
            case " * ":
                mostrarResultado(this.cal.multiplicacion());
                break;
            case " / ":
                mostrarResultado(this.cal.division());
                break;
            case " Mod ":
                mostrarResultado(this.cal.modulo());
                break;
            case " Pot ":
                mostrarResultado(this.cal.potencia());
                break;
        }    
    }
    public void signo(){
        this.vis.txtResult.setText(this.cal.signo()); 
    }
    public void guardar(){
        if (vis.fileChooser.showSaveDialog(null)==0){
            File archivo = vis.fileChooser.getSelectedFile();
            this.cal.setPath(archivo.getAbsolutePath()+".txt");
            this.cal.setText(this.vis.txtHistorial.getText());
            this.cal.guardar();
        }
    }
    //Funciones locales
    private void mostrarNumero(){
        this.vis.txtResult.setText("0");
        this.vis.txtPanelOperacion.setText(this.cal.mostrarNumero1()+this.cal.getOperacion());
    }
    private void mostrarResultado(Double operacion){
        //Mostrar resultado en el panel
        this.vis.txtPanelOperacion.setText(this.cal.mostrarNumero1()+
                this.cal.getOperacion()+
                this.cal.mostrarNumero2()+
                "="+
                operacion);
        this.vis.txtResult.setText(operacion.toString());
        this.vis.txtHistorial.setText(this.cal.historial());
    }
    private void mostrarResultadoAvanzado(Double operacion){
        //Mostrar resultado en el panel
        this.vis.txtPanelOperacion.setText(this.cal.getOperacion()+
                this.cal.mostrarNumero1()+
                "="+
                operacion);
        this.vis.txtResult.setText(operacion.toString());
        this.vis.txtHistorial.setText(this.cal.historialAvanzado());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //Digitos
        if (e.getSource()==vis.btn0)numero("0");
        if (e.getSource()==vis.btn1)numero("1");
        if (e.getSource()==vis.btn2)numero("2");
        if (e.getSource()==vis.btn3)numero("3");
        if (e.getSource()==vis.btn4)numero("4");
        if (e.getSource()==vis.btn5)numero("5");
        if (e.getSource()==vis.btn6)numero("6");
        if (e.getSource()==vis.btn7)numero("7");
        if (e.getSource()==vis.btn8)numero("8");
        if (e.getSource()==vis.btn9)numero("9");
        if (e.getSource()==vis.btnPunto) numero(".");
        //Operaciones
        if (e.getSource()==vis.btnSuma)suma();
        if (e.getSource()==vis.btnResta) resta();
        if (e.getSource()==vis.btnMulti) multiplicacion();
        if (e.getSource()==vis.btnDiv) division();
        if (e.getSource()==vis.btnMod) modulo();
        if (e.getSource()==vis.btnPotencia) potencia();
        //Operaciones Especiales
        if (e.getSource()==vis.jcbAvanzado) avanzado();
        if (e.getSource()==vis.btnIgual)resultado();
        if (e.getSource()==vis.btnSigno) signo();
        //Borrado
        if (e.getSource()==vis.btnBorrar)borrarDigito();
        if (e.getSource()==vis.btnClearDato) borrarDato();
        if (e.getSource()==vis.btnClearAll) borrarAll();
        //Guardar
        if (e.getSource()==vis.fileGuardar)guardar();
    }
}
