/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public interface TablaLibro {
    public boolean insertarL (LibroVO l);
    public ArrayList<LibroVO> consultarL();
    public void eliminarL (LibroVO l);
    public void actualizarL (LibroVO l);
    
}
