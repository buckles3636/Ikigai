package com.example.application.data.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineSelector {
    public static String selectRandomLineFromFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            // Handle the exception or display an error message
            e.printStackTrace();
            return null;
        }

        if (lines.isEmpty()) {
            return null; // Return null if the file is empty
        }

        Random random = new Random();
        int randomIndex = random.nextInt(lines.size());

        return lines.get(randomIndex);
    }
}