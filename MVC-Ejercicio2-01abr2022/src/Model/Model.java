/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author bboteo
 */
public class Model {
    
    private String texto;
    private String path;
    
    //Constructor basico
    public Model() {
    }
    
    //Acceso a la informacion

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    
    //Logica del negocio o lo que se pide
    public void GuardarTxt(){
        FileWriter fw;
        PrintWriter pw;
          
        try{
            fw = new FileWriter(this.path);
            pw = new PrintWriter(fw);
            pw.println(this.texto);
            pw.close();
        }catch (Exception e){
            System.err.println("El archivo no pudo guardarse");
        }
    }
    
    public String AbrirTxt(){
        String cadena = "";     
        try{
            FileReader fr = new FileReader(this.path);
            int valor = fr.read();
            while (valor != -1){
                cadena = cadena + (char) valor;
                valor = fr.read();   
            }    
        }catch (Exception e){
            System.err.println("Es archivo no pudo abrirse");
        }
        return cadena;
    }
    
    public String Mayuscula(){
        String may;
        may = texto;
        return may.toUpperCase();
    }
    
    public String Minuscula(){
        String min;
        min = texto;
        return min.toLowerCase();
    }
    
    public String bold(){
        String bold;
        bold = texto;
        return bold;
    }
}
