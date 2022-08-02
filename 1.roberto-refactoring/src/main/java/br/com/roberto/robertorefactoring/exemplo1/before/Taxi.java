package br.com.roberto.robertorefactoring.exemplo1.before;

import java.time.LocalDateTime;

public class Taxi {

    public double calc(double dist, LocalDateTime d){

        //overnight

        if(d.getHour() >=22){

            return dist * 3.90;

        }else{
            //sunday
            if(d.getDayOfWeek().getValue() == 7){

                return dist * 2.9;

            }else{

                return dist * 2.10;

            }



        }

    }

}
