package com.test.projeto_sist_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ComprasController {
    @GetMapping("get/buy/united/{moeda}/{valorPago}/{valorCompra}")
    public String ComprarDolar(@PathVariable String moeda, @PathVariable double valorPago, @PathVariable double valorCompra) {
        if("real".equals(moeda)){
            RealParaDolarController realParaDolarController = new RealParaDolarController();
            valorPago = realParaDolarController.converterParaDolar(valorPago);
            if (valorPago < valorCompra) {
                return "Erro: O valor pago convertido deve ser maior ou igual ao valor da compra.";
            }
            CalcularTrocoDolarController calcularTrocoDolarController = new CalcularTrocoDolarController();
            String mensagem = calcularTrocoDolarController.calcularTrocoDolar(valorPago, valorCompra);
            return mensagem;
        } else if("dolar".equals(moeda)){
            CalcularTrocoDolarController calcularTrocoDolarController = new CalcularTrocoDolarController();
            String mensagem = calcularTrocoDolarController.calcularTrocoDolar(valorPago, valorCompra);
            return mensagem;
        } else {
            return "Erro";
        }
        
    }

    @GetMapping("get/buy/brazil/{moeda}/{valorPago}/{valorCompra}")
    public String ComprarReal(@PathVariable String moeda, @PathVariable double valorPago, @PathVariable double valorCompra) {
        if("dolar".equals(moeda)){
            DolarParaRealController dolarParaRealController = new DolarParaRealController();
            valorPago = dolarParaRealController.converterParaReal(valorPago);
            if (valorPago < valorCompra) {
                return "Erro: O valor pago convertido deve ser maior ou igual ao valor da compra.";
            }
            CalcularTrocoRealController calcularTrocoRealController = new CalcularTrocoRealController();
            String mensagem = calcularTrocoRealController.calcularTrocoReal(valorPago, valorCompra);
            return mensagem;
        } else if("real".equals(moeda)){
            CalcularTrocoRealController calcularTrocoRealController = new CalcularTrocoRealController();
            String mensagem = calcularTrocoRealController.calcularTrocoReal(valorPago, valorCompra);
            return mensagem;
        } else {
            return "Erro";
        }
        
    }
    
}
