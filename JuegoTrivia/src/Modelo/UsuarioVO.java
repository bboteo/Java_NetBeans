
package Modelo;

public class UsuarioVO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String usuario;
    private String contrasena;
    private int fkEstadoId;
    private int fkTipoUsuarioId;
    private int fkPunteoId;

    public UsuarioVO() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setFkEstadoId(int fkEstadoId) {
        this.fkEstadoId = fkEstadoId;
    }

    public void setFkTipoUsuarioId(int fkTipoUsuarioId) {
        this.fkTipoUsuarioId = fkTipoUsuarioId;
    }

    public void setFkPunteoId(int fkPunteoId) {
        this.fkPunteoId = fkPunteoId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getFkEstadoId() {
        return fkEstadoId;
    }

    public int getFkTipoUsuarioId() {
        return fkTipoUsuarioId;
    }

    public int getFkPunteoId() {
        return fkPunteoId;
    }
    
}
