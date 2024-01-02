package com.example.storeutils.product;

public interface IProductService {

    Iterable<ProductEntity> getAllProducts();

    ProductEntity getProduct(Long id);
    ProductEntity update(ProductEntity productEntity);

    ProductEntity create(ProductEntity productEntity);

    void delete(Long productId);

}
