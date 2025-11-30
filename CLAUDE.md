# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is an Advent of Code 2025 Java project using Maven. The codebase provides a framework for solving daily AoC puzzles with a focus on learning and thinking through problems independently.

## AI Assistant Philosophy - CRITICAL

**NEVER write a solution to a puzzle.** The AI's role is strictly supportive:

- **Ask questions** that could help the user solve the puzzle themselves
- **Write unit tests** to help focus implementation - write ONE test at a time and let the user think along about what to test
- **Support actions** like file creation, refactoring, or running commands
- The goal of Advent of Code is to learn and think independently - AI should facilitate this, not bypass it

## Project Architecture

### Core Structure

The codebase follows a day-based plugin pattern:

- **`Day` interface** (`src/main/java/aoc2025/Day.java`): Contract for all puzzle solutions
  - `part1()`: Solve part 1 of the puzzle
  - `part2()`: Solve part 2 of the puzzle
  - `getDayNumber()`: Returns day number (1-25)

- **`AocRunner`** (`src/main/java/aoc2025/AocRunner.java`): Main entry point
  - Uses reflection to load day classes dynamically: `aoc2025.day{NN}.Day{NN}`
  - Runs specific parts or both parts of a day
  - Times execution of each part

### Daily Puzzle Structure

Each day follows this pattern in `src/main/java/aoc2025/day{NN}/`:

```
Day{NN}.java           # Implements Day interface
  - Constructor()      # Loads input from resources using InputReader
  - Constructor(List)  # Test constructor accepting custom input
  - part1()           # Part 1 solution
  - part2()           # Part 2 solution
```

Corresponding test in `src/test/java/aoc2025/day{NN}/Day{NN}Test.java` uses example inputs from puzzle descriptions.

### Input Files

- **Production inputs**: `src/main/resources/day{NN}.txt`
- **Test inputs**: `src/test/resources/` (as needed)
- **InputReader utility** (`src/main/java/aoc2025/util/InputReader.java`):
  - `readLines(fileName)`: Returns List<String> of file lines
  - `readAsString(fileName)`: Returns entire file as single String
  - `readGroups(fileName)`: Splits on blank lines into List<List<String>>

## Development Commands

### Running Solutions

```bash
# Run both parts of a day
mvn exec:java -Dexec.args="1"

# Run specific part
mvn exec:java -Dexec.args="1 1"    # Day 1, Part 1
mvn exec:java -Dexec.args="1 2"    # Day 1, Part 2
```

### Testing

```bash
# Run all tests
mvn test

# Run tests for specific day
mvn test -Dtest=Day01Test

# Run specific test method
mvn test -Dtest=Day01Test#testPart1Example
```

### Code Formatting

```bash
# Check formatting
mvn spotless:check

# Apply formatting
mvn spotless:apply
```

Formatting uses Google Java Format (AOSP style) with:
- Unused imports removed
- Trailing whitespace trimmed
- Files end with newline

### Build

```bash
# Compile
mvn compile

# Clean and compile
mvn clean compile
```

## Technology Stack

- **Java 21** (source and target)
- **Maven** for build management
- **JUnit 5.10.1** for testing
- **Spotless Maven Plugin** for code formatting
