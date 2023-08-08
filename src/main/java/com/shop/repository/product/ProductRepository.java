package com.shop.repository.product;

import com.shop.model.product.Product;
import com.shop.model.product.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    Product findByProductId(int productId);
    Product findProductByProductName(String productName);
    @Query(value = "select p.product_id, p.product_name, p.product_img, p.product_description,p.product_technical_specifications, c.category_name, o.origin_name, b.brand_name \n" +
            "from product p, category c, origin o, brand b \n" +
            "where p.category_id = c.category_id and p.hide_id=1 and p.origin_id=o.origin_id and p.brand_id=b.brand_id",nativeQuery = true)
    Page<Map<String,Object>> getAllProductListPage(Pageable pageable);
    @Query(value = "select p.product_id, p.product_name, p.product_img, p.product_description,p.product_technical_specifications, c.category_name, o.origin_name, b.brand_name \n" +
            "from product p, category c, origin o, brand b \n" +
            "where p.category_id = c.category_id and p.category_id = :id and p.hide_id=1 and p.origin_id=o.origin_id and p.brand_id=b.brand_id",nativeQuery = true)
    Page<Map<String,Object>> getAllProductListPageByCategory(Pageable pageable, @Param("id") int id);

}
