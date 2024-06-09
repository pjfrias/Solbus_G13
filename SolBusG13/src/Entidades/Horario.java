
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

    public Horario(LocalTime salida, LocalTime llegada, Ruta ruta, boolean estado) {
        this.salida = salida;
        this.llegada = llegada;
        this.ruta = ruta;
        this.estado = estado;
    }
    
    public void setDuracion() {
        Duration duracion; 
        duracion = Duration.between(salida, llegada);
        LocalTime duracionTime = LocalTime.of((int) duracion.toHours(), (int) duracion.toMinutes());
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
        StringBuilder sb = new StringBuilder();
        sb.append("Horarios{");
        sb.append("salida=").append(salida);
        sb.append(", llegada=").append(llegada);
        sb.append('}');
        return sb.toString();
    }
    
    
}
