package com.mwodeun;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

	List<CartVO> getCart(int memberId);

	void insertCart(CartVO cart);

	void updateCart(CartVO cart);

	void deleteCart(int cartId);
}