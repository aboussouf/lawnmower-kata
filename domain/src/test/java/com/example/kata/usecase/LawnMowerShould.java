package com.example.kata.usecase;

import com.example.kata.model.DirectionType;
import com.example.kata.model.Movement;
import com.example.kata.model.Position;
import com.example.kata.util.GenerateDisplayNameFromSourceElements;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


@GenerateDisplayNameFromSourceElements
@DisplayName("Operations of LownMower Should")
class LawnMowerOperationsShould {
    private static DirectionType N = DirectionType.N;
    private static DirectionType E = DirectionType.E;
    private static DirectionType W = DirectionType.W;
    private static DirectionType S = DirectionType.S;

    private static int dimension = 6;

    private static Stream<Arguments> commandsSquence() {

        List<Position> expectedPositions1 = List.of(new Position(1,2, N),
                new Position(1,3,W), new Position(1,4,W), new Position(2,4,S), new Position(3,4,S),
                new Position(3,3,E), new Position(3,2,E), new Position(2,2,N), new Position(1,2,N),
                new Position(1,3, N));

        List<Position> expectedPositions2 = List.of(new Position(3,3, E),
                new Position(3,2,E), new Position(3,1,E), new Position(4,1,S), new Position(5,1,S),
                new Position(5,0,S), new Position(4,0,E), new Position(4,0,E), new Position(3,0,N),
                new Position(2,3, N),new Position(5,1, E));

        return Stream.of(
                arguments("1 2 N GAGAGAGAA", expectedPositions1),
                arguments("3 3 E AADAADADDA", expectedPositions2)
        );
    }

    @ParameterizedTest
    @MethodSource("commandsSquence")
    void lead_to_the_expected_position_when_start_and_movements_are_retreived_from(final String line, List<Position> expectedPositions) {
        String firstPosition = line.substring(0, line.length()-4);
        String movementsSequence = line.substring(4, line.length()-4);
        List<Position> positionList = Movement.parse(firstPosition, movementsSequence);
        assertEquals(expectedPositions, positionList);
    }
}
