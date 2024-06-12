package Conexion;

import Entidades.Horario;
import Entidades.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
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
            ps.setString(2, horas.getRuta().getDestino());
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

    public void editarRutaporId(Ruta ruta) {
        try {
            String sql = "update rutas set origen = ?,destino = ?,duracion_estimada = ? where id_ruta = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            Time duracion = Time.valueOf(ruta.getDuracion());
            
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, duracion);
            ps.setInt(4, ruta.getIdRuta());
            
            int fila = ps.executeUpdate();

            if (fila != 0) {
                JOptionPane.showMessageDialog(null, "Se actualizo la ruta.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
    }

    public void borrarRutaPorId(Ruta ruta) {
        try {
            String sql = "update rutas set estado = 0 where id_ruta = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getIdRuta());
            int fila = ps.executeUpdate();

            if (fila != 0) {
                JOptionPane.showMessageDialog(null, "Se eliminó la ruta.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
    }
    
    public void activarRutaPorId(Ruta ruta) {
        try {
            String sql = "update rutas set estado = 1 where id_ruta = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getIdRuta());
            int fila = ps.executeUpdate();

            if (fila != 0) {
                JOptionPane.showMessageDialog(null, "Se activo la ruta.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
    }

    public Ruta buscarRutasBase(Ruta ruta) {
        Ruta nueva=new Ruta();
        
        try {
            String sql = "select id_ruta,origen,destino,duracion_estimada from rutas where estado = 1 and id_ruta = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getIdRuta());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nueva.setIdRuta(rs.getInt("id_ruta"));
                nueva.setOrigen(rs.getString("origen"));
                nueva.setDestino(rs.getString("destino"));
                nueva.setDuracion(rs.getTime("duracion_estimada").toLocalTime());                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
        return nueva;
    }
    public Ruta buscarRutaOrigenDestino(Ruta ruta) {
        Ruta nueva=new Ruta();
        
        try {
            String sql = "select id_ruta,origen,destino,duracion_estimada from rutas where estado = 1 and origen = ? and destino = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ruta.getOrigen());
            ps.setString(2,ruta.getDestino());
            ResultSet rs = ps.executeQuery();        
            
            while(rs.next()){
                nueva.setIdRuta(rs.getInt("id_ruta"));                
                nueva.setOrigen(rs.getString("origen"));
                nueva.setDestino(rs.getString("destino"));
                nueva.setDuracion(rs.getTime("duracion_estimada").toLocalTime());                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }        
        return nueva;
    }
    
    public Ruta buscarRutaOrigenDestinoInactivo(Ruta ruta) {
        Ruta nueva=new Ruta();
        
        try {
            String sql = "select id_ruta,origen,destino,duracion_estimada from rutas where estado = 0 and origen = ? and destino = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ruta.getOrigen());
            ps.setString(2,ruta.getDestino());
            ResultSet rs = ps.executeQuery();        
            
            while(rs.next()){
                nueva.setIdRuta(rs.getInt("id_ruta"));                
                nueva.setOrigen(rs.getString("origen"));
                nueva.setDestino(rs.getString("destino"));
                nueva.setDuracion(rs.getTime("duracion_estimada").toLocalTime());                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }        
        return nueva;
    }

    public List buscarRutasOrigen(Ruta ruta) {
        List<Horario> horarios = new ArrayList<>();
        try {
            String sql = "select rutas.id_ruta,origen,destino,duracion_estimada,hora_salida, hora_llegada"
                    + " from rutas join horarios on horarios.id_ruta = rutas.id_ruta"
                    + " where rutas.estado = 1 and horarios.estado = 1 and origen= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ruta.getOrigen());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Horario horario = new Horario();
                Ruta nueva=new Ruta();
                nueva.setOrigen(rs.getString("origen"));
                nueva.setDestino(rs.getString("destino"));
                nueva.setDuracion(rs.getTime("duracion_estimada").toLocalTime());
                horario.setIdHorario(rs.getInt("id_ruta"));
                horario.setSalida(rs.getTime("hora_salida").toLocalTime());
                horario.setLlegada(rs.getTime("hora_llegada").toLocalTime());                
                horario.setRuta(nueva);                
                horarios.add(horario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a una tabla");
        }
        return horarios;
    }
    
    //AGREGADO JAVIER
    public ArrayList<Ruta> buscarRutas(){
        ArrayList<Ruta> rutas = new ArrayList<>();
        try {
            String sql = "select id_ruta,origen,destino,duracion_estimada from rutas where estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){   
                Ruta nueva = new Ruta();
                nueva.setIdRuta(rs.getInt("id_ruta"));
                nueva.setOrigen(rs.getString("origen"));
                nueva.setDestino(rs.getString("destino"));
                nueva.setDuracion(rs.getTime("duracion_estimada").toLocalTime());
                rutas.add(nueva);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ruta");
        }
        return rutas;
    }
}
