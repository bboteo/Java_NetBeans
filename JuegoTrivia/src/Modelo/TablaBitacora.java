
package Modelo;

import java.util.ArrayList;

public interface TablaBitacora {
    public boolean insertarB (BitacoraVO b);
    public ArrayList<BitacoraVO> consultarB();
    public boolean eliminarB (BitacoraVO b);
    public boolean actualizarB (BitacoraVO b);
    
    //Nuevas consultas
    public int consutarBmaxId(UsuarioVO u); //Para consultar la ultima entrada a bitacora X usuario
    public ArrayList<BitacoraVO> consultarBintento(BitacoraVO b);
}
