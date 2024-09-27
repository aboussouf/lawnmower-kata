package com.example.kata.model;

public class Position {
    private int x;
    private int y;
    private DirectionType directionType;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public DirectionType getDirectionType() {
        return directionType;
    }

    public Position(int x, int y, DirectionType directionType) {
        this.x = x;
        this.y = y;
        this.directionType = directionType;
    }
}
