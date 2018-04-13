package com.inventory.project.controller;

import com.inventory.project.model.Product;
import com.inventory.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.inventory.project.dao.ProductDao;
import com.inventory.project.model.Product;
import com.inventory.project.service.CartService;
import com.inventory.project.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService ps;

    @RequestMapping("/")
    public String listProducts(ModelMap modelMap){
        List<Product> products = new ArrayList<>();
        products = ps.getAll();
        modelMap.addAttribute("products", products);
        System.out.print(">>>>>>>>>"+products.get(0).getProductname());
        return "home";
    }
}