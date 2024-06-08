package Conexion;

import Entidades.Colectivos;
import Entidades.Horarios;
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
            //ps.setInt(2, pasaje.getColectivo());
            //ps.setInt(3, pasaje.getRutas());
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

    import java.sql.
    *;
    import javax.swing.JOptionPane ;
    import java.time.LocalDate ;
    import java.time.LocalTime ;

    public Pasaje buscarPasaje(int id) {
        Pasaje pasaje = null;
        String sql = "SELECT p.id_pasaje, p.fecha_viaje, p.hora_viaje, p.asiento, p.precio, "
                + "pas.id_pasajero, pas.nombre AS nombre_pasajero, pas.apellido AS apellido_pasajero, pas.dni AS dni_pasajero, pas.correo AS correo_pasajero, pas.telefono AS telefono_pasajero, pas.estado AS estado_pasajero, "
                + "c.matricula AS matricula_colectivo, c.marca AS marca_colectivo, c.modelo AS modelo_colectivo, c.capacidad AS capacidad_colectivo, c.estado AS estado_colectivo, "
                + "r.id_ruta, r.origen AS origen_ruta, r.destino AS destino_ruta, r.duracion_estimada, r.estado AS estado_ruta, "
                + "h.salida AS salida_horario, h.llegada AS llegada_horario, h.estado AS estado_horario "
                + "FROM pasajes p "
                + "JOIN pasajeros pas ON p.id_pasajero = pas.id_pasajero "
                + "JOIN colectivos c ON p.id_colectivo = c.id_colectivo "
                + "JOIN rutas r ON p.id_ruta = r.id_ruta "
                + "JOIN horarios h ON r.id_ruta = h.id_ruta "
                + "WHERE p.id_pasaje = ?";
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
                Colectivos colectivo = new Colectivos();
                colectivo.setMatricula(rs.getString("matricula_colectivo"));
                colectivo.setMarca(rs.getString("marca_colectivo"));
                colectivo.setModelo(rs.getString("modelo_colectivo"));
                colectivo.setCapacidad(rs.getInt("capacidad_colectivo"));
                colectivo.setEstado(rs.getBoolean("estado_colectivo"));
                pasaje.setColectivo(colectivo);

                // Crear y asignar Ruta
                Ruta ruta = new Ruta();
                ruta.setOrigen(rs.getString("origen_ruta"));
                ruta.setDestino(rs.getString("destino_ruta"));
                Time duracionEstimada = rs.getTime("duracion_estimada");
                ruta.setDuracion(duracionEstimada.toLocalTime().getHour(), duracionEstimada.toLocalTime().getMinute());
                ruta.setEstado(rs.getBoolean("estado_ruta"));

                // Crear y asignar Horarios
                Horarios horarios = new Horarios();
                horarios.setSalida(rs.getTime("salida_horario").toLocalTime());
                horarios.setLlegada(rs.getTime("llegada_horario").toLocalTime());
                horarios.setEstado(rs.getBoolean("estado_horario"));
                ruta.setHorarios(horarios);  // Asignar horarios a la ruta

                pasaje.setRutas(ruta);  // Asignar ruta al pasaje

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
