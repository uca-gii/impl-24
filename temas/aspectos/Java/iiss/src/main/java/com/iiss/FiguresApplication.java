package com.iiss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importing required classes
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FiguresApplication {

	public static void main(String[] args) {

		System.out.println("\nInyectamos una linea y un punto...\n");

		// Creating object of ApplicationContext
		// and Operation Class
		ApplicationContext context
			= new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		Line line = (Line)context.getBean("LBean");
		Point point = (Point)context.getBean("PBean");

		System.out.println("Hacemos movimientos de las figuras...");

		line.setP1(point);

		point.setX(5);
		point.setY(5);

		line.setP2(point);
	}

}
