
package Modelo;

public class UsuarioCVO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String usuario;
    private String contrasena;
    private String Estado;
    private String TipoUsuario;
    private int Punteo;

    public UsuarioCVO() {
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

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public void setPunteo(int Punteo) {
        this.Punteo = Punteo;
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

    public String getEstado() {
        return Estado;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public int getPunteo() {
        return Punteo;
    }

    
}
