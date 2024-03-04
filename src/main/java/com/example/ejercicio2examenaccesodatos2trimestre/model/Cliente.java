package com.example.ejercicio2examenaccesodatos2trimestre.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    private Integer id;
    private String nombre;
    private Double total;
    private String estado;
}
