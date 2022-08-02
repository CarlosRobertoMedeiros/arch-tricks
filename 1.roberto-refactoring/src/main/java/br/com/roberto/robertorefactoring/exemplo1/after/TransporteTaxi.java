package br.com.roberto.robertorefactoring.exemplo1.after;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

public class TransporteTaxi {

    private static final double OVERNIGHT_RATE = 3.90;
    private static final double SUNDAY_RATE = 2.90;
    private static final double NORMAL_RATE = 2.10;

    public double calculateRate(double distance, LocalDateTime dateTime) {
        if (distance <1) throw new InvalidParameterException("Parâmetro de Distância Negativa");
        if (isOvernight(dateTime))
            return distance * OVERNIGHT_RATE;
        if (isSunday(dateTime))
            return distance * SUNDAY_RATE;
        return distance * NORMAL_RATE;
    }

    private boolean isOvernight(LocalDateTime date){
        return date.getHour() >= 22;
    }
    private boolean isSunday(LocalDateTime date){
        return date.getDayOfWeek().getValue() == 7;
    }


}
//Regra de Negócio
