
package Entidades;

import java.time.Duration;


public class Rutas {
    private String origen;
    private String destino;
    private Duration duracion;

    public Rutas() {
    }

    public Rutas(String origen, String destino, Duration duracion) {
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
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

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
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
