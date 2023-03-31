package com.iiss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importing required classes
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FiguresApplication {

	public static void main(String[] args) {
		//SpringApplication.run(FiguresApplication.class, args);

		// Creating object of ApplicationContext
		// and Operation Class
		ApplicationContext context
			= new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Line line = (Line)context.getBean("LBean");
		Point point = (Point)context.getBean("PBean");

		line.setP1(point);

		point.setX(5);
	}

}
