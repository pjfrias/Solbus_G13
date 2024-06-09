
package Conexion;

import Entidades.Horario;
import Entidades.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class HorarioData {
    
     private Connection con;

    public HorarioData() {
        this.con = ConexionDB.getConexion();
    }    

    public void guardarHorario(Horario horas) {
        String sql = "INSERT INTO horarios(id_ruta, hora_salida, hora_llegada, estado) "
                + "VALUES (?, ?, ?,1)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, horas.getRuta().getIdRuta());
            ps.setTime(2, java.sql.Time.valueOf(horas.getSalida()));
            ps.setTime(3, java.sql.Time.valueOf(horas.getLlegada()));

            int registros = ps.executeUpdate(); 
            ResultSet rs = ps.getGeneratedKeys(); 

            if (registros == 1) { 
                rs.next();
                JOptionPane.showMessageDialog(null, "Se ha guardado el horario de " + horas.getRuta().getOrigen() + " a " + horas.getRuta().getDestino());
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla horarios" + ex.getMessage());           
        }
    }
    
    public void editarHorarioId(Horario horas){
        try{
            String sql = "update horarios set hora_salida = ?,hora_llegada = ? where id_horario = ? ";                
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setTime(1, java.sql.Time.valueOf(horas.getSalida()));
            ps.setTime(2, java.sql.Time.valueOf(horas.getLlegada()));  
            ps.setInt(3, horas.getIdHorario());
            int fila = ps.executeUpdate(); 

            if(fila != 0 ){ 
                JOptionPane.showMessageDialog(null, "Se actualizo la hora."); 
            } 
            ps.close(); 
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla hora");
        }
    }     
    
    public void borrarHorarioPorId(Horario horas){
         try{
            String sql = "update rutas set estado = 0 where id_ruta = ? ";                
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setInt(1, horas.getIdHorario());            
            int fila = ps.executeUpdate(); 

            if(fila != 0 ){ 
                JOptionPane.showMessageDialog(null, "Se eliminó el horario."); 
            } 
            ps.close(); 
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla horario");
        }
    }  
    
    public void buscarHorarioPorId(Horario horas){
         try{
            String sql = "select id_horario,ohora_salida, hora_llegada from horarios where estado = 1 and id_ruta = ? ";                
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setInt(1, horas.getIdHorario());            
            int fila = ps.executeUpdate(); 

            if(fila != 0 ){ 
                JOptionPane.showMessageDialog(null, "Se muestra la hora."); 
            } 
            ps.close(); 
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla horarios");
        }
        
    }
    
}
