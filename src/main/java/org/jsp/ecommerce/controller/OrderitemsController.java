package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderItems")
public class OrderitemsController {
	
	@Autowired
	private OrderItemsService service;

}
