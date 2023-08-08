package com.shop.repository.product;

import com.shop.model.product.Origin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepository extends CrudRepository<Origin,Integer> {
}
