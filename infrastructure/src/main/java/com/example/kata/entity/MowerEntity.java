package com.example.kata.entity;

import com.example.kata.model.DirectionType;
import com.example.kata.model.Position;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MowerEntity {

    @Id
    private Integer id;
    private int x;
    private int y;
    private String direction;
}
