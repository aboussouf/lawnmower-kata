package com.example.kata.batch;

import com.example.kata.model.Command;
import com.example.kata.model.Mower;
import com.example.kata.port.primary.MowerApplicationPort;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class Processor implements ItemProcessor<Command,Mower> {

    @Autowired
    private MowerApplicationPort mowerApplicationPort;

    @Override
    public Mower process(Command item) throws Exception {
        return mowerApplicationPort.process(item);
    }
}
