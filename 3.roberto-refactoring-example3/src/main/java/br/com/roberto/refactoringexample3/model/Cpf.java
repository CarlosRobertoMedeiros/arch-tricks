package br.com.roberto.refactoringexample3.model;

import java.util.ArrayList;
import java.util.List;

public class Cpf {

    private static final List<String> CPFS_BLOQUEADOS = new ArrayList<>();
    private static final byte FATOR_PRIMEIRO_DIGITO = 10;
    private static final  byte FATOR_SEGUNDO_DIGITO = 11;

    private String cpf;

    public Cpf(String cpf) {
        if (!this.validaCpf(cpf)) throw new RuntimeException("Cpf Inválido");
        this.cpf = cpf;
    }
    public boolean validaCpf(String newCpf){
        if (this.isCpfPossuiTamanhoInvalido(newCpf)) return false;
        if (this.isExistemLetrasNoCpf(newCpf)) return false;
        String cpf = this.limpaFormatacao(newCpf);
        if (this.isCpfContemTodosNumerosIguais(cpf)) return false;
        if (this.isCpfEstaNaListaDeCpfsBloqueados(cpf)) return false;
        if (this.isCpfInformadoDiferenteCpfValidado(cpf)) return false;
        return true;
    }

    public String getCpf(){
        return this.cpf;
    }

    private boolean isCpfInformadoDiferenteCpfValidado(String cpf) {
        int primeiroDigitoVerificador = this.geraDigitoVerificador(cpf, FATOR_PRIMEIRO_DIGITO);
        int segundoDigitoVerificador = this.geraDigitoVerificador(cpf, FATOR_SEGUNDO_DIGITO);
        return !cpf.equals(cpf.substring(0,9)+primeiroDigitoVerificador+segundoDigitoVerificador);
    }
    private static boolean isCpfEstaNaListaDeCpfsBloqueados(String cpf) {
        return getCpfsBloqueados().contains(cpf);
    }

    private static boolean isCpfContemTodosNumerosIguais(String cpf) {
        return cpf.chars().distinct().count() == 1;
    }

    private static List<String> getCpfsBloqueados() {
        CPFS_BLOQUEADOS.add("12345678902");
        return CPFS_BLOQUEADOS;
    }

    private boolean isCpfPossuiTamanhoInvalido(String cpf) {
        return cpf.length() < 11 || cpf.length() > 14;
    }

    private boolean isExistemLetrasNoCpf(String cpf) {
        for (byte i=0; i < 10; i++){
            if (Character.isLetter(cpf.charAt(i))) return true;
        }
        return false;
    }

    private int geraDigitoVerificador(String cpf, byte fatorDigito) {
        byte fatorDigitoInterno = fatorDigito;
        int total = 0;
        for (byte i=0; i < (fatorDigito-1); i++){
            total+= (Character.getNumericValue(cpf.charAt(i))  * fatorDigitoInterno);
            fatorDigitoInterno--;
        }
        return (total % 11 < 2) ? 0 : 11 - (total % 11);
    }
    private String limpaFormatacao(String cpf) {
        //TODO: Modificar para utilizar REGEX
        return cpf.replace(".","").replace("-","");
    }


}
