package com.inventory.project.dao;

import java.util.List;
import com.inventory.project.model.Product;

public interface ProductDao {

    List<Product> getAll();

    Product getProductById(Long id);

    void save(Product product);

    void  delete(Product product);

}
