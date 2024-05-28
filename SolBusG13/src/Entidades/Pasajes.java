
package Entidades;

import java.time.LocalDate;
import java.time.LocalTime;


public class Pasajes {
    private LocalDate fecha;
    private LocalTime hora;
    private int asiento;
    private double precio;

    public Pasajes() {
    }
    
    public Pasajes(LocalDate fecha, LocalTime hora, int asiento, double precio) {
        this.fecha = fecha;
        this.hora = hora;
        this.asiento = asiento;
        this.precio = precio;
    }  

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pasajes{");
        sb.append("fecha=").append(fecha);
        sb.append(", hora=").append(hora);
        sb.append(", asiento=").append(asiento);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }

    
    
}
