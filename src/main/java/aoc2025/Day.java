package aoc2025;

public interface Day {
    /**
     * Solve part 1 of the day's puzzle
     *
     * @return the solution as a string
     */
    String part1();

    /**
     * Solve part 2 of the day's puzzle
     *
     * @return the solution as a string
     */
    String part2();

    /**
     * Get the day number (1-25)
     *
     * @return the day number
     */
    int getDayNumber();
}
