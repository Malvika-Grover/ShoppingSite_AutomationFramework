package com.shoppingSite.controller;

import com.shoppingSite.Dto.ProductUpdateRequestDto;
import com.shoppingSite.model.Product;
import com.shoppingSite.service.ProductService;
import com.shoppingSite.service.UserService;
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

    UserService userService;

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
    public boolean deleteProduct(@RequestParam("id") Long id ) {
        try {
            productService.delete(id);
            return true;
        } catch (Exception e) {
            log.info("error: {}", e);
        }
        return false;
    }

    //http://localhost:8080/product/update - To update some product(quantity) in DB
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean updateProduct(@RequestBody ProductUpdateRequestDto productRequest){
        try {
            productService.update(productRequest);
            return true;
        }catch (Exception e){
            log.info("error : {}",e );
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