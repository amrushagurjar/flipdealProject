package com.example.flipDeal.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product {

    private String category;
    private int inventory;
    private int rating;
    private String currency;
    private int price;
    private String origin;
    private String product;
    private String arrival;
    private Discount discount;

}
