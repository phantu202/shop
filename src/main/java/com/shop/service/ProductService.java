package com.shop.service;

import com.shop.model.product.Product;
import com.shop.model.product.ProductDetail;
import com.shop.model.product.ProductDetailDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> getAllProductListPage(int page, int size);
    ResponseEntity<?> getAllProductListPageByCategory(int page, int size, int id);
    ResponseEntity<?> saveProduct(Product product);
    ResponseEntity<?> findByProductId(int id);
    ResponseEntity<?> deleteProduct(int id);
    ResponseEntity<?> restoreProduct(int id);
    ResponseEntity<?> findProductDetailByProduct(int id);
    ResponseEntity<?> saveProductDetail(ProductDetailDto productDetailDto);
    ResponseEntity<?> findProductDetailByProductDetailId(int id);
    ResponseEntity<?> deleteProductDetail(int id);
    ResponseEntity<?> getCategoryList();
    ResponseEntity<?> getOriginList();
    ResponseEntity<?> getBrandList();

}
