/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author bboteo
 */
public class LibroVO {
    private int id;
    private String nombre;
    private String saga;
    private int numeroLibro;
    private int edicion;
    private int paginas;
    private String fechaPublicacion;
    private String fechaModificacion;
    private int autorIdFk;

    public LibroVO() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSaga() {
        return saga;
    }

    public int getNumeroLibro() {
        return numeroLibro;
    }

    public int getEdicion() {
        return edicion;
    }

    public int getPaginas() {
        return paginas;
    }
    
    

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public int getAutorIdFk() {
        return autorIdFk;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }

    public void setNumeroLibro(int numeroLibro) {
        this.numeroLibro = numeroLibro;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public void setAutorIdFk(int autorIdFk) {
        this.autorIdFk = autorIdFk;
    }
    
    
    
}
