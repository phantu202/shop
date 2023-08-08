package com.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.product.Product;
import com.shop.model.product.ProductDetail;
import com.shop.model.product.ProductDetailDto;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/pro-api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/get-all-product-list-page")
    public ResponseEntity<?> getAllProductListPage(@RequestParam int page,
                                                   @RequestParam int size) {
        return productService.getAllProductListPage(page, size);
    }

    @GetMapping("/get-all-product-list-page-by-category")
    public ResponseEntity<?> getAllProductListPageByCategory(@RequestParam int page,
                                                             @RequestParam int size,
                                                             @RequestParam int id) {
        return productService.getAllProductListPageByCategory(page, size, id);
    }

    @PostMapping("/save-product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/delete-product")
    public ResponseEntity<?> deleteProduct(@RequestParam("id") int id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/restore-product")
    public ResponseEntity<?> restoreProduct(@RequestParam("id") int id) {
        return productService.restoreProduct(id);
    }

    @GetMapping("/find-product-by-id")
    public ResponseEntity<?> updateProduct(@RequestParam("id") int id) {

        return productService.findByProductId(id);
    }

    @GetMapping("/find-product-detail-by-product")
    public ResponseEntity<?> findProductDetailByProduct(@RequestParam("id") int id) {
        return productService.findProductDetailByProduct(id);
    }

    @PostMapping("/save-product-detail")
    public ResponseEntity<?> saveProductDetail(@RequestBody Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        ProductDetailDto productDetailDto = mapper.convertValue(map, ProductDetailDto.class);
        System.out.println(productDetailDto);
        return productService.saveProductDetail(productDetailDto);
    }
    @GetMapping("/find-product-detail-by-product-detail-id")
    public ResponseEntity<?> findProductDetailByProductDetailId(@RequestParam("id") int id){
        return productService.findProductDetailByProductDetailId(id);
    }
    @GetMapping("/delete-product-detail")
    public ResponseEntity<?> deleteProductDetail(@RequestParam("id") int id){
        return productService.deleteProductDetail(id);
    }
    @GetMapping("/get-category-list")
    public ResponseEntity<?> getCategoryList(){
        return productService.getCategoryList();
    }
    @GetMapping("/get-origin-list")
    public ResponseEntity<?> getOriginList(){
        return productService.getOriginList();
    }
    @GetMapping("/get-brand-list")
    public ResponseEntity<?> getBrandList(){
        return productService.getBrandList();
    }

}
