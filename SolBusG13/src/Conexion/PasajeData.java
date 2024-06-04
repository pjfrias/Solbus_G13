package Conexion;

import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;

public class PasajeData{
    private Connection con;
    
    public PasajeData(){
        con = ConexionDB.getConexion();      
    }
    
    //Crear, Leer, Modificar, Eliminar
    //Guardar, Buscar, Modificar, Eliminar
    
    public void guardarPasaje(Pasaje pasaje){
        String sql = "INSERT INTO pasajes (id_pasajero, id_colectivo, id_ruta, fecha_viaje, hora_viaje, asiento, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
            //ps.setInt(2, pasaje.getColectivo());
            //ps.setInt(3, pasaje.getRutas());
            ps.setDate(4, Date.valueOf(pasaje.getFechaViaje()));
            ps.setTime(5, Time.valueOf(pasaje.getHoraViaje()));
            ps.setInt(6, pasaje.getAsiento());
            ps.setDouble(7, pasaje.getPrecio());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                //System.out.println(rs.findColumn("idAlumno")+"");
                pasaje.setIdPasaje(rs.getInt("id_pasaje")); 
                JOptionPane.showMessageDialog(null, "Pasaje cargado con exito.");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajes"+ ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}
