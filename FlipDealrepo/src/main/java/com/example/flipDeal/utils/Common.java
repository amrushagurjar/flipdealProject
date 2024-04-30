package com.example.flipDeal.utils;

import com.example.flipDeal.dtos.Product;

import java.util.List;
import java.util.Map;

public class Common {
    public static List<Product> ConvertToINR(List<Product> products, Map<String, Object> currencyExchange) {
        for (Product product : products) {
            if (!product.getCurrency().equals("INR")) {
                double newPrice = product.getPrice() * (double) currencyExchange.get((product.getCurrency()));
                product.setPrice((int)newPrice);
            }

        }
    return products;
    }
}
