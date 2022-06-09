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
public interface TablaAutor {
    public boolean insertarA(AutorVO a);
    public ArrayList<AutorVO> consultarA();
    public void eliminarA (AutorVO a);
    public void actualizar (AutorVO a);
}
