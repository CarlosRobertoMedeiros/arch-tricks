package br.com.roberto.refactoringexample3.model;

public class Pedido {

    private Cpf cpf;

    public Pedido(String cpf) {
        this.cpf = new Cpf(cpf);
    }

    public double getTotal(){
        return 0;
    }

}
