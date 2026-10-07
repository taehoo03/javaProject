package com.mwodeun;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

	List<OrderVO> getOrders(int memberId);

	List<OrderVO> getReceivedOrders(int receiverId);

	void insertOrder(OrderVO order);

	OrderVO getOrder(int orderId);

	int getStock(int productId);

	void updateOrderStatus(OrderVO order);

	int decreaseStock(OrderVO order);

	void deleteOrder(int orderId);
}