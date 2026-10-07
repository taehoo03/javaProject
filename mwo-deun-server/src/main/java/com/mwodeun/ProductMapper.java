package com.mwodeun;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

	List<ProductVO> getProducts();

	void insertProduct(ProductVO product);

	void updateProduct(ProductVO product);

	void deleteProduct(int productId);
}