package br.com.roberto.refactoringexample2.entities;


import br.com.roberto.refactoringexample2.datasource.rest.MoedaApiFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ContaTest {

    private Conta conta;

    @BeforeEach
    void setup(){
        conta = new Conta(new MoedaApiFake());
    }

    @Test
    void deveCriarUmaConta(){
        Double saldo = conta.getSaldo();
        Assertions.assertEquals(0,saldo);
    }

    @Test
    void deveFazerUmCreditoDe100Reais(){
        conta.setCredito(100,"BRL");
        Double saldo = conta.getSaldo();
        Assertions.assertEquals(100,saldo);
    }

    @Test
    void deveFazerUmDebitoDe50Reais(){
        conta.setCredito(100,"BRL");
        conta.setDebito(50,"BRL");
        Double saldo = conta.getSaldo();
        Assertions.assertEquals(50,saldo);
    }

    @Test
    void deveFazerUmCreditoDe100DolaresComFake(){
        conta.setCredito(100, "USD");
        Double saldo = conta.getSaldo();
        Assertions.assertEquals(500,saldo);
    }

    @Test
    void deveFazerUmDebitoDe50DolaresComFake(){
        conta.setCredito(100, "USD");
        conta.setDebito(50, "USD");
        Double saldo = conta.getSaldo();
        Assertions.assertEquals(250,saldo);
    }

    @Test
    void deveFazerUmCreditoDe100DolaresComStub(){
        Conta conta = Mockito.mock(Conta.class);
        Mockito.when(conta.getSaldo()).thenReturn(Double.valueOf(500));
        //Verificar como Aplicar um Stub em Java
        conta.setCredito(100, "USD");
        Double saldo = conta.getSaldo();
        Assertions.assertEquals(500,saldo);
    }

    @Test
    void deveCriarUmaContaComSpy(){
        Conta contaSpy = Mockito.spy(new Conta(new MoedaApiFake()));
        contaSpy.getSaldo();
        contaSpy.getSaldo();
        contaSpy.getSaldo();
        Mockito.verify(contaSpy, Mockito.times(3)).getSaldo();
    }
    @Test
    void deveRealizarUmCreditoDe100DolaresComMock(){
        //Isso aqui deveria funcionar com mocks do mockito
//        Conta contaMock = Mockito.mock(Conta.class);
//        contaMock.setCredito(100.0,"USD");
//        Assertions.assertEquals(500.0,Mockito.verify(contaMock).getSaldo());
    }

}
