package com.example.flipDeal.Controller;
import com.example.flipDeal.Service.ProductService;
import com.example.flipDeal.dtos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/Api/v1/Product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/discount/{promotionStrategy}")
    public List<Product> applyPromotion(@PathVariable String promotionStrategy) throws IOException {
        return  productService.applyPromotion(promotionStrategy);
    }


}
