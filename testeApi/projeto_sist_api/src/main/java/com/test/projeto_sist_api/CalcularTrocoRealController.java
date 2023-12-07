package com.test.projeto_sist_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularTrocoRealController {

    @GetMapping("/calcularTrocoReal/{valorPago}/{valorCompra}")
    public String calcularTrocoReal(@PathVariable double valorPago, @PathVariable double valorCompra) {
        if (valorPago < valorCompra) {
            return "Erro: O valor pago deve ser maior ou igual ao valor da compra.";
        }
        double troco = valorPago - valorCompra;

        // Define os valores das cédulas e moedas
        double[] valores = {100, 50, 20, 10, 5, 2, 1, 0.5, 0.25, 0.1, 0.05, 0.01};
        
        // Inicializa um array para contar quantas vezes cada valor foi utilizado
        int[] quantidade = new int[valores.length];

        // Calcula o troco em cada cédula/moeda
        for (int i = 0; i < valores.length; i++) {
            quantidade[i] = (int) (troco / valores[i]);
            troco %= valores[i];
        }

        // Cria uma mensagem com o troco detalhado
        StringBuilder mensagem = new StringBuilder("Troco detalhado:\n");
        for (int i = 0; i < valores.length; i++) {
            if (quantidade[i] > 0) {
                mensagem.append(quantidade[i]).append(" ");
                mensagem.append(valores[i] >= 1 ? "cédula(s)" : "moeda(s)").append(" de R$");
                mensagem.append(valores[i]).append(";\n");
            }
        }

        return mensagem.toString();
    }
}
