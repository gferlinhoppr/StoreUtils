package com.example.storeutils.receipt;

import java.util.List;

public interface IReceiptService {

    ReceiptEntity getReceipt(Long id);

    ReceiptEntity saveReceipt(ReceiptEntity receiptDto);

}
