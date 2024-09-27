package com.example.kata.batch;

import com.example.kata.model.Command;
import com.example.kata.model.Mower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.core.io.Resource;


import java.io.*;

@Slf4j
public class MultiLineItemWriter implements ItemWriter<Mower>, StepExecutionListener {


    private static String firstLine;
    private Resource input;
    private Resource output;
    private Command command;

    public MultiLineItemWriter(Command command, Resource input, Resource output) {
        this.input = input;
        this.output = output;
        this.command = command;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.debug("Read the  first line contains the coordinates of area ");
        try {
            firstLine = readFirstLine();
        } catch (IOException e) {
            log.error(" Parser exception cannot get mower coordinates ");
        }
    }

    @Override
    public void write(Chunk<? extends Mower> chunk) {

    }

    public String readFirstLine() throws IOException {
        return new BufferedReader(new FileReader(input.getFile())).readLine();
    }

    public void writeToOUtPutFile(String toWrite) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(output.getFilename()));
        writer.write(toWrite);
        writer.close();
    }


}
