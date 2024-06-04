package example;

import ch.qos.logback.classic.util.ContextInitializer;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path logPath = Paths.get("logs");
        if (Files.notExists(logPath)) {
            try {
                Files.createDirectories(logPath);
            } catch (IOException e) {
                System.err.println("No se pudo crear el directorio 'logs': " + e.getMessage());
            }
        }

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nBienvenido al Sistema de Reserva de Vuelos");
            System.out.println("------------------------------------------");
            System.out.println("¿Eres Administrador, Cliente, o deseas Salir? (Administrador/Cliente/Salir)");
            String tipoUsuario = scanner.nextLine().trim().toLowerCase();

            switch (tipoUsuario) {
                case "administrador":
                    Menus.menuAdministrador();
                    break;
                case "cliente":
                    Menus.menuCliente();
                    break;
                case "salir":
                    System.out.println("Gracias por usar el sistema. ¡Adiós!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Tipo de usuario inválido. Por favor ingrese 'Administrador', 'Cliente', o 'Salir'.");
            }
        }
        scanner.close();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            loggerContext.stop();
        }));
    }
}
