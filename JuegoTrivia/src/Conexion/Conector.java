
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {
    //Variables para la conexion
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "localhost";
    private String user = "root";
    private String pass = "";
    private String db = "dbjuego";
    private String cadena = "";
    
    //Declaracion de objetos para la conexion
    public Connection connection;
    Statement statement;
    
    //Metodos para la conexion
    public void conectar(){
        this.cadena="jdbc:mysql://"+this.host+"/"+this.db;
        try {
            Class.forName(this.driver).newInstance();
            this.connection = DriverManager.getConnection(this.cadena,this.user,this.pass);
        } catch (Exception e) {
            System.err.println("Erro [Metodo Conectar]: "+e.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println("Error [Metodo Desconectar]: "+e.getMessage());
        }
    }
    
    //UPDATE, INSERT, DELETE
    public int consultasMultiples(String query){
        int resultado;
        try {
            this.conectar();
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeUpdate(query);
        } catch (Exception e) {
            System.err.println("Error [Metodo ConsultasM]: "+e.getMessage());
            return 0;
        }
        return resultado;
    }
    
    //SELECT
    public ResultSet consultaDatos(String consulta){
        try {
            this.conectar();
            ResultSet resultado = null;
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeQuery(consulta);
            return resultado;
        } catch (Exception e) {
            System.err.println("Error [Metodo ConsultaDatos]: "+e.getMessage());
        }
        return null;
    }
    
}
