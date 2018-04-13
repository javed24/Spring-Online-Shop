package com.inventory.project.service;

import com.inventory.project.model.Product;
import java.util.List;

public interface CartService {

    List<Product> getAllItems();

    void deleteItem(Product product);

    void addItemToCart(Product product);
}
