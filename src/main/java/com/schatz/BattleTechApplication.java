package com.schatz;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@SpringBootApplication
@ComponentScan(basePackages = { "com.schatz" })
public class BattleTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(BattleTechApplication.class, args);
	}
}
