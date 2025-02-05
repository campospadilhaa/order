package com.campospadilha.order;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.campospadilha.order.entities.Order;
import com.campospadilha.order.services.OrderService;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("-----------------------\n");

		System.out.print("Código do pedido: ");
		Integer code = sc.nextInt();

		System.out.print("Valor básico: ");
		Double basic = sc.nextDouble();

		System.out.print("Porcentagem de desconto: ");
		Double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		Double total = orderService.total(order);

		System.out.print("-----------------------\n");

		String saida = "Pedido código: " + code + "\n" +
				       "Valor total: R$ " + total;

		System.out.println(saida);

		sc.close();
	}
}