package com.inventory.project.service;

import com.inventory.project.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getProductById(Long id);

    void save(Product product);

    void  delete(Product product);
}
