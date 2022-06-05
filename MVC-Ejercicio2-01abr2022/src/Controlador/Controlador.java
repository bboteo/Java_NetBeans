/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.Model;
import Vista.TextNote;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author bboteo
 */
public class Controlador implements ActionListener{
    //Objetos del modelo mvc
    TextNote note = new TextNote();
    Model mod = new Model();
    private boolean neg = false;
    private Font fuente = new Font("Serief",Font.ITALIC,12);
    private Font fuenteNeg = new Font("Serief",Font.BOLD|Font.ITALIC,12);
    
    //Crear constructor
    public Controlador(TextNote note,Model mod) {
        //Se pasan los objetos al constructor
        this.note = note;
        this.mod = mod;
        
        //Se reservan las acciones del constructor
        this.note.menuOpen.addActionListener(this);
        this.note.menuGuardar.addActionListener(this);
        this.note.menuGuardarNuevo.addActionListener(this);
        this.note.btnMay.addActionListener(this);
        this.note.btnMin.addActionListener(this);
        this.note.btnBold.addActionListener(this);
    }
    
    //Intercambio de informacion entre los paquetes de MVC
    public void abrir(){
        
        //0 = Cuando se selecciona Abrir
        if (note.FileCho.showOpenDialog(null) == 0){
            File archivo = note.FileCho.getSelectedFile();
            
            //Enviar al modelo
            this.mod.setPath(archivo.getAbsolutePath()); //Enviar ruta absoluta
            this.mod.setTexto(this.note.textArea.getText()); //Enviar el texto del TextArea
            
            //Enviar a la vista
            this.note.textArea.setText(this.mod.AbrirTxt());
                        
        }
    }
    
    public void guardar(){     
        //Estamos Guardado Archivo
        if (note.FileCho.showSaveDialog(null) == 0){
            File archivo = note.FileCho.getSelectedFile();
            this.mod.setPath(archivo.getAbsolutePath()+".txt"); //Envia ruta absoluta
            this.mod.setTexto(this.note.textArea.getText()); //Envia el Texto del TextArea
            
            //Enviar al modelo
            this.mod.GuardarTxt();
            
            //Enviar a la vista
            //this.note.saveOk.
        }
    }
    
    public void guardarNuevo(){
        //Estamos Guardado Archivo
        if (note.FileCho.showSaveDialog(null) == 0){
            File archivo = note.FileCho.getSelectedFile();
            this.mod.setPath(archivo.getAbsolutePath()+".txt"); //Envia ruta absoluta
            this.mod.setTexto(this.note.textAreaMayMin.getText()); //Envia el Texto del TextArea
            
            //Enviar al modelo
            this.mod.GuardarTxt();
            
            //Enviar a la vista
            //this.note.saveOk.
        }     
    }
    
    public void mayusculas(){
        //Enviar texto al modelo
        this.mod.setTexto(this.note.textArea.getText());
        
        //Enviar texto en MAYUSCULAS a la vista
        this.note.textAreaMayMin.setText(this.mod.Mayuscula());
        
    }
    
    public void minusculas(){
        //Enviar texto al modelo
        this.mod.setTexto(this.note.textArea.getText());
        
        //Enviar texto en MINUSCULAS a la vista
        this.note.textAreaMayMin.setText(this.mod.Minuscula());
    }
    
    public void bold(){
        System.out.println("Pasando a Negrilla");
        //Font fuente;
        if (!neg){
            this.note.textAreaMayMin.setFont(fuenteNeg);
            this.note.textAreaMayMin.setText(this.note.textArea.getText());
            neg = true;
        }
        else{
            this.note.textAreaMayMin.setFont(fuente);
            this.note.textAreaMayMin.setText(this.note.textArea.getText());
            neg = false;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (e.getSource() == note.menuOpen){
            this.abrir();
        }
        if (e.getSource() == note.menuGuardar){
            this.guardar();
        }
        if (e.getSource() == note.menuGuardarNuevo){
            this.guardarNuevo();
        }
        if (e.getSource()== note.btnMay){
            this.mayusculas();
        }
        if (e.getSource() == note.btnMin){
            this.minusculas();
        }
        if (e.getSource() == note.btnBold){
            this.bold();
        }
    }
    
    
    
    
}
