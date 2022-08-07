package br.com.roberto.refactoringexample2.entities;

import br.com.roberto.refactoringexample2.repositories.MoedaApi;

public class Conta {
    private Double saldo;

    private MoedaApi moedaApi;

    public Conta(MoedaApi moedaApi) {
        this.saldo = Double.valueOf(0);
        this.moedaApi = moedaApi;
    }

    public Double getSaldo(){
        return this.saldo;
    }

    public void setCredito(double valorCredito, String moeda) {
        if (moeda.contains("USD")){
            this.saldo += this.moedaApi.converter(valorCredito, moeda);
            return;
        }
        this.saldo += valorCredito;
    }

    public void setDebito(double valorDebito, String moeda) {
        if (moeda.contains("USD")){
            this.saldo -= this.moedaApi.converter(valorDebito, moeda);
            return;
        }
        this.saldo -= valorDebito;
    }
}
