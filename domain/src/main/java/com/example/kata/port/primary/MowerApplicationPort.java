package com.example.kata.port.primary;

import com.example.kata.model.Command;
import com.example.kata.model.Mower;

public interface MowerApplicationPort {
    Mower process(Command command);
}
