
package Modelo;

import java.util.ArrayList;

public interface TablaUsuario {
    public boolean insertarU(UsuarioVO u);
    public ArrayList<UsuarioVO> consultarU();
    public boolean eliminarU(UsuarioVO u);
    public boolean actualizarU(UsuarioVO u);
}
