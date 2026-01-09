package com.motorDeReglas.demo.controllers;

import com.motorDeReglas.demo.dtos.SolicitudDTO;
import com.motorDeReglas.demo.models.Solicitud;
import com.motorDeReglas.demo.services.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {
    private final SolicitudService solicitudService;

    @Autowired
    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    /**
     * POST api/solicitudes
     */
    @PostMapping
    public ResponseEntity<Solicitud> crearSolicitud(@Valid @RequestBody SolicitudDTO solicitudDTO) {
        Solicitud nuevaSolicitud = solicitudService.guardarSolicitud(solicitudDTO);
        return new ResponseEntity<>(nuevaSolicitud, HttpStatus.CREATED);
    }

    /*
    * GET api/solicitudes
    * */
    @GetMapping
    public ResponseEntity<List<Solicitud>> obtenerSolicitudes(){
        List<Solicitud> listaOrdenada = solicitudService.obtenerSolicitudesOrdenadas();
        return ResponseEntity.ok(listaOrdenada);
    }

}
