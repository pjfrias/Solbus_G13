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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PasajeData {

    private Connection con;

    public PasajeData() {
        con = ConexionDB.getConexion();
    }

    //Crear, Leer, Modificar, Eliminar
    //Guardar, Buscar, Modificar, Eliminar
    public void guardarPasaje(Pasaje pasaje) {
        String sql = "INSERT INTO pasajes (id_pasajero, id_colectivo, id_ruta, fecha_viaje, hora_viaje, asiento, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";// 
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
                pasaje.setIdPasaje(rs.getInt(1));/* aca tira un error, si mal no recuero el profesor dijo que
                                                                   cuando usas ps.getgeneratedkeys(), las comnas tienen otro nombre por lo que lo podes buscar o le pones un cero*/
                JOptionPane.showMessageDialog(null, "Pasaje cargado con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajes" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Pasaje buscarPasajePorDni(int dni) {
        Pasaje pasaje = null;
        String sql = "SELECT \n"
                + "    p.id_pasaje,\n"
                + "    p.id_pasajero,\n"
                + "    pj.nombre AS nombre_pasajero,\n"
                + "    pj.apellido AS apellido_pasajero,\n"
                + "    pj.dni,\n"
                + "    pj.correo,\n"
                + "    pj.telefono,\n"
            //    + "    pj.estado AS estado_pasajero,\n"
                + "    p.id_colectivo,\n"
                + "    c.matricula,\n"
                + "    c.marca,\n"
                + "    c.modelo,\n"
                + "    c.capacidad,\n"
                + "    c.estado AS estado_colectivo,\n"
                + "    p.id_ruta,\n"
                + "    r.origen,\n"
                + "    r.destino,\n"
                + "    r.duracion_estimada,\n"
                + "    r.estado AS estado_ruta,\n"
                + "    p.fecha_viaje,\n"
                + "    p.hora_viaje,\n"
                + "    p.asiento,\n"
                + "    p.precio,\n"
                + "    p.estado AS estado_pasaje,\n"
                + "    h.id_horario,\n"
                + "    h.hora_salida,\n"
                + "    h.hora_llegada,\n"
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
                + "    pj.dni = ?;";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("id_pasaje"));
                pasaje.setFechaViaje(rs.getDate("fecha_viaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("hora_viaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));
            //    pasaje.setEstado(rs.getBoolean("estado_pasaje"));

                // Crear y asignar Pasajero
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre(rs.getString("nombre_pasajero"));
                pasajero.setApellido(rs.getString("apellido_pasajero"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajero.setEstado(rs.getBoolean("estado_pasajero"));
                pasaje.setPasajero(pasajero);

                // Crear y asignar Colectivo
                Colectivo colectivo = new Colectivo();
                colectivo.setId_colectivo(rs.getInt("id_colectivo"));
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
                colectivo.setEstado(rs.getBoolean("estado_colectivo"));
                pasaje.setColectivo(colectivo);

                // Crear y asignar Ruta
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("id_ruta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                Time duracionEstimada = rs.getTime("duracion_estimada");
                ruta.setDuracion(duracionEstimada.toLocalTime());
                ruta.setEstado(rs.getBoolean("estado_ruta"));

                // Crear y asignar Horarios
                Horario horarios = new Horario();
                horarios.setSalida(rs.getTime("hora_salida").toLocalTime());
                horarios.setLlegada(rs.getTime("hora_llegada").toLocalTime());
                horarios.setEstado(rs.getBoolean("estado_horario"));
                horarios.setRuta(ruta);
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

    public Pasaje buscarPasajePorId(int id) {
        Pasaje pasaje = null;
        String sql = "SELECT \n"
                + "    p.id_pasaje,\n"
                + "    p.id_pasajero,\n"
                + "    pj.nombre AS nombre_pasajero,\n"
                + "    pj.apellido AS apellido_pasajero,\n"
                + "    pj.dni,\n"
                + "    pj.correo,\n"
                + "    pj.telefono,\n"
                + "    pj.estado AS estado_pasajero,\n"
                + "    p.id_colectivo,\n"
                + "    c.matricula,\n"
                + "    c.marca,\n"
                + "    c.modelo,\n"
                + "    c.capacidad,\n"
                + "    c.estado AS estado_colectivo,\n"
                + "    p.id_ruta,\n"
                + "    r.origen,\n"
                + "    r.destino,\n"
                + "    r.duracion_estimada,\n"
                + "    r.estado AS estado_ruta,\n"
                + "    p.fecha_viaje,\n"
                + "    p.hora_viaje,\n"
                + "    p.asiento,\n"
                + "    p.precio,\n"
            //    + "    p.estado AS estado_pasaje,\n"
                + "    h.id_horario,\n"
                + "    h.hora_salida,\n"
                + "    h.hora_llegada,\n"
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
            //    pasaje.setEstado(rs.getBoolean("estado_pasaje"));

                // Crear y asignar Pasajero
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre(rs.getString("nombre_pasajero"));
                pasajero.setApellido(rs.getString("apellido_pasajero"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajero.setEstado(rs.getBoolean("estado_pasajero"));
                pasaje.setPasajero(pasajero);

                // Crear y asignar Colectivo
                Colectivo colectivo = new Colectivo();
                colectivo.setId_colectivo(rs.getInt("id_colectivo"));
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
                colectivo.setEstado(rs.getBoolean("estado_colectivo"));
                pasaje.setColectivo(colectivo);

                // Crear y asignar Ruta
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("id_ruta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                Time duracionEstimada = rs.getTime("duracion_estimada");
                ruta.setDuracion(duracionEstimada.toLocalTime());
                ruta.setEstado(rs.getBoolean("estado_ruta"));

                // Crear y asignar Horarios
                Horario horarios = new Horario();
                horarios.setSalida(rs.getTime("hora_salida").toLocalTime());
                horarios.setLlegada(rs.getTime("hora_llegada").toLocalTime());
                horarios.setEstado(rs.getBoolean("estado_horario"));
                horarios.setRuta(ruta);
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

    public List<Pasaje> listarPasajePorDni(int dni) {
        List<Pasaje> pasajeList = new ArrayList<>();
        String sql = "SELECT \n"
                + "    p.id_pasaje,\n"
                + "    p.id_pasajero,\n"
                + "    pj.nombre AS nombre_pasajero,\n"
                + "    pj.apellido AS apellido_pasajero,\n"
                + "    pj.dni,\n"
                + "    pj.correo,\n"
                + "    pj.telefono,\n"
            //    + "    pj.estado AS estado_pasajero,\n"
                + "    p.id_colectivo,\n"
                + "    c.matricula,\n"
                + "    c.marca,\n"
                + "    c.modelo,\n"
                + "    c.capacidad,\n"
                + "    c.estado AS estado_colectivo,\n"
                + "    p.id_ruta,\n"
                + "    r.origen,\n"
                + "    r.destino,\n"
                + "    r.duracion_estimada,\n"
                + "    r.estado AS estado_ruta,\n"
                + "    p.fecha_viaje,\n"
                + "    p.hora_viaje,\n"
                + "    p.asiento,\n"
                + "    p.precio,\n"
                + "    p.estado AS estado_pasaje,\n"
                + "    h.id_horario,\n"
                + "    h.hora_salida,\n"
                + "    h.hora_llegada,\n"
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
                + "    pj.dni = ?;";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("id_pasaje"));
                pasaje.setFechaViaje(rs.getDate("fecha_viaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("hora_viaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));
           //     pasaje.setEstado(rs.getBoolean("estado_pasaje"));

                // Crear y asignar Pasajero
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre(rs.getString("nombre_pasajero"));
                pasajero.setApellido(rs.getString("apellido_pasajero"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajero.setEstado(rs.getBoolean("estado_pasajero"));
                pasaje.setPasajero(pasajero);

                // Crear y asignar Colectivo
                Colectivo colectivo = new Colectivo();
                colectivo.setId_colectivo(rs.getInt("id_colectivo"));
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
                colectivo.setEstado(rs.getBoolean("estado_colectivo"));
                pasaje.setColectivo(colectivo);

                // Crear y asignar Ruta
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("id_ruta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                Time duracionEstimada = rs.getTime("duracion_estimada");
                ruta.setDuracion(duracionEstimada.toLocalTime());
                ruta.setEstado(rs.getBoolean("estado_ruta"));

                // Crear y asignar Horarios
                Horario horarios = new Horario();
                horarios.setSalida(rs.getTime("hora_salida").toLocalTime());
                horarios.setLlegada(rs.getTime("hora_llegada").toLocalTime());
                horarios.setEstado(rs.getBoolean("estado_horario"));
                horarios.setRuta(ruta);
                pasaje.setRutas(ruta);
                pasajeList.add(pasaje);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasaje " + ex.getMessage());
        }

        return pasajeList;
    }
    
    public void modificarPasaje(Pasaje pasaje){
        String sql = "update pasajes set id_pasajero = ?, id_colectivo = ?, id_ruta = ?, fecha_viaje = ?, hora_viaje = ?, asiento = ?, precio = ? WHERE id_pasaje = ?"; 
        PreparedStatement ps = null;
        try{ 
            ps = con.prepareStatement(sql);
            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
            ps.setInt(2, pasaje.getColectivo().getId_colectivo());
            ps.setInt(3, pasaje.getRutas().getIdRuta());
            ps.setDate(4, Date.valueOf(pasaje.getFechaViaje()));
            ps.setTime(5, Time.valueOf(pasaje.getHoraViaje()));
            ps.setInt(6, pasaje.getAsiento());
            ps.setDouble(7, pasaje.getPrecio());
            ps.setInt(8, pasaje.getIdPasaje());
            
            int fila = ps.executeUpdate(); 

            if(fila == 1){ 
                JOptionPane.showMessageDialog(null, "Pasaje modificado Exitosamente."); 
            }else{ 
            JOptionPane.showMessageDialog(null, "El pasaje no se encuentra activo en la Base de Datos"); 
            } 

        }catch(SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasaje"+ ex.getMessage()); 
        }
    }
    
    public void eliminarPasaje(int idPasaje){
       try { 
            String sql = "delete from pasajes WHERE id_pasaje = ? "; 
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, idPasaje); 
            int fila=ps.executeUpdate(); 

            if(fila==1){ 
                JOptionPane.showMessageDialog(null, " Se ha eliminado al pasaje de la Base de Datos."); 
            } 
            ps.close(); 
            }catch(SQLException e){ 
                JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Pasaje");
                e.printStackTrace();
            } 
    }

}
