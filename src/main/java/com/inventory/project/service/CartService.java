package com.inventory.project.service;

import com.inventory.project.model.Cart;
import com.inventory.project.model.Product;
import java.util.List;

public interface CartService {

    List<Product> getAllItems();

    void deleteItem(Product product);

    void addItemToCart(Product product);
    void addAllItemsToCart(List<Product> allProducts);
    void saveToCart(Cart cart);
}
