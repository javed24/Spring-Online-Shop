package com.inventory.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventory.project.dao.ProductDao;
import com.inventory.project.model.Product;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao pd;

    @Override
    public List<Product> getAll() {
        return pd.getAll();
    }

    @Override
    public Product getProductById(Long id) {
        return pd.getProductById(id);
    }

    @Override
    public void save(Product product) {
        pd.save(product);
    }

    @Override
    public void delete(Product product) {
        pd.delete(product);
    }
}