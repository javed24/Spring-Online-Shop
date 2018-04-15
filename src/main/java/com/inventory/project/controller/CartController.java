package com.inventory.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.inventory.project.model.Product;
import com.inventory.project.model.Cart;

import java.util.Arrays;
import java.util.List;

@Controller
public class CartController {
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

}