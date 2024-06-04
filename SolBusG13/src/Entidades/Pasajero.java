
package Entidades;


public class Pasajero {
    
    private int id_pasajero;
    private String nombre;
    private String apellido;
    private String dni;
    private String Correo;
    private String telefono;
    private boolean estado;

    public Pasajero() {
    }

    public Pasajero(String nombre, String apellido, String dni, String Correo, String telefono, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.Correo = Correo;
        this.telefono = telefono;
        this.estado = estado;
    }    

    public int getIdPasajero(){
        return id_pasajero;
    }
    
    public void setIdPasajero(int idPasajero){
        this.id_pasajero = idPasajero;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        sb.append("Pasajeros{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", dni=").append(dni);
        sb.append(", Correo=").append(Correo);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }
    
    
}
