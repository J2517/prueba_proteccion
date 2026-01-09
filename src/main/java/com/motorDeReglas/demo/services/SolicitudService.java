package com.motorDeReglas.demo.services;

import com.motorDeReglas.demo.dtos.SolicitudDTO;
import com.motorDeReglas.demo.models.Solicitud;
import com.motorDeReglas.demo.reglas.ReglaPrioridad;
import com.motorDeReglas.demo.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudService {
    private final SolicitudRepository solicitudRepository;
    private final List<ReglaPrioridad> reglasDePrioridad;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository, List<ReglaPrioridad> reglasDePrioridad) {
        this.solicitudRepository = solicitudRepository;
        this.reglasDePrioridad = reglasDePrioridad;
    }
    public Solicitud guardarSolicitud(SolicitudDTO solicitudDTO) {
        Solicitud solicitud = new Solicitud();
        solicitud.setTipoSolicitud(solicitudDTO.getTipoSolicitud());
        solicitud.setPrioridadManual(solicitudDTO.getPrioridadManual());
        solicitud.setUsuario(solicitudDTO.getUsuario());
        solicitud.setFechaCreacion(solicitudDTO.getFechaCreacion() != null ? solicitudDTO.getFechaCreacion() : java.time.LocalDateTime.now());

        return solicitudRepository.save(solicitud);
    }

    public List<Solicitud> obtenerSolicitudesOrdenadas(){
        List<Solicitud> solicitudes = solicitudRepository.findAll();

        for (Solicitud solicitud : solicitudes) {
            int prioridadTotal = 0;

            for (ReglaPrioridad regla : reglasDePrioridad) {
                prioridadTotal += regla.calcularPrioridad(solicitud);
            }
            solicitud.setPrioridad(prioridadTotal);
        }
        return solicitudes.stream().sorted(Comparator.comparingInt(Solicitud::getPrioridad).reversed()).collect(Collectors.toList());
    }
}
