package com.test.projeto_sist_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DolarParaRealController {

    @GetMapping("/dolarParaReal/{valorEmDolares}")
    public double converterParaReal(@PathVariable double valorEmDolares) {
        // Considerando uma taxa de câmbio fixa para este exemplo
        double taxaCambio = 5.20;
        double valorEmReais = valorEmDolares * taxaCambio;
        
        return valorEmReais;
    }
}
