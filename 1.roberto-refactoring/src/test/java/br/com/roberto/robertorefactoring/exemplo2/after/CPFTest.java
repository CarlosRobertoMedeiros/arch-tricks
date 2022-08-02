package br.com.roberto.robertorefactoring.exemplo2.after;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CPFTest {

   private  CPF cpf;

   @BeforeEach
   void setup(){
    cpf = new CPF();
   }

   @Test
   void deveValidarPrimeiroCpf(){
        boolean isCpfValido = cpf.validaCpf("93541134780");
        Assertions.assertEquals(true, isCpfValido);
    }

    @Test
    void deveValidarCpfOndeTodosNumerosSaoIguais(){
        boolean isCpfValido = cpf.validaCpf("11111111111");
        Assertions.assertEquals(false, isCpfValido);
    }

    @Test
    void deveValidarCpfsQueEstaoNaListaDeExcecao(){
        boolean isCpfValido = cpf.validaCpf("12345678902");
        Assertions.assertEquals(false, isCpfValido);
    }
}
