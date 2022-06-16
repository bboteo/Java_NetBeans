/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

//import com.mysql.jdbc.Statement;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author bboteo
 */
public class Conector {
    //Variables para la conexion
    private String driver = "com.mysql.jdbc.Driver"; //Referencia a las librerias (java data base conector)
    private String host = "localhost";//"192.168.1.201:3306"; //Nombre del host o servidor de base de datos
    private String user = "root";//"bboteo"; //Usuario de la base de datos
    private String pass = "";//"Passw0rd"; //Contrasena del usuario de la base de datos
    private String db = "dbconector"; //Nombre de la base de datos
    private String cadena = ""; //Concatenacion de los anteriores
    
    //Declaracion de objetos para la conexion
    public Connection connection;
    Statement statement;
    
    //Declaracion de metodos para conexion
    public void conectar(){
        this.cadena = "jdbc:mysql://"+this.host+"/"+this.db;
        try {
            Class.forName(this.driver).newInstance();
            this.connection = DriverManager.getConnection(this.cadena,this.user,this.pass);
            
        }catch (Exception e){
            System.err.println("Error [MC]: "+e.getMessage());
        }
    }
    
    //Metodo Desconectar
    public void desconectar(){
        try{
            this.connection.close();
        }catch (Exception e){
            System.err.println("Error [MC]: "+e.getMessage());
        }
    }
    
    //Metodo par querys INSERT, UPDATE, DELETE
    public int consultasMultiples(String query){
        int resultado;
        try{
            this.conectar();
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeUpdate(query);
        }catch (Exception e){
            System.err.println("Error [MC]: "+e.getMessage());
            return 0;
        }
        return resultado;
    }
    
    //Metodo para realizar consultas SELECT
    public ResultSet consultaDatos(String consulta){
        try{
            this.conectar();
            ResultSet resultado = null;
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeQuery(consulta);
            return resultado;
        }catch (Exception e){
           System.err.println("Error [MC]: "+e.getMessage()); 
        }
        return null;
    }
    
}
