/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author bboteo
 */
public class ModeloLogico {

    private String palabra;
    
    public ModeloLogico() {
    }
    
    //Acceso a la informacion

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
        
    
    //LOGICA DEL NEGOCIO
    public String Traductor(){
        String ingles;
        
        switch (this.palabra) {
            case "Casa":
                ingles = "House";
                break;
            case "Arbol":
                ingles = "Tree";
                break;
            case "Uno":
                ingles = "One";
                break;
            case "Hola":
                ingles = "Hello";
                break;
            case "Mensaje":
                ingles = "Menssage";
                break;
            case "Texto":
                ingles = "Text";
                break;
            case "Luz":
                ingles = "Light";
                break;
            case "Oscuridad":
                ingles = "Dark";
                break;
            case "Perro":
                ingles = "Dog";
                break;
            case "Manzana":
                ingles = "Apple";
                break;
            default:
                //throw new AssertionError();
                ingles = "Palabra no encontrada";
                break;
        }
              
        return ingles;
    }
    
}
