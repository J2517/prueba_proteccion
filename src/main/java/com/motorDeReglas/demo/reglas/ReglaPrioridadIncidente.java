package com.motorDeReglas.demo.reglas;

import com.motorDeReglas.demo.models.Solicitud;
import com.motorDeReglas.demo.models.TipoSolicitud;
import org.springframework.stereotype.Component;

@Component
public class ReglaPrioridadIncidente implements ReglaPrioridad {
    @Override
    public int calcularPrioridad(Solicitud solicitud){
     return solicitud.getTipoSolicitud().getPrioridad();
    }
}
