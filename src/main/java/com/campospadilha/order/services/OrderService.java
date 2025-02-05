package com.campospadilha.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campospadilha.order.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;

	public double total(Order order) {

		Double shipping = shippingService.shipment(order);

		Double total = order.getBasic() - ((order.getBasic() * order.getDiscount()) / 100);

		return total + shipping;
	}
}