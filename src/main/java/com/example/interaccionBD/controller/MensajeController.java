package com.example.interaccionBD.controller;

import com.example.interaccionBD.model.Mensaje;
import com.example.interaccionBD.service.MensajeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MensajeController {

    private final MensajeService mensajeService;

    // Constructor para la inyección de dependencias
    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    // Obtener todos los mensajes
    @GetMapping
    public List<Mensaje> obtenerMensaje(){
    return mensajeService.obtenerMensajes();
    }

    // Obtener un mensaje por ID
    @GetMapping("/{id}")
    public Optional<Mensaje> obtenerMensajePorId(@PathVariable Long id) {
        return mensajeService.obtenerMensajePorId(id);
    }

    // Crear un nuevo mensaje
    @PostMapping
    public Mensaje crearMensaje(@RequestBody Mensaje mensaje) {
        return mensajeService.crearMensaje(mensaje);
    }

    // Actualizar un mensaje existente
    @PutMapping("/{id}")
    public Mensaje actualizarMensaje(@PathVariable Long id, @RequestBody Mensaje mensaje) {
        return mensajeService.actualizarMensaje(id, mensaje);
    }

    // Eliminar un mensaje por ID
    @DeleteMapping("/{id}")
    public void eliminarMensaje(@PathVariable Long id) {
        mensajeService.eliminarMensaje(id);
    }


}
