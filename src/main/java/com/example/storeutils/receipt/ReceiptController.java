package com.example.storeutils.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceiptController {
    @Autowired
    private IReceiptService receiptService;

    @Autowired
    private ReceiptRepository receiptRepository;


    @GetMapping("/getAllReceipts")
    public ResponseEntity<Iterable<ReceiptEntity>> getReceipts(){
        return ResponseEntity.ok(receiptRepository.findAll());
    }

    @GetMapping("/getReceipt/{id}")
    public ResponseEntity<ReceiptEntity> getReceipt(@PathVariable Long id){
        return ResponseEntity.ok(receiptService.getReceipt(id));
    }

    @PostMapping("/createReceipt")
    public ResponseEntity<ReceiptEntity> createReceipt(@RequestBody ReceiptEntity receiptEntity){
        return ResponseEntity.ok(receiptService.saveReceipt(receiptEntity));
    }

    @DeleteMapping("/deleteReceipt/{receiptId}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable Long receiptId) {
        receiptRepository.deleteById(receiptId);
        return ResponseEntity.ok().build();
    }

}
