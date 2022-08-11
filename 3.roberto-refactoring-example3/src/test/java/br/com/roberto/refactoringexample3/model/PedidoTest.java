package br.com.roberto.refactoringexample3.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void deveCriarUmPedidoVazioComCPFValido(){
        String cpf = "935.411.347-80";
        Pedido pedido = new Pedido(cpf);
        double total = pedido.getTotal();
        assertEquals(total, 0);
    }

    @Test
    void deveTentarCriarUmPedidoVazioComCPFInvalido(){
        String cpf = "111.111.111-11";
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> new Pedido(cpf),
                "Cpf Inválido"
        );
        assertTrue(thrown.getMessage().contains("Cpf Inválido"));
    }
}
