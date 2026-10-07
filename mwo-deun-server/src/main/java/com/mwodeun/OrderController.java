package com.mwodeun;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

	private final OrderMapper orderMapper;

	public OrderController(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@GetMapping("/api/orders")
	public List<OrderVO> getOrders(@RequestParam int memberId) {
		return orderMapper.getOrders(memberId);
	}

	@GetMapping("/api/orders/received")
	public List<OrderVO> getReceivedOrders(
			@RequestParam int receiverId) {
		return orderMapper.getReceivedOrders(receiverId);
	}

	@PostMapping("/api/orders")
	public OrderVO insertOrder(@RequestBody OrderVO order) {

		int stock = orderMapper.getStock(order.getProductId());

		if (stock == 0) {
			throw new RuntimeException(
					"품절된 상품입니다."
			);
		}

		if (stock < order.getQuantity()) {
			throw new RuntimeException(
					"현재 재고가 " + stock + "개 남아있어 "
					+ order.getQuantity() + "개를 주문할 수 없습니다."
			);
		}

		int result = orderMapper.decreaseStock(order);

		if (result == 0) {
			throw new RuntimeException(
					"재고가 부족합니다."
			);
		}

		orderMapper.insertOrder(order);

		return order;
	}

	@PutMapping("/api/orders")
	public OrderVO updateOrderStatus(@RequestBody OrderVO order) {

		OrderVO currentOrder =
				orderMapper.getOrder(order.getOrderId());

		if (currentOrder == null) {
			return order;
		}

		orderMapper.updateOrderStatus(order);

		return order;
	}

	@DeleteMapping("/api/orders")
	public void deleteOrder(@RequestParam int orderId) {
		orderMapper.deleteOrder(orderId);
	}
}