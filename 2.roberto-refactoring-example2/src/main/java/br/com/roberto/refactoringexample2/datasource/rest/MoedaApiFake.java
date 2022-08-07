package br.com.roberto.refactoringexample2.datasource.rest;

import br.com.roberto.refactoringexample2.repositories.MoedaApi;

public class MoedaApiFake implements MoedaApi {

    private static final double COTACAO_REAL = 1;
    private static final double COTACAO_DOLAR = 5;
    @Override
    public double converter(double valor, String moeda) {
        if (moeda.equals("BRL")){
            return valor * COTACAO_REAL;
        }
        else if (moeda.equals("USD")) {
            return valor * COTACAO_DOLAR;
        }
        return 0; //Apenas para Exemplificar o Fake deveria gerar Exceção
    }
}
