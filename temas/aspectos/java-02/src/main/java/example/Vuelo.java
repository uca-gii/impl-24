package example;

public class Vuelo {
    private String numeroVuelo;
    private int asientosDisponibles;

    public Vuelo(String numeroVuelo, int asientosDisponibles) {
        this.numeroVuelo = numeroVuelo;
        this.asientosDisponibles = asientosDisponibles;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }
}
