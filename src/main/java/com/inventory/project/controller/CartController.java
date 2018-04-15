package com.inventory.project.controller;

import com.inventory.project.dao.CartDaoImpl;
import com.inventory.project.service.CartService;
import com.inventory.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.inventory.project.model.Product;
import com.inventory.project.model.Cart;

import java.util.Arrays;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private ProductService ps;
    @Autowired
    private CartService cs;

    @RequestMapping("cart")
    public void displayCart(@SessionAttribute("cart")Cart cartAtt, ModelMap model){
        int cartTotal =0;
        List<Product> pros = cartAtt.getProducts();
        for (Product pro:pros) {
            cartTotal+= pro.getProductQuantity()*pro.getProductPrice();
        }
        model.addAttribute("cartTotal",cartTotal);
        model.addAttribute("cart",cartAtt);
    }

    @RequestMapping("deleteFromCart")
    public String deleteFromCart(@SessionAttribute("cart")Cart cartAtt, @RequestParam Long id,ModelMap model){
        for(int i=0;i<cartAtt.getProducts().size();i++){
            if(cartAtt.getProducts().get(i).getId()==id){
                cartAtt.getProducts().remove(cartAtt.getProducts().get(i));
            }
        }
        int cartTotal=0;
        List<Product> pros = cartAtt.getProducts();
        for (Product pro:pros) {
            cartTotal+= pro.getProductQuantity()*pro.getProductPrice();
        }
        model.addAttribute("cartTotal",cartTotal);
        return "redirect:cart";
    }

    @RequestMapping("login")
    public String completeTransaction(@SessionAttribute("cart") Cart cartAtt, ModelMap modelMap){
        return "login";
    }

    @RequestMapping(value = "checkUser", method = RequestMethod.GET)
    public String checkUser(@SessionAttribute("cart") Cart cartAtt, @RequestParam String username, ModelMap modelMap){
        List<Product> cartProducts = cartAtt.getProducts();
//        System.out.println("~~~~~~~ ALL PRODUCTS IN YOUR CART:"+cartProducts.get(0).getProductQuantity()+cartProducts.get(1).getProductQuantity());
        for (int i =0; i<cartProducts.size();i++){
            Product productFromDB = ps.getProductById(cartProducts.get(i).getId());
            Product currentProduct = cartProducts.get(i);
            productFromDB.setProductQuantity(productFromDB.getProductQuantity() - currentProduct.getProductQuantity());
            ps.save(productFromDB);
        }

        Cart cart = new Cart();
        cart.setUsername(username);
        cart.setProducts(cartProducts);


        cs.saveToCart(cart);
//        cs.addAllItemsToCart(cartProducts);
        cartProducts.clear();
        return "redirect:";
    }
}