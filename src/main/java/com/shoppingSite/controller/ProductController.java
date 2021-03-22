package com.shoppingSite.controller;

import com.shoppingSite.Dto.ProductUpdateRequestDto;
import com.shoppingSite.model.Product;
import com.shoppingSite.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;



@Slf4j
@RestController
@RequestMapping
        (value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    //http://localhost:8080/product/add - To add new product into the DB
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addProduct(@RequestBody Product product) {
        try {
            productService.save(product);
            return true;
        } catch (Exception e) {
            log.info("error: {}", e);
        }
        return false;
    }

    //http://localhost:8080/product/delete - To delete some product from DB
    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public boolean deleteProduct(@RequestBody Product product) {
        try {
            productService.delete(product);
            return true;
        } catch (Exception e) {
            log.info("error: {}", e);
        }
        return false;
    }


    //http://localhost:8080/product/get - To fetch all the products from DB
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Product> getproducts(){
        try {
           return productService.getProducts();
            }catch(Exception e){
                log.info("error : {}", e );
            }
            return new ArrayList<Product>();
        }

}