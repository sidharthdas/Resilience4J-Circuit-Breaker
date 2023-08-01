package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("orders")
public class OrderServiceApplication {

	@GetMapping("/all-orders")
	public List<Order> getAllOrders() {
		return List.of(new Order("mouse", "ele", "1"),
				new Order("keyboard", "ele", "2"),
				new Order("tshirt", "cloth", "3"));
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}

 record Order(String orderName, String orderType, String orderAge){

}
