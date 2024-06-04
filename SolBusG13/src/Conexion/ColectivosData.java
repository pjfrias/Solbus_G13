/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Entidades.Colectivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author prueba
 */
public class ColectivosData {
    
    private Connection conexion = null;
    
     public ColectivosData(){
        conexion = ConexionDB.getConexion(); 
    }
     
     // crud
     
     //create
     
     public void guardarColectivo(Colectivo colectivo) throws SQLException{
       String sql="INSERT INTO colectivos(matricula,marca,modelo,capacidad,estado) VALUES(?,?,?,?,?)";
     
     
         try {
             // preparamos la consulta sql
             PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setString(0, colectivo.getMatricula());
              ps.setString(1, colectivo.getMarca());
               ps.setString(2, colectivo.getModelo());
                ps.setInt(3, colectivo.getCapacidad());
                 ps.setBoolean(4, colectivo.isEstado());
                 // usamos update cuando vamos a hacer una modificacion en la base de datos
                 ps.executeUpdate();
             
                 ResultSet rs=ps.getGeneratedKeys();// ---> Recupera cualquier clave generada automáticamente que se cree como resultado de ejecutar este objeto SQLStatement.
                 
                 if(rs.next()){
                 
                 colectivo.setId_colectivo(rs.getInt("id_colectivo"));
                  JOptionPane.showMessageDialog(null, "colectivo aniadido con exito.");
                 
                 }
                 ps.close();
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Error al aniadir un colectivo"+ e.getMessage());
            e.printStackTrace();
         }
       
       
     };
     
     
     //reed
     
     
     
     
     
     //update
     
     
     
     
     
     
     //delete
     
     
     
    
}
