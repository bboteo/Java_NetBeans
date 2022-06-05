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

    private double n1;
    private double n2;
    
    public ModeloLogico() {
    }

    //ACCESO A LA INFORMACION
    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }
    
    //LOGICA DEL NEGOCIO
    public int suma(){
        int s;
        s = (int) (this.n1 + this.n2);
        return s;
    }
    
    public int resta(){
        int r;
        r = (int) (this.n1 - this.n2);
        return r;
    }
    
    public double multiplicacion(){
        double r;
        r = this.n1 * this.n2;
        return r;
    }
    
    public double division(){
        double r;
        r = this.n1 / this.n2;
        return r;
    }
}
