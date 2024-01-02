package com.example.storeutils.receiptproduct;

import com.example.storeutils.product.ProductEntity;
import com.example.storeutils.receipt.ReceiptEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "receipt_products")
public class ReceiptProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReceiptProductSequence")
    @SequenceGenerator(name = "ReceiptProductSequence", sequenceName = "receipt_product_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_receipt")
    private ReceiptEntity receipt;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReceiptEntity getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptEntity receipt) {
        this.receipt = receipt;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
