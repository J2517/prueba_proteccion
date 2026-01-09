package com.motorDeReglas.demo.reglas;

import com.motorDeReglas.demo.models.Solicitud;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ReglaAntiguedad implements ReglaPrioridad {

    @Override
    public int calcularPrioridad(Solicitud solicitud){
        if (solicitud.getFechaCreacion() == null)
            return 0;
        long horasDePrioridad = Duration.between(solicitud.getFechaCreacion(), LocalDateTime.now()).toHours();

        return (int) horasDePrioridad;
    }

}
