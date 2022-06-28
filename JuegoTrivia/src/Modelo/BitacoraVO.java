
package Modelo;

import java.util.Date;

public class BitacoraVO {
    private int id;
    private String dateInicio;
    private String dateFinal;
    private int numeroIntento;
    private int punteo;
    private int fkUsuarioId;
    private int fkTipoUsuarioId;

    public BitacoraVO() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateInicio(String dateInicio) {
        this.dateInicio = dateInicio;
    }

    public void setDateFinal(String dateFinal) {
        this.dateFinal = dateFinal;
    }

    public void setNumeroIntento(int numeroIntento) {
        this.numeroIntento = numeroIntento;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public void setFkUsuarioId(int fkUsuarioId) {
        this.fkUsuarioId = fkUsuarioId;
    }

    public void setFkTipoUsuarioId(int fkTipoUsuarioId) {
        this.fkTipoUsuarioId = fkTipoUsuarioId;
    }

    public int getId() {
        return id;
    }

    public String getDateInicio() {
        return dateInicio;
    }

    public String getDateFinal() {
        return dateFinal;
    }

    public int getNumeroIntento() {
        return numeroIntento;
    }

    public int getPunteo() {
        return punteo;
    }

    public int getFkUsuarioId() {
        return fkUsuarioId;
    }

    public int getFkTipoUsuarioId() {
        return fkTipoUsuarioId;
    }
    
}
