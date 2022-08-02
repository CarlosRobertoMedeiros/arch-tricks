package br.com.roberto.robertorefactoring.exemplo1.after;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TransporteTaxiTest {

    double distancia;
    LocalDateTime data;
    TransporteTaxi transporteTaxi;
    double valorCorrida;

    @BeforeEach
    void setup(){
        distancia = 10;
        data = LocalDateTime.of(2022,07,27,10,00,00);
        transporteTaxi = new TransporteTaxi();
    }

    @Test
    void deveCalcularValorDaCorridaEmDiasNormais(){
        valorCorrida =  transporteTaxi.calculateRate(distancia, data);
        Assertions.assertEquals(21.0,valorCorrida);
    }

    @Test
    void deveCalcularValorDaCorridaAosDomingos(){
        LocalDateTime data = LocalDateTime.of(2022,07,31,10,00,00);
        valorCorrida =  transporteTaxi.calculateRate(distancia, data);
        Assertions.assertEquals(29.0,valorCorrida);
    }

    @Test
    void deveCalcularValorDaCorridaApos2159h(){
        LocalDateTime data = LocalDateTime.of(2022,07,31,22,00,00);
        valorCorrida =  transporteTaxi.calculateRate(distancia, data);
        Assertions.assertEquals(39.0,valorCorrida);
    }

    @Test
    void deveEnviarExcecaoEmCasoDeDistanciaNegativa() {
        LocalDateTime data = LocalDateTime.of(2022,07,31,22,00,00);
        InvalidParameterException invalidParameterException = assertThrows(
                InvalidParameterException.class,
                () ->{
                    distancia = -1;
                    transporteTaxi.calculateRate(distancia, data);
                }
        );
        Assertions.assertTrue(invalidParameterException.getMessage().contains("Parâmetro de Distância Negativa"));
    }

}