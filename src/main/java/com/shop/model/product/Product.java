package com.shop.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name",nullable = false, unique = true)
    private String productName;
    @Column(name = "product_img")
    private String productImg;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "brand_id")
    private int brandId;
    @Column(name = "origin_id")
    private int originId;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_technical_specifications")
    private String productTechnicalSpecifications;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductDetail> productDetails = new ArrayList<>();
    private int hideId = 1;
}
