package br.com.roberto.robertorefactoring.exemplo1.before;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class TaxiTest {

    @Test
    void deveCalcularValorDaCorridaEmDiasNormais(){
        double distance = 10;
        LocalDateTime date = LocalDateTime.of(2022,07,27,10,00,00);
        Taxi taxi = new Taxi();
        double valorCorrida =  taxi.calc(distance, date);
        Assertions.assertEquals(21.0,valorCorrida);
    }

    @Test
    void deveCalcularValorDaCorridaAosDomingos(){
        double distance = 10;
        LocalDateTime date = LocalDateTime.of(2022,07,31,10,00,00);
        Taxi taxi = new Taxi();
        double valorCorrida =  taxi.calc(distance, date);
        Assertions.assertEquals(29.0,valorCorrida);
    }

    @Test
    void deveCalcularValorDaCorridaApos2159h(){
        double distance = 10;
        LocalDateTime date = LocalDateTime.of(2022,07,31,22,00,00);
        Taxi taxi = new Taxi();
        double valorCorrida =  taxi.calc(distance, date);
        Assertions.assertEquals(39.0,valorCorrida);
    }

}