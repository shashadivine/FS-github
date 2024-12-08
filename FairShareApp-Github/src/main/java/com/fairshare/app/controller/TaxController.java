package com.fairshare.app.controller;

import com.fairshare.app.model.Tax;
import com.fairshare.app.service.TaxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxes")
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping
    public ResponseEntity<Tax> createTax(@RequestBody Tax tax) {
        return ResponseEntity.ok(taxService.saveTax(tax));
    }

    @GetMapping
    public ResponseEntity<List<Tax>> getAllTaxes() {
        return ResponseEntity.ok(taxService.getAllTaxes());
    }
}
