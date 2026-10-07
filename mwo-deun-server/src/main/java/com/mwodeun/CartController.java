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
public class CartController {

	private final CartMapper cartMapper;

	public CartController(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}

	@GetMapping("/api/cart")
	public List<CartVO> getCart(@RequestParam int memberId) {
		return cartMapper.getCart(memberId);
	}

	@PostMapping("/api/cart")
	public CartVO insertCart(@RequestBody CartVO cart) {
		cartMapper.insertCart(cart);
		return cart;
	}

	@PutMapping("/api/cart")
	public CartVO updateCart(@RequestBody CartVO cart) {
		cartMapper.updateCart(cart);
		return cart;
	}

	@DeleteMapping("/api/cart")
	public void deleteCart(@RequestParam int cartId) {
		cartMapper.deleteCart(cartId);
	}
}