package com.motorDeReglas.demo.controllers;

import com.motorDeReglas.demo.dtos.SolicitudDTO;
import com.motorDeReglas.demo.models.Solicitud;
import com.motorDeReglas.demo.services.SolicitudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@Tag(name = "Controlador de Solicitudes", description = "Endpoints para crear y ver solicitudes")
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
    @Operation(
            summary = "Crear una nueva solicitud",
            description = "Recibe los datos, calcula la prioridad inicial y guarda la solicitud en base de datos."
    )
    @ApiResponse(responseCode = "201", description = "Solicitud creada exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content)
    public ResponseEntity<Solicitud> crearSolicitud(@Valid @RequestBody SolicitudDTO solicitudDTO) {
        Solicitud nuevaSolicitud = solicitudService.guardarSolicitud(solicitudDTO);
        return new ResponseEntity<>(nuevaSolicitud, HttpStatus.CREATED);
    }

    /*
     * GET api/solicitudes
     * */
    @GetMapping
    @Operation(
            summary = "Listar solicitudes ordenadas",
            description = "Devuelve todas las solicitudes ordenadas según las reglas de prioridad definidas."
    )
    @ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente")
    public ResponseEntity<List<Solicitud>> obtenerSolicitudes(){
        List<Solicitud> listaOrdenada = solicitudService.obtenerSolicitudesOrdenadas();
        return ResponseEntity.ok(listaOrdenada);
    }
}