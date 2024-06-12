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

    public void editarHorarioId(Horario horas) {
        try {
            String sql = "update horarios set hora_salida = ?,hora_llegada = ? where id_horario = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            Time salida = Time.valueOf(horas.getSalida());
            Time llegada = Time.valueOf(horas.getLlegada());

            
            ps.setTime(1, salida);
            ps.setTime(2, llegada);
            ps.setInt(3, horas.getIdHorario());
            
            int fila = ps.executeUpdate();

            if (fila != 0) {
                JOptionPane.showMessageDialog(null, "Se actualizo la hora.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla hora");
        }
    }
    
    
    public void borrarHorarioPorId(Horario horas) {
        try {
            String sql = "update horarios set estado = 0 where id_horario = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, horas.getIdHorario());
            
            int fila = ps.executeUpdate();

            if (fila != 0) {
                JOptionPane.showMessageDialog(null, "Se eliminó el horario.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla horario");
        }
    }
    
    public void activarHorarioPorId(Horario horas) {
        try {
            String sql = "update horarios set estado = 1 where id_horario = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, horas.getIdHorario());
            
            int fila = ps.executeUpdate();

            if (fila != 0) {
                JOptionPane.showMessageDialog(null, "Se activo el horario.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla horario");
        }
    }

    public List buscarHorarios() {
        List<Horario> horarios = new ArrayList<>();
        try {
            String sql = "select rutas.id_ruta,origen,destino,duracion_estimada,hora_salida, hora_llegada"
                    + " from rutas join horarios on horarios.id_ruta = rutas.id_ruta"
                    + " where rutas.estado = 1 and horarios.estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                Ruta nueva = new Ruta();
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
            JOptionPane.showMessageDialog(null, "Error al acceder a una tabla v");
        }        
        return horarios;
        
    }
    
    public List buscarHorariosInactivos() {
        List<Horario> horarios = new ArrayList<>();
        try {
            String sql = "select rutas.id_ruta,origen,destino,duracion_estimada,hora_salida, hora_llegada"
                    + " from rutas join horarios on horarios.id_ruta = rutas.id_ruta"
                    + " where rutas.estado = 0 and horarios.estado = 0";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                Ruta nueva = new Ruta();
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
            JOptionPane.showMessageDialog(null, "Error al acceder a una tabla v");
        }        
        return horarios;
        
    }

    public Horario buscarHorarioID(int id) {
        Horario horario = new Horario();
        try {
            String sql = "select rutas.id_ruta,origen,destino,duracion_estimada,hora_salida, hora_llegada"
                    + " from rutas join horarios on horarios.id_ruta = rutas.id_ruta"
                    + " where rutas.estado = 1 and horarios.estado = 1 and id_horario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ruta nueva = new Ruta();
                nueva.setOrigen(rs.getString("origen"));
                nueva.setDestino(rs.getString("destino"));
                nueva.setDuracion(rs.getTime("duracion_estimada").toLocalTime());
                horario.setIdHorario(rs.getInt("id_ruta"));
                horario.setSalida(rs.getTime("hora_salida").toLocalTime());
                horario.setLlegada(rs.getTime("hora_llegada").toLocalTime());                
                horario.setRuta(nueva);                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a una tabla n");
        }
        return horario;
    }

    
    //AGREGADO JAVIER
    public ArrayList<Horario> buscarHorariosRuta(Ruta ruta) {
        
        ArrayList<Horario> horarios = new ArrayList<>();
        try {
            String sql = "select h.id_horario, h.id_ruta, h.hora_salida, h.hora_llegada, h.estado,"
                    + " r.origen, r.destino, r.duracion_estimada, r.estado"
                    + " from horarios h join rutas r on h.id_ruta = r.id_ruta"
                    + " where h.estado = 1 and r.estado = 1 and r.id_ruta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getIdRuta());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            Horario horario = new Horario();
                horario.setIdHorario(rs.getInt("id_horario"));
                horario.setRuta(new Ruta(rs.getInt("id_ruta"), rs.getString("origen"), rs.getString("destino"), rs.getTime("duracion_estimada").toLocalTime(), true));
                horario.setSalida(rs.getTime("hora_salida").toLocalTime());
                horario.setLlegada(rs.getTime("hora_llegada").toLocalTime());
                horario.setEstado(true);
                horarios.add(horario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los horarios de una ruta");
            ex.printStackTrace();
        }
        return horarios;
    }
    
     public Horario buscarHorariosPasaje(int idPasaje) {
        Horario horario = new Horario();
        Ruta ruta = new Ruta();
                
        try {
            String sql = "select h.id_horario, r.id_ruta, h.hora_salida, h.hora_llegada, r.origen, r.destino, r.duracion_estimada"
                    + " from horarios h"
                    + " join rutas r on h.id_ruta = r.id_ruta"
                    + " join pasajes p on p.id_ruta = r.id_ruta"
                    + " where r.estado = 1 and h.estado = 1 and p.id_pasaje = ? and p.hora_viaje = h.hora_salida";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPasaje);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ruta.setIdRuta(rs.getInt("id_ruta"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDuracion(rs.getTime("duracion_estimada").toLocalTime());
                ruta.setEstado(true);
                horario.setIdHorario(rs.getInt("id_horario"));
                horario.setSalida(rs.getTime("hora_salida").toLocalTime());
                horario.setLlegada(rs.getTime("hora_llegada").toLocalTime());
                horario.setEstado(true);
                horario.setRuta(ruta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el horario del pasaje");
            ex.printStackTrace();
        }
        return horario;
    }     

    public Horario buscarHorarioIDRuta(Ruta ruta) {
        Horario horario = new Horario();
        try {
            String sql = "select rutas.id_ruta,origen,destino,duracion_estimada,id_horario,hora_salida, hora_llegada"
                    + " from rutas join horarios on horarios.id_ruta = rutas.id_ruta"
                    + " where rutas.estado = 1 and horarios.estado = 1 and rutas.id_ruta = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getIdRuta());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ruta nueva = new Ruta();                
                nueva.setOrigen(rs.getString("origen"));
                nueva.setDestino(rs.getString("destino"));
                nueva.setDuracion(rs.getTime("duracion_estimada").toLocalTime());
                horario.setIdHorario(rs.getInt("id_horario"));
                horario.setSalida(rs.getTime("hora_salida").toLocalTime());
                horario.setLlegada(rs.getTime("hora_llegada").toLocalTime());                
                horario.setRuta(nueva);                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a una tabla z");
        }
        System.out.println(horario);
        return horario;
        
    }
    
     public Horario buscarHorarioIDRutaInactivo(Ruta ruta) {
        Horario horario = new Horario();
        try {
            String sql = "select rutas.id_ruta,origen,destino,duracion_estimada,id_horario,hora_salida, hora_llegada"
                    + " from rutas join horarios on horarios.id_ruta = rutas.id_ruta"
                    + " where rutas.estado = 0 and horarios.estado = 0 and rutas.id_ruta = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getIdRuta());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ruta nueva = new Ruta();                
                nueva.setOrigen(rs.getString("origen"));
                nueva.setDestino(rs.getString("destino"));
                nueva.setDuracion(rs.getTime("duracion_estimada").toLocalTime());
                horario.setIdHorario(rs.getInt("id_horario"));
                horario.setSalida(rs.getTime("hora_salida").toLocalTime());
                horario.setLlegada(rs.getTime("hora_llegada").toLocalTime());                
                horario.setRuta(nueva);                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a una tabla z");
        }
        System.out.println(horario);
        return horario;
        
    }

}
