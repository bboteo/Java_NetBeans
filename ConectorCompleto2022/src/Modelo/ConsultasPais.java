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
public interface ConsultasPais {
    public boolean insertar(PaisVO p);
    public ArrayList<PaisVO> consultar();
    public void eliminar(PaisVO p);
}
