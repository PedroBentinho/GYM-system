package com.gym_system.backend.model;

import java.lang.annotation.Inherited;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

    @Entity 

    @Table(name = "treinos")
    public class treinos {

        @Id 
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

@Column( nullable = false, length =100 )
private String Exercicio;

@Column( nullable = false )
private Integer Series;

@Column(nullable = false)
private Integer repeticoes;

@Column(length = 50)
private String grupoMuscular 

@Column(nullable = false)
private boolean feitohoje = false;
public treinos() }