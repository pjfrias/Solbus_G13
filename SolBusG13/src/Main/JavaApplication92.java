
package Main;

import Conexion.*;
import Entidades.*;

import Vistas.JFSolBus;
import javax.swing.JFrame;

public class JavaApplication92 {

    public static void main(String[] args) {
        
        JFSolBus solBus = new JFSolBus();
        solBus.setExtendedState(JFrame.MAXIMIZED_BOTH); //aparece la pantalla maximizada
        solBus.setVisible(true);
        
//        Colectivo uno = new Colectivo(1,"aaa123", "ford", "uno", 32, true);
//        Ruta primera = new Ruta(1,"villa merceds","san luis", LocalTime.of(1, 10), true);
//        Horario primer = new Horario(2,LocalTime.of(13, 0), LocalTime.of(14,10), primera, true);
//        Pasajero nuevo = new Pasajero(1,"juan","manuel", "12222226", "correo@correo3.com", "2657111111", true);
//        Pasaje pasaje = new Pasaje(1,nuevo, uno, primera, LocalDate.of(2024, 6, 8), LocalTime.of(13, 0), 0, 0, true);
        
        // pruebo metodos de clase datos colectivo
//      ColectivoData datosColectivo = new ColectivoData();
//      datosColectivo.guardarColectivo(uno);
//      System.out.println(datosColectivo.listarColectivos());
//      System.out.println(datosColectivo.bucarColectivo("aaa123"));
//      Colectivo modificado = new Colectivo(1,"aaa123", "chevrolet", "uno", 32, true);
//      datosColectivo.modificarColectivo(modificado);
//      datosColectivo.eliminarColectivo("aaa123");
        
        // pruebo metodos de clase datos pasajero
//       PasajeroData datosPasajero = new PasajeroData();
//       datosPasajero.guardarPasajero(nuevo);
//        System.out.println(datosPasajero.ListarPasajeros());
//        System.out.println(datosPasajero.bucarPasajero(12222222));
//        Pasajero pasajero = new Pasajero(1,"juan","Torres", "12222222", "tucorreo@correo.com", "2657111111", true);
//        datosPasajero.modificarPasajero(pasajero);
//        datosPasajero.eliminarPasajero(datosPasajero.bucarPasajero(12222222).getIdPasajero());
        
        // pruebo metodos de rutas
//        RutaData datosRuta = new RutaData();
//        datosRuta.guardarRuta(primer);
//        System.out.println(datosRuta.buscarRutasBase(primera));
//        System.out.println(datosRuta.buscarRutasOrigen(primera));
//        Ruta modificada = new Ruta(1,"villa merceds","Merlo", LocalTime.of(1, 10), true);
//        datosRuta.editarRutaporId(modificada);
//       datosRuta.borrarRutaPorId(primera);
        
        // pruebo metodos de horarios
        
//       HorarioData horarios = new HorarioData();
//      horarios.guardarHorario(primer);
//       System.out.println(horarios.buscarHorarios());
//        System.out.println(horarios.buscarHorarioID(2));
//       Horario modificarHorario = new Horario(2,LocalTime.of(13, 0), LocalTime.of(14,25), modificada, true);
//        horarios.editarHorarioId(modificarHorario);
//      horarios.borrarHorarioPorId(primer);
        
        // pruebo metodos de Pasaje
        
//        PasajeData pasajes = new PasajeData();
//        pasajes.guardarPasaje(pasaje);
//        System.out.println(pasajes.listarPasajePorDni(12222222));
//        System.out.println(pasajes.buscarPasajePorId(1));
//        System.out.println(pasajes.buscarPasajePorDni(12222222));
//       Pasaje pasajedos = new Pasaje(5,nuevo, uno, primera, LocalDate.of(2024, 7, 8), LocalTime.of(13, 0), 0, 0, true);
//        pasajes.modificarPasaje(pasajedos);
//        pasajes.eliminarPasaje(5);      
    }
}