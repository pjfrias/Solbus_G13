
package Entidades;

import java.time.Duration;


public class Ruta {
    private int idRuta;
    private String origen;
    private String destino;
    private Duration duracion;
    private boolean estado;

    public Ruta() {
    }

    public Ruta(String origen, String destino, long horas, long minutos, boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.duracion = Duration.ofHours(horas).plusMinutes(minutos);
        this.estado = estado;
    }    

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(long horas, long minutos) {
        this.duracion = Duration.ofHours(horas).plusMinutes(minutos);
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
        sb.append("Rutas{");
        sb.append("origen=").append(origen);
        sb.append(", destino=").append(destino);
        sb.append(", duracion=").append(duracion);
        sb.append('}');
        return sb.toString();
    }
    
    
}
