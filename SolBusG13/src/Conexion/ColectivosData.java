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
import java.util.ArrayList;
import java.util.List;
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
             // preparamos la ejecucion de la consulta sql
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
            e.printStackTrace();// se usa para imprimir este Throwable junto con otros detalles como el nombre de la clase y el número de línea donde ocurrió la excepción significa su rastreo inverso. Este método imprime un 
                                //seguimiento de pila para este objeto Throwable en el flujo de salida de error estándar. 
         }
       
       
     };
     
     
     //reed
     public Colectivo bucarColectivo(int id){
        Colectivo colectivo = null; 
        String sql = "SELECT marca, modelo, matricula, capacidad FROM colectivos WHERE id_colectivo = ? AND estado = 1"; 
        PreparedStatement ps = null; 
        try{ 
            ps = conexion.prepareStatement(sql); 
            ps.setInt(0,id ); 
            ResultSet rs = ps.executeQuery(); // ==>Ejecuta la instrucción SQL determinada y devuelve un objeto SQLServerResultSet único.

            if(rs.next()){ // Método que mueve el cursor una fila dentro del ResultSet. Inicialmente el cursor se sitúa antes de la primera fila. Cuando el cursor se posiciona después de la última fila el método devuelve false.
                colectivo = new Colectivo(); // creamos un nuevo cole y le seteamos campo por campo.
                colectivo.setId_colectivo(id); 
                colectivo.setMarca(rs.getString("marca")); 
                colectivo.setModelo(rs.getString("modelo")); 
                colectivo.setMatricula(rs.getString("nombre")); 
                colectivo.setCapacidad(rs.getInt("capacidad"));  
                colectivo.setEstado(true);
            }else{ 
                JOptionPane.showMessageDialog(null, "No se encuentra el colectivo"); 
            }
            ps.close(); 
        }catch(SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error al acceder al buscado de colectivo "+ ex.getMessage());
        } 

        return colectivo; 
    } 
     
     
     
    
     
     //update
     
     public void modificarColectivo(Colectivo colectivo){
        String sql = "UPDATE colectivos SET matricula = ? , marca = ?, modelo = ?,capacidad = ?  WHERE id_colectivo = ?"; 
        PreparedStatement ps = null; 

        try{ 
            ps = conexion.prepareStatement(sql); 
            ps.setString(0, colectivo.getMatricula()); 
            ps.setString(2, colectivo.getMarca()); 
            ps.setString(3, colectivo.getModelo()); 
            ps.setInt(5, colectivo.getCapacidad()); 
            
            int update = ps.executeUpdate(); 

            if(update == 1){ 
            JOptionPane.showMessageDialog(null, " Colectivo modificado Exitosamente."); 
            }else{ 
            JOptionPane.showMessageDialog(null, "El colectivo no existe"); 
            } 

        }catch(SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error al acceder al colectivo "+ ex.getMessage()); 
        }
    }
    
     
     
     
     
     //delete
     
     public void eliminarColectivo(int id){
        try { 
            String sql = "UPDATE colectivo SET estado = 0 WHERE id_colectivo = ? "; 
            PreparedStatement ps = conexion.prepareStatement(sql); 
            ps.setInt(1, id); 
            int fila=ps.executeUpdate(); 

            if(fila==1){ 
                JOptionPane.showMessageDialog(null, " Se eliminó colectivo Nro : "+ id); 
            } 
            ps.close(); 
            }catch(SQLException e){ 
                JOptionPane.showMessageDialog(null, " Error al querer eliminar colectivo"); 
            } 
    }
     
    // listar colectivos activos
     public List<Colectivo> listarColectivos(){
        List<Colectivo> coles = new ArrayList<>(); 
        try{ 
            String sql = "SELECT * FROM colectivos WHERE estado = 1 "; 
            PreparedStatement ps = conexion.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery(); 
        while(rs.next()){ 
            Colectivo colectivo = new Colectivo(); 
            colectivo.setMarca(rs.getString("marca")); 
            colectivo.setModelo(rs.getString("modelo")); 
            colectivo.setMatricula(rs.getString("matricula")); 
            colectivo.setCapacidad(rs.getInt("capacidad")); 
            
            coles.add(colectivo); 
        } 
            ps.close(); 
        }catch(SQLException ex){ 
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ex.getMessage()); 
        } 
        return coles; 
    }
     
    
}
