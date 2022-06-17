
package Modelo;

import java.util.ArrayList;

public interface TablaEstado {
    public boolean insertarE(EstadoVO e);
    public ArrayList<EstadoVO> consultarE();
    public boolean eliminarE(EstadoVO e);
    public boolean actualizarE(EstadoVO e);
}
