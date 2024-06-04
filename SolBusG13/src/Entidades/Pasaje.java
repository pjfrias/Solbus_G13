package Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pasaje{
    private int idPasaje;
    private Pasajeros pasajero;
    private Colectivos colectivo;
    private Rutas rutas;
    private LocalDate fechaViaje;
    private LocalTime horaViaje;
    private int asiento;
    private double precio;

    public Pasaje(int idPasaje, Pasajeros pasajero, Colectivos colectivo, Rutas rutas, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio) {
        this.idPasaje = idPasaje;
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.rutas = rutas;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public Pasaje(Pasajeros pasajero, Colectivos colectivo, Rutas rutas, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio) {
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.rutas = rutas;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public Pasajeros getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajeros pasajero) {
        this.pasajero = pasajero;
    }

    public Colectivos getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivos colectivo) {
        this.colectivo = colectivo;
    }

    public Rutas getRutas() {
        return rutas;
    }

    public void setRutas(Rutas rutas) {
        this.rutas = rutas;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public LocalTime getHoraViaje() {
        return horaViaje;
    }

    public void setHoraViaje(LocalTime horaViaje) {
        this.horaViaje = horaViaje;
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
        sb.append("fecha=").append(fechaViaje);
        sb.append(", hora=").append(horaViaje);
        sb.append(", asiento=").append(asiento);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
    
}
