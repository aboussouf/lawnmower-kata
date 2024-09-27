package com.example.kata.usecase;

import com.example.kata.model.Command;
import com.example.kata.model.Movement;
import com.example.kata.model.Mower;
import com.example.kata.model.Position;
import com.example.kata.port.primary.MowerApplicationPort;
import com.example.kata.port.secondary.MowerPersistencePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MowerApplication implements MowerApplicationPort {

    MowerPersistencePort mowerPersistencePort;

    @Override
    public Mower process(Command command) {
        String line = command.getLine();
        String firstPosition = line.substring(0,4);
        String movementsSequence = line.substring(5, line.length() - 1);
        List<Position> positions = Movement.parse(firstPosition, movementsSequence);
        return new Mower(positions.get(movementsSequence.length() - 1));
    }
}
