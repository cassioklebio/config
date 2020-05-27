package com.facisa.atividade3.product.product.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Collections;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.facisa.atividade3.product.product.model.Product;
import com.facisa.atividade3.product.product.repository.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product find(final Integer id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.orElseThrow(null);
	}
	
	public Product save(Product product) {
        product.setCode( UUID.randomUUID().toString() );
        return productRepository.save(product);
    }
	
	public void delete(Integer id) {
		find(id);
		try {
			productRepository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um veiculo");
		}
	}

	



}
