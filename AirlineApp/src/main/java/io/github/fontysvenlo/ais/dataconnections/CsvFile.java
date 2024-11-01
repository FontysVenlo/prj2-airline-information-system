package io.github.fontysvenlo.ais.dataconnections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CsvFile {
    private CsvFile() {}

    public static List<String[]> read(String datasetPath) {
        List<String[]> data = new ArrayList<>();

        InputStream resource = CsvFile.class.getClassLoader().getResourceAsStream(datasetPath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            // TODO: system should probably not continue if this happens
            e.printStackTrace();
        }

        return data;
    }
}
