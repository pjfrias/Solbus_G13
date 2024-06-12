
package Entidades;

import java.time.Duration;
import java.time.LocalTime;


public class Horario {
    
    private int idHorario;
    private LocalTime salida;
    private LocalTime llegada;    
    private Ruta ruta;
    private boolean estado;

    public Horario() {
    }

    public Horario(int idHorario, LocalTime salida, LocalTime llegada, Ruta ruta, boolean estado) {
        this.idHorario = idHorario;
        this.salida = salida;
        this.llegada = llegada;
        this.ruta = ruta;
        this.estado = estado;
    }

    public Horario(LocalTime salida, LocalTime llegada, Ruta ruta, boolean estado) {
        this.salida = salida;
        this.llegada = llegada;
        this.ruta = ruta;
        this.estado = estado;
    }
    
    public void setDuracion() {
        Duration duracion;
        long horas;
        long minutos;
        
        duracion = Duration.between(salida, llegada);
        horas = duracion.toHours();
        minutos = duracion.minusHours(horas).toMinutes();
        LocalTime duracionTime = LocalTime.of((int) horas, (int) minutos);
        ruta.setDuracion(duracionTime);
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }  

    public LocalTime getSalida() {
        return salida;
    }

    public void setSalida(LocalTime salida) {
        this.salida = salida;
    }

    public LocalTime getLlegada() {
        return llegada;
    }

    public void setLlegada(LocalTime llegada) {
        this.llegada = llegada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   @Override
    public String toString() {
        return "Salida: "+salida+" Hs, llegada: "+llegada+" Hs";
    }
    
    
}
