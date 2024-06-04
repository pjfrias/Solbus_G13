/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Entidades.*;

public class JavaApplication92 {

    public static void main(String[] args) {
        
        Colectivo uno= new Colectivo();
        Horarios dos  = new Horarios();
        Pasajeros tres = new Pasajeros();
        Pasajes cuatro = new Pasajes();
        Rutas cinco = new Rutas();
        
        System.out.println(uno);
        System.out.println(dos);
        System.out.println(tres);
        System.out.println(cuatro);
        System.out.println(cinco);
        
        Conexion.ConexionDB.getConexion();
     
    }
    

}
