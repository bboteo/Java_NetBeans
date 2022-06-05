/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 * Debe ser un reflejo de la tabla convertida en variables
 * @author bboteo
 */
public class PaisVO {
    private int idPais;
    private String nombrePais;
    private String capital;
    private long poblacionPais;
    private String fechaIngPais;
    private String fechaActPais;

    public PaisVO() {
    }

    public int getIdPais() {
        return idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getCapital() {
        return capital;
    }

    public long getPoblacionPais() {
        return poblacionPais;
    }

    public String getFechaIngPais() {
        return fechaIngPais;
    }

    public String getFechaActPais() {
        return fechaActPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPoblacionPais(long poblacionPais) {
        this.poblacionPais = poblacionPais;
    }

    public void setFechaIngPais(String fechaIngPais) {
        this.fechaIngPais = fechaIngPais;
    }

    public void setFechaActPais(String fechaActPais) {
        this.fechaActPais = fechaActPais;
    }
    
    
}
