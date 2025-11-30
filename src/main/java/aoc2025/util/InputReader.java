package aoc2025.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    /**
     * Reads all lines from an input file in the resources folder
     *
     * @param fileName the name of the file (e.g., "day01.txt")
     * @return list of lines from the file
     */
    public static List<String> readLines(String fileName) {
        InputStream is = InputReader.class.getClassLoader().getResourceAsStream(fileName);

        if (is == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
    }

    /**
     * Reads entire file content as a single string
     *
     * @param fileName the name of the file (e.g., "day01.txt")
     * @return the complete file content
     */
    public static String readAsString(String fileName) {
        return String.join("\n", readLines(fileName));
    }

    /**
     * Reads file and splits into groups separated by blank lines Useful for many AoC puzzles
     *
     * @param fileName the name of the file
     * @return list of groups, where each group is a list of lines
     */
    public static List<List<String>> readGroups(String fileName) {
        String content = readAsString(fileName);
        return List.of(content.split("\n\n")).stream()
                .map(group -> List.of(group.split("\n")))
                .collect(Collectors.toList());
    }
}
