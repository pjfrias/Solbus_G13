package Entidades;

public class Colectivo {
    private int id_colectivo;
    private String Matricula;
    private String Marca;
    private String Modelo;
    private int capacidad;
    private boolean estado;

    public Colectivo() {
    }

    public Colectivo(String Matricula, String Marca, String Modelo, int capacidad, boolean estado) {
        this.Matricula = Matricula;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.capacidad = capacidad;
        this.estado = estado;
        
    }    

    public Colectivo(int id_colectivo, String Matricula, String Marca, String Modelo, int capacidad, boolean estado) {
        this.id_colectivo = id_colectivo;
        this.Matricula = Matricula;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getId_colectivo() {
        return id_colectivo;
   }

    public void setId_colectivo(int id_colectivo) {
        this.id_colectivo = id_colectivo;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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
        sb.append("Colectivos{");
        sb.append("Matricula=").append(Matricula);
        sb.append(", Marca=").append(Marca);
        sb.append(", Modelo=").append(Modelo);
        sb.append(", capacidad=").append(capacidad);
        sb.append('}');
        return sb.toString();
    }

    public void setMatricula(int matExistente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
