package com.shop.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productDetailId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
    private double productPrice;
    private int productQuantity;
    private String productStatus;
    @OneToOne(mappedBy = "productDetail", cascade = CascadeType.ALL)
    @JsonManagedReference
    private FirstGroupCriteria firstGroupCriteria;
    @OneToOne(mappedBy = "productDetail", cascade = CascadeType.ALL)
    @JsonManagedReference
    private SecondGroupCriteria secondGroupCriteria;

}
