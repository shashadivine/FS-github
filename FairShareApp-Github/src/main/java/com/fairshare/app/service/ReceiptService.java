package com.fairshare.app.service;

import com.fairshare.app.model.Receipt;
import com.fairshare.app.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public Receipt createReceipt() {
        Receipt receipt = new Receipt();
        return receiptRepository.save(receipt);
    }
}
