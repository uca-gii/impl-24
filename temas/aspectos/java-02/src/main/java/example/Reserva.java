package example;

public class Reserva {
    private String numeroVuelo;
    private String nombrePasajero;

    public Reserva(String numeroVuelo, String nombrePasajero) {
        this.numeroVuelo = numeroVuelo;
        this.nombrePasajero = nombrePasajero;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }
}
