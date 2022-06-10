/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author bboteo
 */
public class AutorVO {
    private int id;
    private String nombre1;
    private String nombre2;
    private String nombre3;
    private String apellido1;
    private String apellido2;
    private String alias;
    private String pais;
    private String correo;
    private String fecha_registro;
    private String fecha_modificacion;

    public AutorVO() {
    }

    public int getId() {
        return id;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getAlias() {
        return alias;
    }

    public String getPais() {
        return pais;
    }
   
    public String getCorreo() {
        return correo;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }  
    
}
