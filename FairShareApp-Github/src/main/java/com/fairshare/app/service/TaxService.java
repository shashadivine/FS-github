package com.fairshare.app.service;

import com.fairshare.app.model.Tax;
import com.fairshare.app.repository.TaxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService {

    private final TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public Tax saveTax(Tax tax) {
        return taxRepository.save(tax);
    }

    public List<Tax> getAllTaxes() {
        return taxRepository.findAll();
    }
}
