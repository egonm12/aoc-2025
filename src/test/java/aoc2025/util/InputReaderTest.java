package aoc2025.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputReaderTest {

    @Test
    void testReadLines() {
        List<String> lines = InputReader.readLines("test-input.txt");

        assertEquals(8, lines.size());
        assertEquals("line 1", lines.get(0));
        assertEquals("line 2", lines.get(1));
        assertEquals("line 3", lines.get(2));
        assertEquals("", lines.get(3));
        assertEquals("group 2 line 1", lines.get(4));
        assertEquals("group 2 line 2", lines.get(5));
        assertEquals("", lines.get(6));
        assertEquals("group 3 line 1", lines.get(7));
    }

    @Test
    void testReadAsString() {
        String content = InputReader.readAsString("test-input.txt");

        assertTrue(content.contains("line 1"));
        assertTrue(content.contains("line 2"));
        assertTrue(content.contains("group 2 line 1"));
        assertTrue(content.contains("group 3 line 1"));
    }

    @Test
    void testReadGroups() {
        List<List<String>> groups = InputReader.readGroups("test-input.txt");

        assertEquals(3, groups.size());

        // First group
        assertEquals(3, groups.get(0).size());
        assertEquals("line 1", groups.get(0).get(0));
        assertEquals("line 2", groups.get(0).get(1));
        assertEquals("line 3", groups.get(0).get(2));

        // Second group
        assertEquals(2, groups.get(1).size());
        assertEquals("group 2 line 1", groups.get(1).get(0));
        assertEquals("group 2 line 2", groups.get(1).get(1));

        // Third group
        assertEquals(1, groups.get(2).size());
        assertEquals("group 3 line 1", groups.get(2).get(0));
    }

    @Test
    void testFileNotFound() {
        Exception exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> {
                            InputReader.readLines("nonexistent.txt");
                        });

        assertTrue(exception.getMessage().contains("File not found"));
    }
}
