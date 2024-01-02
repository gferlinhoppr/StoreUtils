package com.example.storeutils.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final IProductService productService;

    private final ProductRepository productRepository;

    public ProductController(IProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/getAllProducts")
    public Iterable<ProductEntity> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping(value = "/getProduct/{id}")
    public ProductEntity getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @PostMapping(value = "/createProduct")
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity product){

        return ResponseEntity.ok(productService.create(product));
    }

    @PutMapping(value = "/updateProduct")
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity product){
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping(value = "/deleteProduct/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        productService.delete(productId);
        return ResponseEntity.ok().build();
    }
}
