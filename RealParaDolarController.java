package com.test.projeto_sist_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealParaDolarController {

    @GetMapping("/realParaDolar/{valorEmReais}")
    public double converterParaDolar(@PathVariable double valorEmReais) {
        // Considerando uma taxa de câmbio fixa para este exemplo
        double taxaCambio = 5.20;
        double valorEmDolares = valorEmReais / taxaCambio;
        
        return valorEmDolares;
    }
}