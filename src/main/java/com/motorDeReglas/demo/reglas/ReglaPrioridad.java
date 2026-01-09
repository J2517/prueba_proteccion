package com.motorDeReglas.demo.reglas;

import com.motorDeReglas.demo.models.Solicitud;

public interface ReglaPrioridad {
    int calcularPrioridad(Solicitud solicitud);
}
