package com.user;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("user")
public class UserServiceApplication {

	@Lazy
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("all-orders")
	@CircuitBreaker(name = "userService", fallbackMethod = "getDefault")
	public List<Object> getAllOrders() {
		System.out.println("test");
		return restTemplate.getForObject("http://localhost:8011/orders/all-orders", ArrayList.class);
	}

	public List<Object> getDefault(Exception e) {

		System.out.println(e.getMessage());
		return List.of("Fall Back method Data");
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
