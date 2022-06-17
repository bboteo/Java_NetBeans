
package Modelo;

import java.util.ArrayList;

public interface TablaBitacora {
    public boolean insertarB (BitacoraVO b);
    public ArrayList<BitacoraVO> consultarB();
    public boolean eliminarB (BitacoraVO b);
    public boolean actualizarB (BitacoraVO b);
    
}
