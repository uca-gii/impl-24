package example;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // Pointcut para agregar vuelo
    @Pointcut("execution(* example.SistemaReservaVuelos.agregarVuelo(String, int)) && args(codigo, asientos)")
    public void addFlight(String codigo, int asientos) {}

    // AfterReturning advice para agregar vuelo
    @AfterReturning(pointcut = "addFlight(codigo, asientos)", returning = "result")
    public void afterAddFlight(String codigo, int asientos, String result) {
        if (result.startsWith("Vuelo ")) {
            logger.info("El Admin ha añadido el vuelo {} con {} asientos", codigo, asientos);
        } else {
            logger.warn("Intento fallido de agregar vuelo {}: {}", codigo, result);
        }
    }

    // Pointcut para reservar vuelo
    @Pointcut("execution(* example.SistemaReservaVuelos.reservarVuelo(String, String)) && args(numeroVuelo, nombrePasajero)")
    public void reserveFlight(String numeroVuelo, String nombrePasajero) {}

    // AfterReturning advice para reservar vuelo
    @AfterReturning(pointcut = "reserveFlight(numeroVuelo, nombrePasajero)", returning = "result")
    public void afterReserveFlight(String numeroVuelo, String nombrePasajero, String result) {
        if (result.equals("Reserva realizada exitosamente.")) {
            logger.info("El pasajero {} ha reservado el vuelo {}", nombrePasajero, numeroVuelo);
        } else {
            logger.warn("Intento fallido de {} de reservar vuelo: {}", nombrePasajero, result);
        }
    }

    // Pointcut para cancelar reserva
    @Pointcut("execution(* example.SistemaReservaVuelos.cancelarReserva(example.Reserva)) && args(reserva)")
    public void cancelReservation(Reserva reserva) {}

    // AfterReturning advice para cancelar reserva
    @AfterReturning(pointcut = "cancelReservation(reserva)", returning = "result")
    public void afterCancelReservation(Reserva reserva, String result) {
        if (result.equals("Reserva cancelada exitosamente.")) {
            logger.info("La reserva del pasajero {} para el vuelo {} ha sido cancelada", reserva.getNombrePasajero(), reserva.getNumeroVuelo());
        } else {
            logger.warn("Intento fallido de de cancelar reserva: {}", result);
        }
    }

    // Pointcut para eliminar vuelo
    @Pointcut("execution(* example.SistemaReservaVuelos.eliminarVuelo(String)) && args(numeroVuelo)")
    public void deleteFlight(String numeroVuelo) {}

    // AfterReturning advice para eliminar vuelo
    @AfterReturning(pointcut = "deleteFlight(numeroVuelo)", returning = "result")
    public void afterDeleteFlight(String numeroVuelo, String result) {
        if (result.equals("Vuelo " + numeroVuelo + " eliminado exitosamente.")) {
            logger.info("El vuelo {} ha sido eliminado", numeroVuelo);
        } else {
            logger.warn("Intento fallido de eliminar vuelo: {}", result);
        }
    }

    // Pointcut para login de administrador
    @Pointcut("execution(* example.Menus.menuAdministrador())")
    public void loginAdmin() {}

    @Before("loginAdmin()")
    public void beforeloginAdmin() {
        logger.info("El Admin ha iniciado sesión");
    }

    @After("loginAdmin()")
    public void afterloginAdmin() {
        logger.info("El Admin ha cerrado sesión");
    }

    // Pointcut para login de cliente
    @Pointcut("execution(* example.Menus.menuCliente())")
    public void loginClient() {}

    @Before("loginClient()")
    public void beforeloginClient() {
        logger.info("El Cliente ha iniciado sesión");
    }

    @After("loginClient()")
    public void afterloginClient() {
        logger.info("El Cliente ha cerrado sesión");
    }
}
