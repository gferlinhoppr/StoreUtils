package com.example.storeutils.receipt;

import com.example.storeutils.product.IProductService;
import com.example.storeutils.product.ProductEntity;
import com.example.storeutils.product.ProductRepository;
import com.example.storeutils.receiptproduct.ReceiptProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements IReceiptService{

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ReceiptEntity getReceipt(Long id) {
        return  receiptRepository.findById(id).get();
    }

    @Override
    public ReceiptEntity saveReceipt(ReceiptEntity receiptEntity) {
        double price = 0;
        for(ReceiptProductsEntity receiptProduct : receiptEntity.getReceiptProducts()){

            ProductEntity product = productRepository.findById(receiptProduct.getProduct().getId()).get();
            double priceProduct = product.getPrice() * receiptProduct.getQuantity();
            receiptProduct.setPrice(priceProduct);
            price += priceProduct;
            receiptProduct.setReceipt(receiptEntity);
        }

        receiptEntity.setTotalPrice(price);

        return receiptRepository.save(receiptEntity);
    }

}
