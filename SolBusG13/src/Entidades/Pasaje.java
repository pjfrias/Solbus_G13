package Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pasaje{
    private int idPasaje;
    private Pasajero pasajero;
    private Colectivo colectivo;
    private Ruta rutas;
    private LocalDate fechaViaje;
    private LocalTime horaViaje;
    private int asiento;
    private double precio;
    private boolean estado;

    public Pasaje() {
    }
    
    public Pasaje(int idPasaje, Pasajero pasajero, Colectivo colectivo, Ruta rutas, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio, boolean estado) {
        this.idPasaje = idPasaje;
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.rutas = rutas;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
        this.estado = estado;
    }

    public Pasaje(Pasajero pasajero, Colectivo colectivo, Ruta rutas, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio, boolean estado) {
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.rutas = rutas;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public Ruta getRutas() {
        return rutas;
    }

    public void setRutas(Ruta rutas) {
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
