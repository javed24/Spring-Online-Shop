package com.inventory.project.dao;

import java.util.List;
import com.inventory.project.model.Cart;
import com.inventory.project.model.Product;

public interface CartDao {
    List<Product> getAllItems();
    void deleteItem(Product product);
    void addItemToCart(Product product);
}
