package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		// This returns an application context
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		// Ask context for an instance of my controller
		// "Spring, from the context please provide me with an instance of this Bean"
		// This is one of the fundamentals of dependency injection ; having the framework do the management of it
		MyController myController = (MyController) ctx.getBean("myController");

		// Important : notice that we never created the controller object i.e never did New MyController()
		// Spring is doing that for us
		// Under the cover Spring is creating that inside the Spring Context
		System.out.println("--------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("--------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("--------- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		// Spring Profiles example
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());
	}

}
