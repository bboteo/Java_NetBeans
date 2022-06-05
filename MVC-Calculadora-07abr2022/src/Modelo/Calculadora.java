/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public class Calculadora {  
    //Para Cargar los numeros
    private ArrayList<String> numCapturado = new ArrayList();
    private ArrayList<String> mostrarNum1 = new ArrayList();
    private ArrayList<String> mostrarNum2 = new ArrayList();
    private String digito;    
    //Las variables privadas del metodo
    private Double num1;
    private Double num2;
    private Double resultado;
    private String operacion;  
    private boolean reUsarResultado = false; //Para saber cuando se re utiliza el resultado
    //Para el historial
    private ArrayList<String> historial = new ArrayList<>();
    //Para guardar el archivo
    private String path;
    private String text;    
    //El constructor por defecto
    public Calculadora() {
    }   
    //Acceso a la informacion
    public ArrayList<String> getNumCapturado() {
        return numCapturado;
    }
    public ArrayList<String> getMostrarNum1() {
        return mostrarNum1;
    }
    public void setMostrarNum1(ArrayList<String> mostrarNum1) {
        this.mostrarNum1 = mostrarNum1;
    }
    public ArrayList<String> getMostrarNum2() {
        return mostrarNum2;
    }
    public void setMostrarNum2(ArrayList<String> mostrarNum2) {
        this.mostrarNum2 = mostrarNum2;
    }    
    public void setNumCapturado(ArrayList<String> numCapturado) {
        this.numCapturado = numCapturado;
    }
    public String getDigito() {
        return digito;
    }
    public void setDigito(String digito) {
        this.digito = digito;
    }
    public Double getNum1() {
        return num1;
    }
    public void setNum1(Double num1) {
        this.num1 = num1;
    }
    public Double getNum2() {
        return num2;
    }
    public void setNum2(Double num2) {
        this.num2 = num2;
    }
    public double getResultado() {
        return resultado;
    }
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    public String getOperacion() {
        return operacion;
    }
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    public ArrayList<String> getHistorial() {
        return historial;
    }
    public void setHistorial(ArrayList<String> historial) {
        this.historial = historial;
    }   
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    //**********************Logica del negocio*******************
    //Captura digito
    public String agregarDigito(){
        String a = "";      
        if ((".".equals(this.digito))&(numCapturado.contains("."))){//Para capturar solo un punto
            for (int i = 0 ; i <= numCapturado.size()-1; i++){
                a = a + numCapturado.get(i);
            }
        }else{
            numCapturado.add(this.digito);
            for (int i = 0 ; i <= numCapturado.size()-1; i++){
                a = a + numCapturado.get(i);
            }
        }
        return a;
    }
    //Quitar digito
    public String quitarDigito(){
        String a="";        
        try{
            numCapturado.remove(numCapturado.size()-1);
            for (int i = 0; i <= numCapturado.size()-1; i++){
                a = a + numCapturado.get(i);
            }
        }catch (Exception e){
            a ="0";
        }        
        return a;
    }    
    //Borrar todo el numero
    public String borrarDato(){
        String a;
        try{
            while (!numCapturado.isEmpty())numCapturado.remove(0);
            while (!mostrarNum1.isEmpty())mostrarNum1.remove(0);
            while (!mostrarNum2.isEmpty())mostrarNum2.remove(0);
            a = "0";
        }catch (Exception e){
            a ="0";
        }
        this.reUsarResultado=false;
        return a;
    }    
    public void borrarAll(){
        this.num1 = 0.0;
        this.num2 = 0.0;        
        while (!numCapturado.isEmpty())numCapturado.remove(0);
        while (!mostrarNum1.isEmpty())mostrarNum1.remove(0);
        while (!mostrarNum2.isEmpty())mostrarNum2.remove(0);
        this.reUsarResultado=false;
    }    
    //Crear numero
    public void numero1(){
        if (reUsarResultado){//Para re utilizar el resultado como el numero 1
            this.num1=this.resultado;
            while(!this.mostrarNum1.isEmpty())this.mostrarNum1.remove(0);
            while(!this.mostrarNum2.isEmpty())this.mostrarNum2.remove(0);
            this.mostrarNum1.add(this.num1.toString());
        }
        else{
           //1ro Guardar el array en num1
            String a = "";
            try{
                for (int i = 0 ; i <= numCapturado.size()-1; i++){
                    a = a + numCapturado.get(i);
                    mostrarNum1.add(numCapturado.get(i));
                }
                num1 = Double.parseDouble(a);
            }catch(Exception e){
                num1 = 0.0;
            }             
            //2do Borrar el Array
            try{
                while (!numCapturado.isEmpty()){
                    numCapturado.remove(0);
                }
            }catch (Exception e){            
            }
            this.reUsarResultado=true;
        }
    }    
    public void numero2(){
        //1ro Guardar el array en num2
        String a = "";
        try{
            for (int i = 0 ; i <= numCapturado.size()-1; i++){
                a = a + numCapturado.get(i);
                mostrarNum2.add(numCapturado.get(i));
            }
            num2 = Double.parseDouble(a);
        }catch(Exception e){
            num2 = 0.0;
        }             
        //2do Borrar el Array
        try{
            while (!numCapturado.isEmpty()){
                numCapturado.remove(0);
            }
        }catch (Exception e){
            
        }
    }
    public void borrarArreglo(){
        try{
            while (!numCapturado.isEmpty()){
                numCapturado.remove(0);
            }
        }catch (Exception e){
            System.err.println("El arreglo no pudo borrarse");
        }
    }
    //Para mostrar numeros
    public String mostrarNumero1(){
        String num11="";
        if (this.mostrarNum1.isEmpty())mostrarNum1.add("0");
        for (int i = 0 ; i <= this.getMostrarNum1().size()-1; i++){
            num11 = num11 + this.getMostrarNum1().get(i);
        }        
        return num11;
    }
    public String mostrarNumero2(){
        String num22="";
        if (this.mostrarNum2.isEmpty())mostrarNum2.add("0");
        for (int i = 0 ; i <= this.getMostrarNum2().size()-1; i++){
            num22 = num22 + this.getMostrarNum2().get(i);
        }
        return num22;
    }
    public void mostrarResultado(){
        
    }
    //***************OPERACIONES******************************
    //Suma:
    public Double suma(){
        Double result;
        result = this.num1 + this.num2;
        this.resultado = result;
        return result;
    }
    //Resta:
    public Double resta(){
        Double result;
        result = this.num1 - this.num2;
        this.resultado = result;
        return result;
    }
    //Multiplicacion:
    public Double multiplicacion(){
        Double result;
        result = this.num1 * this.num2;
        this.resultado = result;
        return result;
    }
    //Division:
    public Double division(){
        Double result;
        result = this.num1 / this.num2;
        this.resultado = result;
        return result;
    }
    //Modulo:
    public Double modulo(){
        Double result;
        result = this.num1%this.num2;
        this.resultado = result;
        return result;
    }
    //Potencia:
    public Double potencia(){
        Double result;
        result = Math.pow(this.num1, this.num2);
        this.resultado = result;
        return result;
    }
    //Valor absoluto:
    public Double absoluto(){
        Double result;
        result = Math.abs(this.num1);
        this.resultado = result;
        return result;
    }
    //Redondeo:
    public Double redondeo(){
        Double result;
        result = Math.floor(this.num1);//Debo corregir el redondeo
        this.resultado = result;
        return result;
    }
    //Sen
    public Double seno(){
        Double result;
        result = Math.sin(this.num1);
        this.resultado = result;
        return result;
    }
    //Cos
    public Double coseno(){
        Double result;
        result = Math.cos(this.num1);
        this.resultado = result;
        return result;
    }
    //Tan
    public Double tangente(){
        Double result;
        result = Math.tan(this.num1);
        this.resultado = result;
        return result;
    }
    //Cambio de Signo
    public String signo(){
        String h="";
        if (!this.reUsarResultado){
            if (!"-".equals(this.numCapturado.get(0))){
                this.numCapturado.add(0, "-");
            }
            else{
                this.numCapturado.remove(0);
            }
            //Retornar digito con signo
            for (int i=0; i <= numCapturado.size()-1;i++){
                h = h + numCapturado.get(i);
            } 
        }
        else{
            this.resultado = this.resultado * (-1);
            h = this.resultado.toString();
        }
        return h;
    }
    //HISTORIAL
    public String historial(){
        String h = "";
        historial.add(this.mostrarNumero1()+
                this.operacion+
                this.mostrarNumero2()+
                " = " +
                this.resultado);
        
        for (int i=0; i<= historial.size()-1; i++){
            h = h + "(operacion: " + i + ") >> " + historial.get(i)+"\n";
        }
        return h;
    }
    public String historialAvanzado(){
        String h = "";
        historial.add(this.operacion+
                this.mostrarNumero1()+
                " = "+
                this.resultado);
        
        for (int i=0; i <= historial.size()-1; i++){
            h = h + "(operacion: " + i + ") >> " + historial.get(i)+"\n"; 
        }
        return h;
    }
    //Guardar
    public void guardar(){
        FileWriter fw;
        PrintWriter pw;          
        try{
            fw = new FileWriter(this.path);
            pw = new PrintWriter(fw);
            pw.println(this.text);
            pw.close();
        }catch (Exception e){
            System.err.println("El archivo no pudo guardarse");
        }
    }
    //DE ACA EN MAS SON PRUEBAS----------------------------------   
}
