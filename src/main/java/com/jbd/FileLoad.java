package com.jbd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLoad {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileLoad.class);
    private static final Marker FL_MARKER = MarkerFactory.getMarker("FileLoad");
    private StringBuilder builder;

    public String fileLoad(String file){
        LOGGER.info(FL_MARKER, "File loading started.");
        builder = new StringBuilder();
        FileReader fr = null;
        String line;

        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            LOGGER.error(FL_MARKER, "Failed during opening.");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);
        try {
            while((line = bfr.readLine()) != null){
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            LOGGER.error(FL_MARKER, "Failed during reading.");
            System.exit(2);
        }

        try {
            fr.close();
        } catch (IOException e) {
            LOGGER.error(FL_MARKER, "Failed during closing.");
            System.exit(3);
        }

        LOGGER.info(FL_MARKER, "File loading finished.");
        return builder.toString();
    }

}