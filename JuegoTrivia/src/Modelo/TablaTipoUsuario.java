
package Modelo;

import java.util.ArrayList;

public interface TablaTipoUsuario {
    public boolean insertarTu(TipoUsuarioVO tu);
    public ArrayList<TipoUsuarioVO> consultarTu();
    public boolean eliminarTu(TipoUsuarioVO tu);
    public boolean actualizarTu(TipoUsuarioVO tu);
}
