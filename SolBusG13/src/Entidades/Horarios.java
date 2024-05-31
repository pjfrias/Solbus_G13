
package Entidades;

import java.time.LocalTime;


public class Horarios {
    
    private LocalTime salida;
    private LocalTime llegada;
    private boolean estado;

    public Horarios() {
    }

    public Horarios(LocalTime salida, LocalTime llegada, boolean estado) {
        this.salida = salida;
        this.llegada = llegada;
        this.estado = estado;
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
