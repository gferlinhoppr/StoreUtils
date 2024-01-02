package com.example.storeutils.receipt;

import com.example.storeutils.receiptproduct.ReceiptProductsEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "receipt")
public class ReceiptEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceReceiptId")
    @SequenceGenerator(name = "SequenceReceiptId", sequenceName = "receipt_sequence", allocationSize = 1 )
    private Long id;

    @OneToMany(mappedBy = "receipt", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<ReceiptProductsEntity> receiptProducts;

    @Column(name = "edition_date")
    private LocalDateTime editionDate;

    @Column(name = "total_price")
    private double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ReceiptProductsEntity> getReceiptProducts() {
        return receiptProducts;
    }

    public void setReceiptProducts(List<ReceiptProductsEntity> receiptProducts) {
        this.receiptProducts = receiptProducts;
    }

    public LocalDateTime getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(LocalDateTime editionDate) {
        this.editionDate = editionDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
