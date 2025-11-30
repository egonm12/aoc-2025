package aoc2025;

import java.lang.reflect.InvocationTargetException;

public class AocRunner {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java aoc2025.AocRunner <day> [part]");
            System.out.println("  day  - Day number (1-25)");
            System.out.println("  part - Optional: 1 or 2 (runs both if not specified)");
            System.out.println();
            System.out.println("Examples:");
            System.out.println("  mvn exec:java -Dexec.args=\"1\"     - Run both parts of day 1");
            System.out.println("  mvn exec:java -Dexec.args=\"1 1\"   - Run only part 1 of day 1");
            return;
        }

        int dayNumber = Integer.parseInt(args[0]);
        Integer part = args.length > 1 ? Integer.parseInt(args[1]) : null;

        try {
            Day day = loadDay(dayNumber);
            runDay(day, part);
        } catch (Exception e) {
            System.err.println("Error running day " + dayNumber + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Day loadDay(int dayNumber)
            throws ClassNotFoundException,
                    NoSuchMethodException,
                    InvocationTargetException,
                    InstantiationException,
                    IllegalAccessException {

        String className = String.format("aoc2025.day%02d.Day%02d", dayNumber, dayNumber);
        Class<?> dayClass = Class.forName(className);
        return (Day) dayClass.getDeclaredConstructor().newInstance();
    }

    private static void runDay(Day day, Integer part) {
        System.out.println("=== Advent of Code 2025 - Day " + day.getDayNumber() + " ===");
        System.out.println();

        if (part == null || part == 1) {
            long start = System.currentTimeMillis();
            String result = day.part1();
            long duration = System.currentTimeMillis() - start;
            System.out.println("Part 1: " + result);
            System.out.println("  (completed in " + duration + "ms)");
            System.out.println();
        }

        if (part == null || part == 2) {
            long start = System.currentTimeMillis();
            String result = day.part2();
            long duration = System.currentTimeMillis() - start;
            System.out.println("Part 2: " + result);
            System.out.println("  (completed in " + duration + "ms)");
        }
    }
}
