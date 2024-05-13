package main.java;

import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Order order1 = new Order(1, LocalDate.now(), 500.00);
        Order order2 = new Order(2, LocalDate.now().minusDays(1), 1500.00);

        // Inyectar dependencias
        DependencyInjector.inject(order1);
        DependencyInjector.inject(order2);

        // Comparación de pedidos
        System.out.println("Comparando por fecha: " + order1.compareTo(order2));
        System.out.println("Comparando por cantidad: " + order1.compareToAmount(order2)); 
    }
}
