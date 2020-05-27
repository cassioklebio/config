package com.facisa.atividade3.product.product.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facisa.atividade3.product.product.model.Product;
import com.facisa.atividade3.product.product.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
    private ProductService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.find(id));
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> save(@RequestBody  Product product){
        return ResponseEntity.ok(service.save(product));
    }

	 
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		 	service.delete(id);
	        return ResponseEntity.ok().build();
	    }

}
