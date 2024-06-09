/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Conexion.*;
import Entidades.*;

import Vistas.JFSolBus;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JFrame;

public class JavaApplication92 {

    public static void main(String[] args) {
        JFSolBus solBus = new JFSolBus();
        solBus.setExtendedState(JFrame.MAXIMIZED_BOTH); //aparece la pantalla maximizada
        solBus.setVisible(true);
        
    }
}
