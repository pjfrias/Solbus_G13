/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Entidades.Colectivo;
import Entidades.Horario;
import Entidades.Pasajero;
import Entidades.Pasaje;
import Entidades.Ruta;
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
 * @author prueba
 */
public class ColectivoData {

    private Connection conexion = null;

    public ColectivoData() {
        conexion = ConexionDB.getConexion();
    }

    // crud
    //create
    public void guardarColectivo(Colectivo colectivo) { 
        String sqlVerificar = "SELECT id_colectivo FROM colectivos WHERE matricula = ? AND estado = false";
        String sqlActualizarEstado = "UPDATE colectivos SET estado = true WHERE id_colectivo = ?";
        String sqlActualizarInfo = "UPDATE colectivos SET marca = ?, modelo = ?, matricula = ?, capacidad = ? WHERE id_colectivo = ?";
        String sqlInsertar = "INSERT INTO colectivos (marca, modelo, matricula, capacidad, estado) VALUES (?, ?, ?, ?, true)";

        try {
            // Verifico si el colectivo existe y está marcado como eliminado (estado = false)
            PreparedStatement psVerificar = conexion.prepareStatement(sqlVerificar);
            psVerificar.setString(1, colectivo.getMatricula());
            ResultSet rsVerificar = psVerificar.executeQuery();

            if (rsVerificar.next()) {
                // Si existe, actualizo el estado a true
                int idExistente = rsVerificar.getInt("id_colectivo");

                PreparedStatement psActualizarEstado = conexion.prepareStatement(sqlActualizarEstado);
                psActualizarEstado.setInt(1, idExistente);
                psActualizarEstado.executeUpdate();
                psActualizarEstado.close();

                // Actualizo la información del colectivo
                PreparedStatement psActualizarInfo = conexion.prepareStatement(sqlActualizarInfo);
                psActualizarInfo.setString(1, colectivo.getMarca());
                psActualizarInfo.setString(2, colectivo.getModelo());
                psActualizarInfo.setString(3, colectivo.getMatricula());
                psActualizarInfo.setInt(4, colectivo.getCapacidad());
                psActualizarInfo.setInt(5, idExistente);
                psActualizarInfo.executeUpdate();
                psActualizarInfo.close();

                colectivo.setId_colectivo(idExistente);
                JOptionPane.showMessageDialog(null, "Colectivo actualizado con éxito.");
            } else {
                // Si no existe, inserto el nuevo colectivo
                PreparedStatement psInsertar = conexion.prepareStatement(sqlInsertar, Statement.RETURN_GENERATED_KEYS);
                psInsertar.setString(1, colectivo.getMarca());
                psInsertar.setString(2, colectivo.getModelo());
                psInsertar.setString(3, colectivo.getMatricula());
                psInsertar.setInt(4, colectivo.getCapacidad());
                psInsertar.executeUpdate();

                ResultSet rsInsertar = psInsertar.getGeneratedKeys();
                if (rsInsertar.next()) {
                    colectivo.setId_colectivo(rsInsertar.getInt(1));
                    JOptionPane.showMessageDialog(null, "Colectivo añadido con éxito.");
                }
                psInsertar.close();
            }

            psVerificar.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Colectivos: " + ex.getMessage());

        
        }
        
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /* String sqlVerificar = "SELECT matricula FROM colectivos WHERE estado = false";
        String sqlActualizarEstado = "UPDATE colectivos SET estado = true WHERE matricula = ?";
        String sqlActualizarInfo = "UPDATE colectivos SET matricula = ?, modelo = ?, marca = ?, capacidad = ? WHERE matricula = ?";
        String sqlInsertar = "INSERT INTO colectivos (matricula, modelo, marca, capacidad, estado) VALUES (?, ?, ?, ?, true)";

        //String sql = "INSERT INTO colectivos(matricula,marca,modelo,capacidad,estado) VALUES(?,?,?,?,?)";

         try {
            //Verifico si el pasajero existe y está marcado como eliminado (estado = false)
            PreparedStatement psVerificar = conexion.prepareStatement(sqlVerificar);
            psVerificar.setString(1, colectivo.getMatricula());
            ResultSet rsVerificar = psVerificar.executeQuery();

            if (rsVerificar.next()) {
                //Si existe, actualizo el estado a true
                String matExistente = rsVerificar.getString("matricula");

                try (PreparedStatement psActualizarEstado = conexion.prepareStatement(sqlActualizarEstado)) {
                    psActualizarEstado.setString(1, matExistente);
                    psActualizarEstado.executeUpdate();
                }

                // Actualizo la información del pasajero
                PreparedStatement psActualizarInfo = conexion.prepareStatement(sqlActualizarInfo);
                psActualizarInfo.setString(1, colectivo.getMatricula());
                psActualizarInfo.setString(3, colectivo.getMarca());
                psActualizarInfo.setString(2, colectivo.getModelo());
                psActualizarInfo.setInt(4, colectivo.getCapacidad());
               // psActualizarInfo.setString(6, matExistente);
                psActualizarInfo.executeUpdate();
                psActualizarInfo.close();

                colectivo.setMatricula(matExistente);
                JOptionPane.showMessageDialog(null, "Pasajero añadido con exito");
            } else {
                //Si no existe, inserto el nuevo pasajero
                PreparedStatement psInsertar = conexion.prepareStatement(sqlInsertar, Statement.RETURN_GENERATED_KEYS);
                psInsertar.setString(1, colectivo.getMatricula());
                psInsertar.setString(2, colectivo.getMarca());
                psInsertar.setString(3, colectivo.getModelo());
                psInsertar.setInt(4, colectivo.getCapacidad());
                 psInsertar.setBoolean(5, colectivo.isEstado());
                psInsertar.executeUpdate();

                ResultSet rsInsertar = psInsertar.getGeneratedKeys();
                if (rsInsertar.next()) {
                    colectivo.setMatricula(rsInsertar.getInt(1));
                    JOptionPane.showMessageDialog(null, "colectivo añadido con éxito.");
                }
                psInsertar.close();
            }

            psVerificar.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar un colectivo: " +ex.getMessage());
        }
        
        */
        
       /* try {
            // preparamos la ejecucion de la consulta sql
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, colectivo.getMatricula());
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());
            ps.setBoolean(5, colectivo.isEstado());
            // usamos update cuando vamos a hacer una modificacion en la base de datos
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();// ---> Recupera cualquier clave generada automáticamente que se cree como resultado de ejecutar este objeto SQLStatement.

            if (rs.next()) {

                
                JOptionPane.showMessageDialog(null, "colectivo añadido con exito.");

            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al aniadir un colectivo" + e.getMessage());
            e.printStackTrace();// se usa para imprimir este Throwable junto con otros detalles como el nombre de la clase y el número de línea donde ocurrió la excepción significa su rastreo inverso. Este método imprime un 
            //seguimiento de pila para este objeto Throwable en el flujo de salida de error estándar. 
        }*/

   
     
     
     //reed
     public Colectivo bucarColectivo(String matricula) {
        Colectivo colectivoExistente = null;
        String sql = "SELECT marca, modelo, capacidad FROM colectivos WHERE matricula like ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery(); // ==>Ejecuta la instrucción SQL determinada y devuelve un objeto SQLServerResultSet único.

            if (rs.next()) { // Método que mueve el cursor una fila dentro del ResultSet. Inicialmente el cursor se sitúa antes de la primera fila. Cuando el cursor se posiciona después de la última fila el método devuelve false.
                colectivoExistente = new Colectivo(); // creamos un nuevo cole y le seteamos campo por campo.
                colectivoExistente.setMatricula(matricula);
                colectivoExistente.setMarca(rs.getString("marca"));
                colectivoExistente.setModelo(rs.getString("modelo"));

                colectivoExistente.setCapacidad(rs.getInt("capacidad"));
                colectivoExistente.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra el colectivo");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder al buscado de colectivo " + ex.getMessage());
        }

        return colectivoExistente;
    }

    //update
    public void modificarColectivo(Colectivo colectivo) {
        String sql = "UPDATE colectivos SET matricula = ? , marca = ?, modelo = ?,capacidad = ?  WHERE id_colectivo = ?";
        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, colectivo.getMatricula());//lo cambie porque el orden empieza en 1 no en cero
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());//lo cambie porque el la capacidad es 4, el 5 es el id
            ps.setInt(5, colectivo.getId_colectivo()); // lo puse para sacar el id del objeto colectivo, esto despues lo podes poner para sacar como mejor te venga

            int update = ps.executeUpdate();

            if (update == 1) {
                JOptionPane.showMessageDialog(null, " Colectivo modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El colectivo no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder al colectivo " + ex.getMessage());
        }
    }

    //delete
    public void eliminarColectivo(String matricula) { 
        try {
            String sql = "UPDATE colectivos SET estado = 0 WHERE matricula like ? ";//estaba escrito colectivo le agregue la s para que quedara bien
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, matricula);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó colectivo Nro : " + matricula);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al querer eliminar colectivo");
        }
    }

    // listar colectivos activos
    public List<Colectivo> listarColectivos() {
        List<Colectivo> coles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM colectivos WHERE estado = 1 ";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Colectivo colectivo = new Colectivo();
                 colectivo.setMatricula(rs.getString("matricula"));
                 colectivo.setModelo(rs.getString("modelo"));
                colectivo.setMarca(rs.getString("marca"));
                
                colectivo.setCapacidad(rs.getInt("capacidad"));

                coles.add(colectivo);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al listar los colectivos" + ex.getMessage());
        }
        return coles;
    }
    
    //AGREGADO JAVIER
    public Colectivo buscarColectivoPasajesVendidos(Horario horario, Date fecha){
        Colectivo cole = null;
        try{
            String sql ="select c.id_colectivo, c.matricula, c.marca, c.modelo, c.capacidad\n" +
                        "from colectivos c\n" +
                        "join pasajes p on (c.id_colectivo = p.id_colectivo)\n" +
                        "join rutas r on (r.id_ruta = p.id_ruta)join horarios h on (h.id_ruta = p.id_ruta)\n" +
                        "where h.id_horario = ? and p.fecha_viaje = ? and c.estado = 1";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, horario.getIdHorario());
            ps.setDate(2, fecha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                cole = new Colectivo();
                cole.setId_colectivo(rs.getInt("Id_colectivo"));
                cole.setMarca(rs.getString("marca"));
                cole.setModelo(rs.getString("modelo"));
                cole.setMatricula(rs.getString("matricula"));
                cole.setCapacidad(rs.getInt("capacidad"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al obtener colectivo disponible");
            ex.printStackTrace();
        }
        return cole;
    }
    
    public int verLugaresOcupados(Colectivo colectivo, Horario horario, Date fecha){
        int pasajesVendidos = 0;
        try{
            String sql ="select count(p.id_pasaje) as pasajes_vendidos\n" +
                        "from pasajes p\n" +
                        "join colectivos c on (c.id_colectivo = p.id_colectivo)\n" +
                        "join rutas r on (r.id_ruta = p.id_ruta)\n" +
                        "join horarios h on (h.id_ruta = p.id_ruta)\n" +
                        "where h.id_horario = ? and p.fecha_viaje = ? and c.id_colectivo = ?\n";
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, horario.getIdHorario());
            ps.setDate(2, fecha);
            ps.setInt(3, colectivo.getId_colectivo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                pasajesVendidos = rs.getInt("pasajes_vendidos");
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al obtener pasajes vendidos");
        }
        return pasajesVendidos;
    }
    
    public ArrayList<Pasajero> verPasajerosColectivo(Colectivo colectivo, Horario horario, Date fecha){
        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        Pasajero pasajero;
        try {
            String sql ="select p.id_pasajero, p.nombre, p.apellido, p.dni, p.correo, p.telefono\n" +
                        "from pasajeros p\n" +
                        "join pasajes pas on (p.id_pasajero = pas.id_pasajero)\n" +
                        "join rutas r on (r.id_ruta = pas.id_ruta)\n" +
                        "join horarios h on (h.id_ruta = r.id_ruta)\n" +
                        "join colectivos c on (pas.id_colectivo = c.id_colectivo)\n" +
                        "where h.id_horario = ? and pas.fecha_viaje = ? and c.id_colectivo = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, horario.getIdHorario());
            ps.setDate(1, fecha);
            ps.setInt(3, colectivo.getId_colectivo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajeros.add(pasajero);
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener la lista de pasajeros");
        }
        return pasajeros;
    }
    
    public ArrayList<Pasaje> verPasajerosAsientos(Colectivo colectivo, Horario horario, Date fecha){
        ArrayList<Pasaje> pasajes = new ArrayList<>();
        Pasaje pasaje;
        try {
            String sql ="select p.id_pasaje, p.id_pasajero, p.id_colectivo, p.id_ruta, p.fecha_viaje, p.hora_viaje, p.asiento, "
                    + "pas.nombre, pas.apellido, pas.dni, pas.correo, pas.telefono, c.matricula, c.marca, c.modelo, c.capacidad, "
                    + "r.origen, r.destino, r.duracion_estimada\n" +
                    "from pasajes p\n" +
                    "join pasajeros pas on (p.id_pasajero = pas.id_pasajero)\n" +
                    "join rutas r on (r.id_ruta = p.id_ruta)\n" +
                    "join horarios h on (h.id_ruta = r.id_ruta)\n" +
                    "join colectivos c on (p.id_colectivo = c.id_colectivo)\n" +
                    "where h.id_horario = ? and p.fecha_viaje = ? and c.id_colectivo = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, horario.getIdHorario());
            ps.setDate(2, fecha);
            ps.setInt(3, colectivo.getId_colectivo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("id_pasaje"));
                pasaje.setPasajero(new Pasajero(rs.getInt("id_pasajero"),rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getString("correo"), rs.getString("telefono"), true));
                pasaje.setColectivo(new Colectivo(rs.getInt("id_colectivo"), rs.getString("matricula"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("capacidad"), true));
                pasaje.setRutas(new Ruta(rs.getInt("id_ruta"), rs.getString("origen"), rs.getString("destino"), rs.getTime("duracion_estimada").toLocalTime(), true));
                pasaje.setFechaViaje(rs.getDate("fecha_viaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("hora_viaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasajes.add(pasaje);
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener la lista de pasajeros y asientos");
            e.printStackTrace();
        }
        return pasajes;
    }

    public ArrayList<Colectivo> verColectivosVacios(Date fecha){
        ArrayList<Colectivo> colectivos = new ArrayList<>();
        Colectivo colectivo = null;
        try {
            String sql = "SELECT c.id_colectivo, c.matricula, c.marca, c.modelo, c.capacidad\n" +
                        "FROM colectivos c\n" +
                        "WHERE NOT EXISTS (\n" +
                        "    SELECT 1\n" +
                        "    FROM pasajes p\n" +
                        "    WHERE c.id_colectivo = p.id_colectivo\n" +
                        "    AND p.fecha_viaje = ?\n" +
                        ")\n" +
                        "AND c.estado = TRUE;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDate(1, fecha);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                colectivo = new Colectivo();
                colectivo.setId_colectivo(rs.getInt("id_colectivo"));
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
                colectivo.setEstado(true);
                colectivos.add(colectivo);
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener lista de colectivos disponibles");
        }
        return colectivos;
    }
}
