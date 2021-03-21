package com.shoppingSite;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.shoppingSite.repository")
public class ShoppingSiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingSiteApplication.class, args);
	}
}