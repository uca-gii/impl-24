package example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaReservaVuelosTest {

    @Before
    public void setup() {
        SistemaReservaVuelos.reset();
    }

    @Test
    public void testAgregarVueloExitosamente() {
        String resultado = SistemaReservaVuelos.agregarVuelo("AV123", 100);
        assertEquals("Vuelo AV123 agregado exitosamente con 100 asientos.", resultado);
    }

    @Test
    public void testAgregarVueloExistente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        String resultado = SistemaReservaVuelos.agregarVuelo("AV123", 100);
        assertEquals("El vuelo ya existe.", resultado);
    }

    @Test
    public void testAgregarVueloInvalido() {
        String resultado1 = SistemaReservaVuelos.agregarVuelo("", 100);
        assertEquals("Detalles del vuelo inválidos.", resultado1);

        String resultado2 = SistemaReservaVuelos.agregarVuelo("AV124", -5);
        assertEquals("Detalles del vuelo inválidos.", resultado2);
    }

    @Test
    public void testReservarVueloExitosamente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        String resultado = SistemaReservaVuelos.reservarVuelo("AV123", "Juan Perez");
        assertEquals("Reserva realizada exitosamente.", resultado);
    }

    @Test
    public void testReservarVueloNoExistente() {
        String resultado = SistemaReservaVuelos.reservarVuelo("AV999", "Juan Perez");
        assertEquals("Vuelo AV999 no encontrado.", resultado);
    }

    @Test
    public void testReservarVueloSinAsientosDisponibles() {
        SistemaReservaVuelos.agregarVuelo("AV123", 1);
        SistemaReservaVuelos.reservarVuelo("AV123", "Juan Perez");
        String resultado = SistemaReservaVuelos.reservarVuelo("AV123", "Maria Lopez");
        assertEquals("No hay asientos disponibles en el vuelo AV123.", resultado);
    }

    @Test
    public void testCancelarReservaExitosamente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        SistemaReservaVuelos.reservarVuelo("AV123", "Juan Perez");
        Reserva reserva = new Reserva("AV123", "Juan Perez");
        String resultado = SistemaReservaVuelos.cancelarReserva(reserva);
        assertEquals("Reserva cancelada exitosamente.", resultado);
    }

    @Test
    public void testCancelarReservaInexistente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        Reserva reserva = new Reserva("AV123", "Juan Perez");
        String resultado = SistemaReservaVuelos.cancelarReserva(reserva);
        assertEquals("No existe tal reserva.", resultado);
    }

    @Test
    public void testCancelarReservaVueloNoExistente() {
        Reserva reserva = new Reserva("AV999", "Juan Perez");
        String resultado = SistemaReservaVuelos.cancelarReserva(reserva);
        assertEquals("Vuelo no encontrado.", resultado);
    }

    @Test
    public void testEliminarVueloExitosamente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        String resultado = SistemaReservaVuelos.eliminarVuelo("AV123");
        assertEquals("Vuelo AV123 eliminado exitosamente.", resultado);
    }

    @Test
    public void testEliminarVueloConReservas() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        SistemaReservaVuelos.reservarVuelo("AV123", "Juan Perez");
        String resultado = SistemaReservaVuelos.eliminarVuelo("AV123");
        assertEquals("No se puede eliminar el vuelo con reservas activas.", resultado);
    }

    @Test
    public void testEliminarVueloNoExistente() {
        String resultado = SistemaReservaVuelos.eliminarVuelo("AV999");
        assertEquals("Vuelo no encontrado.", resultado);
    }
}
