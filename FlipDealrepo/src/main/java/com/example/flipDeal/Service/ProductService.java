package com.example.flipDeal.Service;

import com.example.flipDeal.Service.StrategyInterface.PromotionStrategy;
import com.example.flipDeal.client.FlipDealClient;
import com.example.flipDeal.dtos.Discount;
import com.example.flipDeal.dtos.Product;
import com.example.flipDeal.utils.Common;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private Map<String, PromotionStrategy> strategies;
    FlipDealClient flipdeal;

    public ProductService(Map<String, PromotionStrategy> strategies, FlipDealClient flipdeal) {
        this.strategies = strategies;
        this.flipdeal = flipdeal;
    }


    public List<Product> applyPromotion(String promotionType) throws IOException {
        List<Product> listofProducts = flipdeal.fetchProductDetails();
        Map<String, Object> fetchCurrency = flipdeal.fetchCurrencyChange();

        List<Product> updatedProduct = Common.ConvertToINR(listofProducts, fetchCurrency);
        for (Product product : updatedProduct) {
            Discount discount = fetchStrategy(promotionType).calculateDiscount(product);
            product.setDiscount(discount);
        }
        return updatedProduct;
    }

    private PromotionStrategy fetchStrategy(String promotionType) {
        PromotionStrategy promotionStrategy = strategies.get(promotionType);
        if (promotionStrategy == null) {
            throw new RuntimeException("Invalid type of promotion");
        }
        return promotionStrategy;

    }
}
