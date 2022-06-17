
package Modelo;

import java.util.ArrayList;

public class UsuarioDAO implements TablaUsuario{

    @Override
    public boolean insertarU(UsuarioVO u) {
        
        return false;
    }

    @Override
    public ArrayList<UsuarioVO> consultarU() {
        ArrayList<UsuarioVO> info = new ArrayList<>();
        
        return info;
    }

    @Override
    public boolean eliminarU(UsuarioVO u) {
        return false;
    }

    @Override
    public boolean actualizarU(UsuarioVO u) {
        return false;
    }
    
}
