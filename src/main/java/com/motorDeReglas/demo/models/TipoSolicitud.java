package com.motorDeReglas.demo.models;

public enum TipoSolicitud {
    INCIDENTE(100),
    REQUERIMIENTO(80),
    CONSULTA(50);

    private final int prioridad;

    TipoSolicitud(int prioridad) {
        this.prioridad = prioridad;
    }
    public int getPrioridad() {
        return prioridad;
    }
}
