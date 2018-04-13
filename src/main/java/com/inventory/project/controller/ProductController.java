package com.inventory.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.inventory.project.model.Product;
import com.inventory.project.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService ps;


    @RequestMapping("/")
    public String listProducts(ModelMap model){
        List<Product> products = ps.getAll();
        model.addAttribute("products", products);
        model.addAttribute("productAtt", new Product());
        System.out.print(">>>>>>>>"+products.get(0).getProductName());
        return "home";

    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productAtt") Product product,BindingResult result) {
        if (result.hasErrors()){
            return "home";
        }
        else {
            System.out.println("name is:>>>>>>>> " + product.getProductName());
            //ps.save(product);
            return "redirect:";
        }

    }

}