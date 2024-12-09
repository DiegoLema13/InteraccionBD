package com.example.interaccionBD.service;

import com.example.interaccionBD.model.Mensaje;
import com.example.interaccionBD.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MensajeService {

    private final MensajeRepository mensajeRepository;

    // Constructor para la inyección de dependencias
    public MensajeService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    // Obtener todos los mensajes
    public List<Mensaje> obtenerMensajes() {
        return mensajeRepository.findAll();
    }

    // Obtener un mensaje por ID
    public Optional<Mensaje> obtenerMensajePorId(Long id) {
        return mensajeRepository.findById(id);
    }

    // Crear un nuevo mensaje
    public Mensaje crearMensaje(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    // Actualizar un mensaje existente
    public Mensaje actualizarMensaje(Long id, Mensaje mensaje) {
        if (mensajeRepository.existsById(id)) {
            return mensajeRepository.save(mensaje);
        }
        return null; // o lanzar una excepción si no se encuentra el mensaje
    }


    // Eliminar un mensaje por ID
    public void eliminarMensaje(Long id) {
        mensajeRepository.deleteById(id);
    }
}