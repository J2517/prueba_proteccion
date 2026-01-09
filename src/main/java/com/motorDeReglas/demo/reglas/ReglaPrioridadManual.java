package com.motorDeReglas.demo.reglas;

import com.motorDeReglas.demo.models.Solicitud;
import org.springframework.stereotype.Component;

@Component
public class ReglaPrioridadManual implements ReglaPrioridad {

    @Override
    public int calcularPrioridad(Solicitud solicitud){
        return solicitud.getPrioridadManual();
    }
}
