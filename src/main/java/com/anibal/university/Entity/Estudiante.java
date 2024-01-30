package com.anibal.university.Entity;


//id: INTEGER (PK)
//nombre: VARCHAR(40) NN
//apellido: VARCHAR(40) NN
//email: VARCHAR(40) NN UNIQUE
//creditos: INTEGER NN
//    semetre: INTEGER NN
//    promedio: INTEGER NN

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String nombre;

    @Column(length = 40, nullable = false)
    private String apellido;

    @Column(length = 40, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer creditos;

    @Column(nullable = false)
    private Integer semestre;

    @Column(nullable = false)
    private Integer promedio;

}