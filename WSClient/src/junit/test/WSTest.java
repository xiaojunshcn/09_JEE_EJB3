package junit.test;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.joe.ws.client.IOrderService;
import com.joe.ws.client.Order;
import com.joe.ws.client.OrderServiceBean;

public class WSTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void getUserName() {
		//get the service name from wsdl
		OrderServiceBean service = new OrderServiceBean();
		
		//get the portType from wsdl
		IOrderService orderService = service.getIOrderServicePort();
		
		System.out.println(orderService.getUserName("little joe"));
	}

	@Test
	public void getOrder() {
		//get the service name from wsdl
		OrderServiceBean service = new OrderServiceBean();
		
		//get the portType from wsdl
		IOrderService orderService = service.getIOrderServicePort();
		
		Order order = orderService.getOrder("999");
		System.out.println(order.getOrderId() + "," + order.getName());
	}
	
	@Test
	public void getOrders() {
		//get the service name from wsdl
		OrderServiceBean service = new OrderServiceBean();
		
		//get the portType from wsdl
		IOrderService orderService = service.getIOrderServicePort();
		
		List<Order> orders = orderService.getOrders();
		for(Order order:orders) {
			System.out.println(order.getOrderId() + "," + order.getName());
		}
	}
}
