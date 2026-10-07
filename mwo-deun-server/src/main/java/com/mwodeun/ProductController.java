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
public class ProductController {

	private final ProductMapper productMapper;

	public ProductController(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@GetMapping("/api/products")
	public List<ProductVO> getProducts() {
		return productMapper.getProducts();
	}

	@PostMapping("/api/products")
	public ProductVO insertProduct(@RequestBody ProductVO product) {
		productMapper.insertProduct(product);
		return product;
	}

	@PutMapping("/api/products")
	public ProductVO updateProduct(@RequestBody ProductVO product) {
		productMapper.updateProduct(product);
		return product;
	}

	@DeleteMapping("/api/products")
	public void deleteProduct(@RequestParam int productId) {
		productMapper.deleteProduct(productId);
	}
}