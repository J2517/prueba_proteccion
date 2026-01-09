package com.motorDeReglas.demo.dtos;

import com.motorDeReglas.demo.models.TipoSolicitud;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SolicitudDTO {
    private Long id;
    private TipoSolicitud tipoSolicitud;

    @Min(value = 1)
    @Max(value = 5)
    private int prioridadManual;

    private LocalDateTime fechaCreacion;
    private String usuario;
    private int prioridad;
}
