/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Entidades.*;

public class JavaApplication92 {

    public static void main(String[] args) {
        
        Colectivos uno= new Colectivos();
        Horarios dos  = new Horarios();
        Pasajero tres = new Pasajero();
        Pasaje cuatro = new Pasaje();
        Ruta cinco = new Ruta();
        
        System.out.println(uno);
        System.out.println(dos);
        System.out.println(tres);
        System.out.println(cuatro);
        System.out.println(cinco);
        
        Conexion.ConexionDB.getConexion();
     
    }
    

}
