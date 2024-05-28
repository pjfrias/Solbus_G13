
package Entidades;


public class Colectivos {
    private String Matricula;
    private String Marca;
    private String Modelo;
    private int capacidad;

    public Colectivos() {
    }

    public Colectivos(String Matricula, String Marca, String Modelo, int capacidad) {
        this.Matricula = Matricula;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.capacidad = capacidad;
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
    
    
}
