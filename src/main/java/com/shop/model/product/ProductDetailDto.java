package com.shop.model.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailDto {
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String productStatus;
    private String firstGroupCriteriaName;
    private String firstGroupCriteriaValue;
    private String secondGroupCriteriaName;
    private String secondGroupCriteriaValue;
}
