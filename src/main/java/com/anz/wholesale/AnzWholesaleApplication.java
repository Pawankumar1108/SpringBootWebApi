package com.anz.wholesale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.anz.wholesale.controller.ServiceController;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AnzWholesaleApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(ServiceController.class);
	public static void main(String[] args) {
		try {
		SpringApplication.run(AnzWholesaleApplication.class, args);
		System.out.println("MY Medics is online");
		    } catch (Throwable e) {
		        if(e.getClass().getName().contains("SilentExitException")) {
		            LOGGER.debug("Spring is restarting the main thread - See spring-boot-devtools");
		        } else {
		            LOGGER.error("Application crashed!", e);
		        }
		    }
	}

	
}
  