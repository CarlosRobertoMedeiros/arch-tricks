package br.com.roberto.refactoringexample3.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CpfTest {

    private Cpf cpf;

    @Test
    void deveValidarPrimeiroCpf(){
        cpf = new Cpf("93541134780");
        boolean isCpfValido = cpf.validaCpf(cpf.getCpf());
        Assertions.assertEquals(true, isCpfValido);
    }

    @Test
    void deveLancarExcecaoComCPFInvalido(){
        String cpf = "111.111.111-11";
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> new Cpf(cpf),
                "Cpf Inválido"
        );
        assertTrue(thrown.getMessage().contains("Cpf Inválido"));
    }

    @Test
    void deveValidarCpfsQueEstaoNaListaDeExcecao(){
        String cpf = "12345678902";
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> new Cpf(cpf),
                "Cpf Inválido"
        );
        assertTrue(thrown.getMessage().contains("Cpf Inválido"));
    }



}
