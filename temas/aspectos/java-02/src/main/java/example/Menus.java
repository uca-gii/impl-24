package example;

import java.util.Scanner;

public class Menus {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuAdministrador() {
        boolean enFuncionamiento = true;
        while (enFuncionamiento) {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Agregar un Vuelo");
            System.out.println("2. Eliminar un Vuelo");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el Número del Vuelo:");
                    String numeroVuelo = scanner.nextLine();
                    System.out.println("Ingrese el número de asientos:");
                    int asientos = -1;
                    try {
                        asientos = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Número de asientos inválido. Por favor ingrese un número positivo.");
                    }
                    if (asientos >= 0) {
                        String resultado = SistemaReservaVuelos.agregarVuelo(numeroVuelo, asientos);
                        System.out.println(resultado);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el Número del Vuelo a eliminar:");
                    numeroVuelo = scanner.nextLine();
                    String eliminacion = SistemaReservaVuelos.eliminarVuelo(numeroVuelo);
                    System.out.println(eliminacion);
                    break;
                case 3:
                    System.out.println("Saliendo del menú administrador.");
                    enFuncionamiento = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor ingrese un número del 1 al 3.");
            }
        }
    }

    public static void menuCliente() {
        boolean enFuncionamiento = true;
        while (enFuncionamiento) {
            System.out.println("\n--- Menú Cliente ---");
            System.out.println("1. Reservar un Vuelo");
            System.out.println("2. Cancelar una Reserva");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
    
            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
    
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el Número del Vuelo para reservar:");
                    String numeroVuelo = scanner.nextLine();
                    System.out.println("Ingrese el Nombre del Pasajero:");
                    String nombrePasajero = scanner.nextLine();
                    String resultadoReserva = SistemaReservaVuelos.reservarVuelo(numeroVuelo, nombrePasajero);
                    System.out.println(resultadoReserva);
                    break;
                case 2:
                    System.out.println("Ingrese el Número del Vuelo para cancelar la reserva:");
                    numeroVuelo = scanner.nextLine();
                    System.out.println("Ingrese el Nombre del Pasajero:");
                    nombrePasajero = scanner.nextLine();
                    String resultadoCancelacion = SistemaReservaVuelos.cancelarReserva(new Reserva(numeroVuelo, nombrePasajero));
                    System.out.println(resultadoCancelacion);
                    break;
                case 3:
                    System.out.println("Saliendo del menú cliente.");
                    enFuncionamiento = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
        }
    }
}
