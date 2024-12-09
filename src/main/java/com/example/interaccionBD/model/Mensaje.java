package com.example.interaccionBD.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Table;
@Data
@Entity

@Table(name = "MENSAJES")

public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" ,length = 255)
    private Long id;

    @Column(name = "TEXTO", length = 255)
    private String mensaje;

}
