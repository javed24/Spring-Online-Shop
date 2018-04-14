package com.inventory.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.inventory.project.model.Product;
import com.inventory.project.model.Cart;

@Controller
public class CartController {
    @RequestMapping("cart")
    public void displayCart(@SessionAttribute("cart")Cart cartAtt, ModelMap model){
        String name = cartAtt.getProducts().get(0).getProductName();
        model.addAttribute("cart",cartAtt);
        System.out.println("inside display cart>>>"+name);
    }

}