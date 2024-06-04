package example;

import java.util.HashMap;
import java.util.Map;

public class SistemaReservaVuelos {

    private static final Map<String, Vuelo> vuelos = new HashMap<>();
    private static final Map<String, Integer> asientosOriginales = new HashMap<>();
    private static final Map<String, Map<String, Reserva>> reservas = new HashMap<>();

    public static void reset() {
        vuelos.clear();
        asientosOriginales.clear();
        reservas.clear();
    }

    public static String agregarVuelo(String numeroVuelo, int asientosDisponibles) {
        if (numeroVuelo == null || numeroVuelo.isEmpty() || asientosDisponibles < 0) {
            return "Detalles del vuelo inválidos.";
        } else if (vuelos.containsKey(numeroVuelo)) {
            return "El vuelo ya existe.";
        } else {
            Vuelo vuelo = new Vuelo(numeroVuelo, asientosDisponibles);
            vuelos.put(numeroVuelo, vuelo);
            asientosOriginales.put(numeroVuelo, asientosDisponibles);
            return "Vuelo " + numeroVuelo + " agregado exitosamente con " + asientosDisponibles + " asientos.";
        }
    }

    public static String reservarVuelo(String numeroVuelo, String nombrePasajero) {
        Vuelo vuelo = vuelos.get(numeroVuelo);
        if (vuelo == null) {
            return "Vuelo " + numeroVuelo + " no encontrado.";
        } else if (vuelo.getAsientosDisponibles() > 0) {
            Map<String, Reserva> reservasVuelo = reservas.computeIfAbsent(numeroVuelo, k -> new HashMap<>());
            if (reservasVuelo.containsKey(nombrePasajero)) {
                return "Ya existe una reserva para este pasajero.";
            } else {
                Reserva nuevaReserva = new Reserva(numeroVuelo, nombrePasajero);
                reservasVuelo.put(nombrePasajero, nuevaReserva);
                vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() - 1);
                return "Reserva realizada exitosamente.";
            }
        } else {
            return "No hay asientos disponibles en el vuelo " + numeroVuelo + ".";
        }
    }

    public static String cancelarReserva(Reserva reserva) {
        if (reserva.getNumeroVuelo().isEmpty() || reserva.getNombrePasajero().isEmpty()) {
            return "Detalles de la reserva inválidos.";
        }
        Vuelo vuelo = vuelos.get(reserva.getNumeroVuelo());
        if (vuelo == null) {
            return "Vuelo no encontrado.";
        } else {
            Map<String, Reserva> reservasVuelo = reservas.get(reserva.getNumeroVuelo());
            if (reservasVuelo != null && reservasVuelo.remove(reserva.getNombrePasajero()) != null) {
                vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() + 1);
                return "Reserva cancelada exitosamente.";
            } else {
                return "No existe tal reserva.";
            }
        }
    }

    public static String eliminarVuelo(String numeroVuelo) {
        Vuelo vuelo = vuelos.get(numeroVuelo);
        if (vuelo == null) {
            return "Vuelo no encontrado.";
        } else if (vuelo.getAsientosDisponibles() == asientosOriginales.getOrDefault(numeroVuelo, 0)) {
            vuelos.remove(numeroVuelo);
            asientosOriginales.remove(numeroVuelo);
            reservas.remove(numeroVuelo);
            return "Vuelo " + numeroVuelo + " eliminado exitosamente.";
        } else {
            return "No se puede eliminar el vuelo con reservas activas.";
        }
    }
}
