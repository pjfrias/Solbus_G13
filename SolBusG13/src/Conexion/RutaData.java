package Conexion;

import Entidades.Horario;
import Entidades.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RutaData {

    private Connection con;

    public RutaData() {
        this.con = ConexionDB.getConexion();
    }

    public void guardarRuta(Horario horas) {
        String sql = "INSERT INTO rutas(origen, destino, duracion_estimada, estado) "
                + "VALUES (?, ?, ?,1)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, horas.getRuta().getOrigen());
            ps.setString(2, horas.getRuta().getOrigen());
            ps.setTime(3, java.sql.Time.valueOf(horas.getRuta().getDuracion()));

            int registros = ps.executeUpdate(); 
            ResultSet rs = ps.getGeneratedKeys(); 

            if (registros == 1) { 
                rs.next();
                JOptionPane.showMessageDialog(null, "Se ha guardado la ruta de " + horas.getRuta().getOrigen() + " a " + horas.getRuta().getDestino());
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla rutas" + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void editarRutaporId(Ruta ruta){
        try{
            String sql = "update rutas set origen = ?,destino = ? where id_ruta = ? ";                
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());  
            ps.setInt(3, ruta.getIdRuta());
            int fila = ps.executeUpdate(); 

            if(fila != 0 ){ 
                JOptionPane.showMessageDialog(null, "Se actualizo la ruta."); 
            } 
            ps.close(); 
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
    }     
    
    public void borrarRutaPorId(Ruta ruta){
         try{
            String sql = "update rutas set estado = 0 where id_ruta = ? ";                
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setInt(1, ruta.getIdRuta());            
            int fila = ps.executeUpdate(); 

            if(fila != 0 ){ 
                JOptionPane.showMessageDialog(null, "Se eliminó la ruta."); 
            } 
            ps.close(); 
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
    }   
    
    public void buscarRutasBase(Ruta ruta){
        try{
            String sql = "select id_ruta,origen,destino,duracion_estimada from rutas where estado = 1 and id_ruta = ? ";                
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setInt(1, ruta.getIdRuta());            
            int fila = ps.executeUpdate(); 

            if(fila != 0 ){ 
                JOptionPane.showMessageDialog(null, "Se muestra la ruta."); 
            } 
            ps.close(); 
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
    }
    public List buscarRutas(){
        
        List<Horario> horarios = new ArrayList<>();
        try{
            String sql = "select id_ruta,origen,destino,duracion_estimada from rutas where estado = 1 and id_ruta = ? ";                
            PreparedStatement ps = con.prepareStatement(sql);  
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ruta ruta = new Ruta();
                Horario hora=new Horario();
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracion(rs.);
                alumno.setFechaNac(rs.getDate("fecha").toLocalDate());
                alumno.setNombre(rs.getString("nombre_alumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setDni(rs.getInt("dni"));
                materia.setNombre(rs.getString("nom_materia"));
                materia.setIdMateria(rs.getInt("id_materia"));
                materia.setAnioMateria(rs.getInt("anio"));
                inscripcion.setNota(rs.getDouble("nota"));
            inscripcion.setAlumno(alumno);
            inscripcion.setMateria(materia);
            
            inscripciones.add(inscripcion); 
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
        return horarios;
    }
    public List buscarRutasOrigen(String origen){
        List<Horario> horarios = new ArrayList<>();
        try{
            String sql = "select id_ruta,origen,destino,duracion_estimada from rutas where estado = 1 and id_ruta = ? ";                
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setInt(1, ruta.getIdRuta());            
            int fila = ps.executeUpdate(); 

            if(fila != 0 ){ 
                JOptionPane.showMessageDialog(null, "Se muestra la ruta."); 
            } 
            ps.close(); 
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
        return horarios;
    }
    public List buscarRutasDestino(String destino){
        List<Horario> horarios = new ArrayList<>();
        try{
            String sql = "select id_ruta,origen,destino,duracion_estimada from rutas where estado = 1 and id_ruta = ? ";                
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setInt(1, ruta.getIdRuta());            
            int fila = ps.executeUpdate(); 

            if(fila != 0 ){ 
                JOptionPane.showMessageDialog(null, "Se muestra la ruta."); 
            } 
            ps.close(); 
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
        return horarios;
    }

}

