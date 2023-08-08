package com.shop.service.impl;

import com.shop.exception.BusinessException;
import com.shop.model.product.*;
import com.shop.repository.product.*;
import com.shop.response.BaseResponse;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProductServiceImpl extends BaseResponse implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OriginRepository originRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public ResponseEntity<?> getAllProductListPage(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page,size);
            return getResponseEntity(productRepository.getAllProductListPage(pageable));
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getAllProductListPageByCategory(int page, int size, int id) {
        try {
            Pageable pageable = PageRequest.of(page,size);
            return getResponseEntity(productRepository.getAllProductListPageByCategory(pageable, id));
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> saveProduct(Product product) {
        try {
            productRepository.save(product);
            return getResponseEntity("Lưu thành công");
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> findByProductId(int id) {
        try {
            return getResponseEntity(productRepository.findByProductId(id));
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteProduct(int id) {
        try {
            Product product = productRepository.findByProductId(id);
            product.setHideId(0);
            productRepository.save(product);
            return getResponseEntity("Xoá thành công");
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> restoreProduct(int id) {
        try {
            Product product = productRepository.findByProductId(id);
            product.setHideId(1);
            productRepository.save(product);
            return getResponseEntity("Khôi phục thành công");
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> findProductDetailByProduct(int id) {
        try {
            Product product = productRepository.findByProductId(id);
            List<ProductDetail> productDetailList = product.getProductDetails();
            return getResponseEntity(productDetailList);
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> saveProductDetail(ProductDetailDto productDetailDto) {
        try {
            Product product = productRepository.findProductByProductName(productDetailDto.getProductName());
            ProductDetail productDetail = new ProductDetail();
            productDetail.setProductPrice(productDetailDto.getProductPrice());
            productDetail.setProductQuantity(productDetailDto.getProductQuantity());
            productDetail.setProductStatus(productDetailDto.getProductStatus());
//
            if(!productDetailDto.getFirstGroupCriteriaName().isEmpty()){
                FirstGroupCriteria firstGroupCriteria = new FirstGroupCriteria();
                firstGroupCriteria.setFirstGroupCriteriaName(productDetailDto.getFirstGroupCriteriaName());
                firstGroupCriteria.setFirstGroupCriteriaValue(productDetailDto.getFirstGroupCriteriaValue());
                productDetail.setFirstGroupCriteria(firstGroupCriteria);
                firstGroupCriteria.setProductDetail(productDetail);

            }
            if(!productDetailDto.getSecondGroupCriteriaName().isEmpty()){
                SecondGroupCriteria secondGroupCriteria = new SecondGroupCriteria();
                secondGroupCriteria.setSecondGroupCriteriaName(productDetailDto.getSecondGroupCriteriaName());
                secondGroupCriteria.setSecondGroupCriteriaValue(productDetailDto.getSecondGroupCriteriaValue());
                productDetail.setSecondGroupCriteria(secondGroupCriteria);
                secondGroupCriteria.setProductDetail(productDetail);

            }
            product.getProductDetails().add(productDetail);
            productDetail.setProduct(product);
            productDetailRepository.save(productDetail);



            return getResponseEntity("Lưu thành công");
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> findProductDetailByProductDetailId(int id) {
        try {
            return getResponseEntity(productDetailRepository.findProductDetailByProductDetailId(id));
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteProductDetail(int id) {
        try {
            ProductDetail productDetail = productDetailRepository.findProductDetailByProductDetailId(id);
            Product product = productDetail.getProduct();
            product.getProductDetails().remove(productDetail);
            productDetailRepository.delete(productDetail);
            productRepository.save(product);
            return getResponseEntity("Xoá thành công");
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getCategoryList() {
        try {
            return getResponseEntity(categoryRepository.findAll());
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getOriginList() {
        try {
            return getResponseEntity(originRepository.findAll());
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getBrandList() {
        try {
            return getResponseEntity(brandRepository.findAll());
        } catch (Exception e){
            throw new BusinessException(500, e.getMessage());
        }
    }



}
