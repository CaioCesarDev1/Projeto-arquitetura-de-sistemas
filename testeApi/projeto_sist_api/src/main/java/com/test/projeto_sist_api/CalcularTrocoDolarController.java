package com.test.projeto_sist_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularTrocoDolarController {


    @GetMapping("/calcularTrocoDolar/{valorPago}/{valorCompra}")
    public String calcularTrocoDolar(@PathVariable double valorPago, @PathVariable double valorCompra) {
        if (valorPago < valorCompra) {
            return "Erro: O valor pago deve ser maior ou igual ao valor da compra.";
        }

        double troco = valorPago - valorCompra;
        double[] valores = {100, 50, 20, 10, 5, 1, 0.25, 0.1, 0.05, 0.01};
        int[] quantidade = new int[valores.length];

        for (int i = 0; i < valores.length; i++) {
            quantidade[i] = (int) (troco / valores[i]);
            troco %= valores[i];
        }

        StringBuilder mensagem = new StringBuilder("Troco em cédulas/moedas dos EUA:\n");
        for (int i = 0; i < valores.length; i++) {
            if (quantidade[i] > 0) {
                mensagem.append(quantidade[i]).append(" ");
                mensagem.append(valores[i] >= 1 ? "cédula(s)" : "moeda(s)").append(" de ");
                mensagem.append("$").append(valores[i]).append(";\n");
            }
        }

        return mensagem.toString();
    }
}
