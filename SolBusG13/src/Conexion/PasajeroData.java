/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Entidades.Pasajeros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 54265
 */
public class PasajeroData {
    
    private Connection con = null;
    
    public PasajeroData(){
        con = ConexionDB.getConexion(); 
    }
    
    public void guardarPasajero(Pasajeros pasajero){
        String sql = "insert into pasajeros (nombre, apellido, dni, correo, telefono, estado)"
                + "values (?, ?, ? , ?, ?, true)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
        ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                pasajero.setIdPasajero(rs.getInt("id_pasajero")); 
                JOptionPane.showMessageDialog(null, "Pasajero añadido con exito.");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros"+ ex.getMessage());
        }
    }
    
    public Pasajeros bucarPasajero(int dni){
        Pasajeros pasajero = null; 
        String sql = "SELECT nombre, apellido, dni, correo, telefono FROM pasajeros WHERE dni = ? AND estado = 1"; 
        PreparedStatement ps = null; 
        try{ 
            ps = con.prepareStatement(sql); 
            ps.setInt(1,dni ); 
            ResultSet rs = ps.executeQuery(); 

            if(rs.next()){ 
                pasajero = new Pasajeros(); 
                pasajero.setIdPasajero(rs.getInt("id_pasajero")); 
                pasajero.setNombre(rs.getString("nombre")); 
                pasajero.setApellido(rs.getString("apellido")); 
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajero.setEstado(true);
            }else{ 
                JOptionPane.showMessageDialog(null, "No se encuentra el pasajero en la Base de Datos"); 
            }
            ps.close(); 
        }catch(SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros "+ ex.getMessage());
        } 

        return pasajero; 
    } 
    
    public void modificarPasajero(Pasajeros pasajero){
        String sql = "update pasajeros set nombre = ?, apellido = ?, dni = ?, correo = ?, telefono = ? WHERE id_pasajero = ?"; 
        PreparedStatement ps = null; 

        try{ 
            ps = con.prepareStatement(sql); 
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setInt(6, pasajero.getIdPasajero());
            
            int exito = ps.executeUpdate(); 

            if(exito == 1){ 
                JOptionPane.showMessageDialog(null, "Pasajero modificado Exitosamente."); 
            }else{ 
            JOptionPane.showMessageDialog(null, "El pasajero no se encuentra activo en la Base de Datos"); 
            } 

        }catch(SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros"+ ex.getMessage()); 
        }
    }
    
    public void eliminarPasajero(int idPasajero){
        try { 
            String sql = "update pasajeros set estado = 0 WHERE id_pasajero = ? "; 
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, idPasajero); 
            int fila=ps.executeUpdate(); 

            if(fila==1){ 
                JOptionPane.showMessageDialog(null, " Se ha eliminado al pasajero de la Base de Datos."); 
            } 
            ps.close(); 
            }catch(SQLException e){ 
                JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Pasajeros"); 
            } 
    }
    
}
