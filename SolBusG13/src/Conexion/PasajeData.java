package Conexion;

import Entidades.Colectivo;
import Entidades.Horario;
import Entidades.Pasaje;
import Entidades.Pasajero;
import Entidades.Ruta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;

public class PasajeData {

    private Connection con;

    public PasajeData() {
        con = ConexionDB.getConexion();
    }

    //Crear, Leer, Modificar, Eliminar
    //Guardar, Buscar, Modificar, Eliminar
    public void guardarPasaje(Pasaje pasaje) {
        String sql = "INSERT INTO pasajes (id_pasajero, id_colectivo, id_ruta, fecha_viaje, hora_viaje, asiento, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
            ps.setInt(2, pasaje.getColectivo().getId_colectivo());
            ps.setInt(3, pasaje.getRutas().getIdRuta());
            ps.setDate(4, Date.valueOf(pasaje.getFechaViaje()));
            ps.setTime(5, Time.valueOf(pasaje.getHoraViaje()));
            ps.setInt(6, pasaje.getAsiento());
            ps.setDouble(7, pasaje.getPrecio());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pasaje.setIdPasaje(rs.getInt("id_pasaje"));
                JOptionPane.showMessageDialog(null, "Pasaje cargado con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajes" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Pasaje buscarPasaje(int id) {
        Pasaje pasaje = null;
        String sql = "SELECT \n"
                + "    p.id_pasaje,\n"
                + "    p.id_pasajero,\n"
                + "    pj.nombre AS nombre_pasajero,\n"
                + "    pj.apellido AS apellido_pasajero,\n"
                + "    pj.dni AS dni_pasajero,\n"
                + "    pj.correo AS correo_pasajero,\n"
                + "    pj.telefono AS telefono_pasajero,\n"
                + "    pj.estado AS estado_pasajero,\n"
                + "    p.id_colectivo,\n"
                + "    c.matricula AS matricula_colectivo,\n"
                + "    c.marca AS marca_colectivo,\n"
                + "    c.modelo AS modelo_colectivo,\n"
                + "    c.capacidad AS capacidad_colectivo,\n"
                + "    c.estado AS estado_colectivo,\n"
                + "    p.id_ruta,\n"
                + "    r.origen AS origen_ruta,\n"
                + "    r.destino AS destino_ruta,\n"
                + "    r.duracion_estimada,\n"
                + "    r.estado AS estado_ruta,\n"
                + "    p.fecha_viaje,\n"
                + "    p.hora_viaje,\n"
                + "    p.asiento,\n"
                + "    p.precio,\n"
                + "    h.id_horario,\n"
                + "    h.hora_salida AS salida_horario,\n"
                + "    h.hora_llegada AS llegada_horario,\n"
                + "    h.estado AS estado_horario\n"
                + "FROM \n"
                + "    pasajes p\n"
                + "JOIN \n"
                + "    pasajeros pj ON p.id_pasajero = pj.id_pasajero\n"
                + "JOIN \n"
                + "    colectivos c ON p.id_colectivo = c.id_colectivo\n"
                + "JOIN \n"
                + "    rutas r ON p.id_ruta = r.id_ruta\n"
                + "JOIN \n"
                + "    horarios h ON r.id_ruta = h.id_ruta\n"
                + "WHERE \n"
                + "    p.id_pasaje = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("id_pasaje"));
                pasaje.setFechaViaje(rs.getDate("fecha_viaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("hora_viaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));

                // Crear y asignar Pasajero
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre(rs.getString("nombre_pasajero"));
                pasajero.setApellido(rs.getString("apellido_pasajero"));
                pasajero.setDni(rs.getString("dni_pasajero"));
                pasajero.setCorreo(rs.getString("correo_pasajero"));
                pasajero.setTelefono(rs.getString("telefono_pasajero"));
                pasajero.setEstado(rs.getBoolean("estado_pasajero"));
                pasaje.setPasajero(pasajero);

                // Crear y asignar Colectivo
                Colectivo colectivo = new Colectivo();
                colectivo.setId_colectivo(rs.getInt("id_colectivo"));
                colectivo.setMatricula(rs.getString("matricula_colectivo"));
                colectivo.setMarca(rs.getString("marca_colectivo"));
                colectivo.setModelo(rs.getString("modelo_colectivo"));
                colectivo.setCapacidad(rs.getInt("capacidad_colectivo"));
                colectivo.setEstado(rs.getBoolean("estado_colectivo"));
                pasaje.setColectivo(colectivo);

                // Crear y asignar Ruta
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("id_ruta"));
                ruta.setOrigen(rs.getString("origen_ruta"));
                ruta.setDestino(rs.getString("destino_ruta"));
                Time duracionEstimada = rs.getTime("duracion_estimada");
                ruta.setDuracion(duracionEstimada.toLocalTime());
                ruta.setEstado(rs.getBoolean("estado_ruta"));

                // Crear y asignar Horarios
                Horario horarios = new Horario();
                horarios.setSalida(rs.getTime("salida_horario").toLocalTime());
                horarios.setLlegada(rs.getTime("llegada_horario").toLocalTime());
                horarios.setEstado(rs.getBoolean("estado_horario"));

                // Asignar la Ruta al Horario
                horarios.setRuta(ruta);

                // Establecer la duración de la Ruta en base al Horario
                horarios.setDuracion();
                pasaje.setRutas(ruta);

            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra el pasaje");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasaje " + ex.getMessage());
        }

        return pasaje;
    }
    
    

}
