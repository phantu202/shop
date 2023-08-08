package com.shop.repository.product;

import com.shop.model.product.Product;
import com.shop.model.product.ProductDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductDetailRepository extends CrudRepository<ProductDetail,Integer> {
    ProductDetail findProductDetailByProductDetailId(int id);

}
