/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Entidades.Pasajero;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 54265
 */
public class PasajeroData {

    private Connection con = null;

    public PasajeroData() {
        con = ConexionDB.getConexion();
    }

    public void guardarPasajero(Pasajero pasajero) {
        String sqlVerificar = "SELECT id_pasajero FROM pasajeros WHERE dni = ? AND estado = false";
        String sqlActualizarEstado = "UPDATE pasajeros SET estado = true WHERE id_pasajero = ?";
        String sqlActualizarInfo = "UPDATE pasajeros SET nombre = ?, apellido = ?, dni = ?, correo = ?, telefono = ? WHERE id_pasajero = ?";
        String sqlInsertar = "INSERT INTO pasajeros (nombre, apellido, dni, correo, telefono, estado) VALUES (?, ?, ?, ?, ?, true)";

        try {
            //Verifico si el pasajero existe y está marcado como eliminado (estado = false)
            PreparedStatement psVerificar = con.prepareStatement(sqlVerificar);
            psVerificar.setString(1, pasajero.getDni());
            ResultSet rsVerificar = psVerificar.executeQuery();

            if (rsVerificar.next()) {
                //Si existe, actualizo el estado a true
                int idExistente = rsVerificar.getInt("id_pasajero");

                PreparedStatement psActualizarEstado = con.prepareStatement(sqlActualizarEstado);
                psActualizarEstado.setInt(1, idExistente);
                psActualizarEstado.executeUpdate();
                psActualizarEstado.close();

                // Actualizo la información del pasajero
                PreparedStatement psActualizarInfo = con.prepareStatement(sqlActualizarInfo);
                psActualizarInfo.setString(1, pasajero.getNombre());
                psActualizarInfo.setString(2, pasajero.getApellido());
                psActualizarInfo.setString(3, pasajero.getDni());
                psActualizarInfo.setString(4, pasajero.getCorreo());
                psActualizarInfo.setString(5, pasajero.getTelefono());
                psActualizarInfo.setInt(6, idExistente);
                psActualizarInfo.executeUpdate();
                psActualizarInfo.close();

                pasajero.setIdPasajero(idExistente);
                JOptionPane.showMessageDialog(null, "Pasajero añadido con exito");
            } else {
                //Si no existe, inserto el nuevo pasajero
                PreparedStatement psInsertar = con.prepareStatement(sqlInsertar, Statement.RETURN_GENERATED_KEYS);
                psInsertar.setString(1, pasajero.getNombre());
                psInsertar.setString(2, pasajero.getApellido());
                psInsertar.setString(3, pasajero.getDni());
                psInsertar.setString(4, pasajero.getCorreo());
                psInsertar.setString(5, pasajero.getTelefono());
                psInsertar.executeUpdate();

                ResultSet rsInsertar = psInsertar.getGeneratedKeys();
                if (rsInsertar.next()) {
                    pasajero.setIdPasajero(rsInsertar.getInt(1));
                    JOptionPane.showMessageDialog(null, "Pasajero añadido con éxito.");
                }
                psInsertar.close();
            }

            psVerificar.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros: " + ex.getMessage());
        }
    }

    public Pasajero bucarPasajero(int dni) {
        Pasajero pasajero = null;
        String sql = "SELECT id_pasajero,nombre, apellido, dni, correo, telefono FROM pasajeros WHERE dni = ? AND estado = 1"; //le agregue id_pasajero para que no tirara error
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajero.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra el pasajero en la Base de Datos");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros " + ex.getMessage());
        }

        return pasajero;
    }

    public void modificarPasajero(Pasajero pasajero) {
        String sql = "update pasajeros set nombre = ?, apellido = ?, dni = ?, correo = ?, telefono = ? WHERE id_pasajero = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setInt(6, pasajero.getIdPasajero());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pasajero modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El pasajero no se encuentra activo en la Base de Datos");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros" + ex.getMessage());
        }
    }

    public void eliminarPasajero(int idPasajero) {
        try {
            String sql = "update pasajeros set estado = 0 WHERE id_pasajero = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se ha eliminado al pasajero de la Base de Datos.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Pasajeros");
        }
    }

    public List<Pasajero> BuscarPasajerosViaje(Date fecha, String origen, String destino) {
        List<Pasajero> pasajeros = new ArrayList<>();

        String sql = "select p.id_pasajero, p.nombre, p.apellido, p.dni, p.correo, p.telefono\n"
                + "from pasajeros p\n"
                + " join pasajes on p.id_pasajero = pasajes.id_pasajero\n"
                + " join rutas r on pasajes.id_ruta = r.id_ruta\n"
                + "where r.origen = ? and r.destino = ? \n"
                + " and pasajes.fecha_viaje = ? \n"
                + " and p.estado = 1";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setDate(3, fecha);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pasajero pas = new Pasajero();
                pas.setIdPasajero(rs.getInt("id_pasajero"));
                pas.setNombre(rs.getString("nombre"));
                pas.setApellido(rs.getString("apellido"));
                pas.setDni(rs.getString("dni"));
                pas.setCorreo(rs.getString("correo"));
                pas.setTelefono(rs.getString("telefono"));
                pas.setEstado(true);

                pasajeros.add(pas);
            }
            ps.close();

            if (pasajeros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encuentran pasajeros en la Base de Datos");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros " + ex.getMessage());
        }

        return pasajeros;
    }

    public List<Pasajero> ListarPasajeros() {
        List<Pasajero> pasajeros = new ArrayList<>();

        String sql = "select p.id_pasajero, p.nombre, p.apellido, p.dni, p.correo, p.telefono\n"
                + "from pasajeros p where p.estado = 1";// aca agregue p where

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pasajero pas = new Pasajero();
                pas.setIdPasajero(rs.getInt("id_pasajero"));
                pas.setNombre(rs.getString("nombre"));
                pas.setApellido(rs.getString("apellido"));
                pas.setDni(rs.getString("dni"));
                pas.setCorreo(rs.getString("correo"));
                pas.setTelefono(rs.getString("telefono"));
                pas.setEstado(true);

                pasajeros.add(pas);
            }
            ps.close();

            if (pasajeros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encuentran pasajeros en la Base de Datos");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros " + ex.getMessage());
        }

        return pasajeros;
    }
}
