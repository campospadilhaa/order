package com.campospadilha.order.services;

import org.springframework.stereotype.Service;

import com.campospadilha.order.entities.Order;

@Service
public class ShippingService {

	public double shipment(Order order) {

		double shipping = 0;

		if(order!=null && order.getBasic()!=null) {

			double basic = order.getBasic();

			if(basic < 100.00) {

				shipping = 20.00;

			}else if(basic < 200.00) {

				shipping = 12.00;
			}
		}

		return shipping;
	}
}