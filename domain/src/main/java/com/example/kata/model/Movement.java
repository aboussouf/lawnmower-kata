package com.example.kata.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movement {
    public static List<Position> parse(String firstPosition, String movementsSequence) {
        Position position = new Position(Integer.valueOf(firstPosition.substring(0,1)), Integer.valueOf(firstPosition.substring(2,3)), DirectionType.valueOf(firstPosition.substring(4,5)));
        List<Position> positions = new ArrayList<Position>();
        positions.add(position);
        Position lastPosition = position;
        for(char mvt : movementsSequence.toCharArray()){
            positions.add(retrievePosition(mvt, lastPosition));
            lastPosition = retrievePosition(mvt, lastPosition);
        }
        return positions;
    }

    private static Position retrievePosition(char mvt, Position position){
        CommandType commandType= Arrays.stream(CommandType.values()).filter(c -> c.name().charAt(0) == mvt).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No command found for " + mvt));
        switch (commandType) {
            case A -> {return new Position(position.getX(), position.getY(), DirectionType.E);}
            case D -> {return new Position(position.getX(), position.getY(), DirectionType.N);}
            case G -> {return new Position(position.getX(), position.getY(), DirectionType.W);}
        }
        return position;
    }
}
