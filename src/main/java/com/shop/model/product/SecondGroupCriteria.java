package com.shop.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SecondGroupCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int secondGroupCriteriaId;
    private String secondGroupCriteriaName;
    private String secondGroupCriteriaValue ="1";
    @OneToOne
    @JoinColumn(name = "product_detail_id")
    @JsonBackReference
    private ProductDetail productDetail;
}
