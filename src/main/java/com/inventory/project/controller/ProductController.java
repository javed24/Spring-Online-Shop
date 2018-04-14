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
        //System.out.print(">>>>>>>>"+products.get(2).getId());
        return "home";

    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productAtt") Product product,BindingResult result) {
        if (result.hasErrors()){
            return "home";
        }
        else {
            System.out.println("\n name is:>>>>>>>> " + product.getProductQuantity());
            ps.save(product);
            System.out.println("id is: "+ product.getId());
            return "redirect:";
        }

    }
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam Long id){
        Product product = ps.getProductById(id);
        ps.delete(product);
        return "redirect:";
    }

    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String editProduct(@RequestParam Long id, ModelMap modelMap){
        Product product = ps.getProductById(id);
        modelMap.put("product", product);
        return "edit";
    }


    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product,BindingResult result) {
        if (result.hasErrors()){
            return "edit";
        }
        else {
            System.out.println("name is:>>>>>>>> " + product.getProductName());
            ps.save(product);
            return "redirect:";
        }

    }
}