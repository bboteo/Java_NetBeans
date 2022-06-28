
package Modelo;

import java.util.ArrayList;

public interface TablaUsuario {
    public boolean insertarU(UsuarioVO u);
    public ArrayList<UsuarioVO> consultarU();
    public boolean eliminarU(UsuarioVO u);
    public boolean actualizarU(UsuarioVO u);
    
    //Consultas Especificas
    public boolean validarU(UsuarioVO u);
    public boolean validarUc(UsuarioVO u);
    public ArrayList<UsuarioVO> consultarUexacto(UsuarioVO u);
    public boolean actualizarUtipoUsuario (UsuarioVO u);
    
    //Consultas JOIN
    public ArrayList<UsuarioCVO> consultarUjoin(UsuarioVO u, EstadoVO e, TipoUsuarioVO tu, PunteoVO p);
    
}
