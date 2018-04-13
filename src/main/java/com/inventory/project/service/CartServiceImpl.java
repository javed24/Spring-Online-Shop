package com.inventory.project.service;

import com.inventory.project.dao.CartDao;
import com.inventory.project.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cd;

    @Override
    public List<Product> getAllItems() {
        return cd.getAllItems();
    }

    @Override
    public void deleteItem(Product product) {
        cd.deleteItem(product);
    }

    @Override
    public void addItemToCart(Product product) {
        cd.addItemToCart(product);
    }
}