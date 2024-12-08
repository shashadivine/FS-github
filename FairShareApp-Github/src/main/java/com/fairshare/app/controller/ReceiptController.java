package com.fairshare.app.controller;

import com.fairshare.app.model.Receipt;
import com.fairshare.app.service.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/create")
    public ResponseEntity<Receipt> createReceipt() {
        return ResponseEntity.ok(receiptService.createReceipt());
    }
}
