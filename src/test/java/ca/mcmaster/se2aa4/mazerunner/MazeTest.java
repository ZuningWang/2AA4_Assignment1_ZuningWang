package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    private Maze maze;

    @BeforeEach
    void setUp() {
        maze = Maze.getInstance();
    }

    @Test
    void testSingletonInstance() {
        // Verify whether will get the same instance
        Maze anotherMazeReference = Maze.getInstance();
        assertSame(maze, anotherMazeReference);
    }

    @Test
    void testInitializationAndGetMaze() {
        // Test maze initialization with a simple maze
        char[][] sampleMaze = {
                {'#', '#', '#', '#', '#'},
                {'#', '#', '#', ' ', '#'},
                {' ', ' ', '#', '#', ' '},
                {'#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#'}
        };

        maze.initialize(sampleMaze);

        // Check that the maze was correctly initialized
        char[][] retrievedMaze = maze.getMaze();

        // Check each elements
        for (int i = 0; i < sampleMaze.length; i++) {
            assertArrayEquals(sampleMaze[i], retrievedMaze[i]);
        }
    }

    @Test
    void testIsValidPosition() {
        char[][] testMaze = {
                {'#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {' ', ' ', '#', ' ', ' '},
                {'#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#'}
        };

        maze.initialize(testMaze);

        // Test valid positions
        assertTrue(maze.isValidPosition(new Position(1, 1)));
        assertTrue(maze.isValidPosition(new Position(2, 1)));

        // Test invalid positions
        assertFalse(maze.isValidPosition(new Position(-1, 0)));
        assertFalse(maze.isValidPosition(new Position(0, -1)));
        assertFalse(maze.isValidPosition(new Position(0, 0)));
        assertFalse(maze.isValidPosition(new Position(4, 2)));


    }

    @Test
    void testFindEntry() {
        char[][] testMaze = {
                {'#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', ' '},
                {' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#'}
        };

        maze.initialize(testMaze);

        // Test that entries are correctly identified
        Position leftEntry = maze.getLeftEntry();
        Position rightEntry = maze.getRightEntry();

        assertNotNull(leftEntry);
        assertNotNull(rightEntry);

        // Check left entry
        assertEquals(3, leftEntry.getRow());
        assertEquals(0, leftEntry.getCol());

        // Check right entry
        assertEquals(2, rightEntry.getRow());
        assertEquals(4, rightEntry.getCol());
    }


}