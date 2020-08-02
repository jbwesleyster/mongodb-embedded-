package com.example.ambev.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ambev.exception.ResourceNotFoundException;
import com.example.ambev.model.Product;
import com.example.ambev.repository.ProductRepository;
import com.example.ambev.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return this.productRepository.insert(product);
	}

	@Override
	public void delete(String id) {
		verificaObjExiste(id);
		this.productRepository.deleteById(id);
	}

	@Override
	public Product update(String id, Product product) {

		verificaObjExiste(id);
		product.setId(id);
		return this.productRepository.save(product);
	}

	@Override
	public List<Product> getProductByName(String name) {
		return this.productRepository.findByName(name)
				.stream()
				.sorted(Comparator.comparing(Product::getName))
				.collect(Collectors.toList());
	}

	@Override
	public Product getProductById(String id) {
		return this.productRepository.findById(id).orElse(null);
	}

	/**
	 * VERIFICA SE OBJ EXISTE NO DB ANTES DE ATUALIZAR
	 * @param id
	 */
	private void verificaObjExiste(String id) {
		this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

}
