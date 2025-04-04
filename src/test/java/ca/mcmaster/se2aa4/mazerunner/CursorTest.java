package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CursorTest {

    private Cursor cursor;
    private Maze maze;


    @BeforeEach
    void setUp() {
        cursor = Cursor.getInstance();
        maze = Maze.getInstance();

        // Create a simple maze for testing
        char[][] simpleMaze = {
                {'#', '#', '#', '#', '#'},
                {' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', ' '},
                {'#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#'}
        };
        maze.initialize(simpleMaze);
        cursor.initialize(maze, maze.getLeftEntry(), Direction.RIGHT);


    }

    @Test
    void testSingletonInstance() {
        Cursor newCursor = Cursor.getInstance();
        assertSame(cursor, newCursor);
    }


    @Test
    void testInitialization() {
        Position leftEntry = maze.getLeftEntry();
        assertEquals(leftEntry.getCol(), cursor.getCurrentPosition().getCol());
        assertEquals(leftEntry.getRow(), cursor.getCurrentPosition().getRow());
        assertEquals(Direction.RIGHT, cursor.getCurrentDirection());
    }


    @Test
    void testMoveForwardValid() {
        boolean moveResult = cursor.moveForward();

        assertTrue(moveResult);
        assertEquals(1, cursor.getCurrentPosition().getRow());
        assertEquals(1, cursor.getCurrentPosition().getCol());
    }

    @Test
    void testMoveForwardInvalid() {
        cursor.initialize(maze, new Position(2, 1), Direction.RIGHT);

        boolean moveResult = cursor.moveForward();

        assertFalse(moveResult);
        assertEquals(2, cursor.getCurrentPosition().getRow());
        assertEquals(1, cursor.getCurrentPosition().getCol());
    }

    @Test
    void testTurnRight() {
        // Initial direction is RIGHT
        cursor.turnRight(); // RIGHT to DOWN
        assertEquals(Direction.DOWN, cursor.getCurrentDirection());

        cursor.turnRight(); // DOWN to LEFT
        assertEquals(Direction.LEFT, cursor.getCurrentDirection());

        cursor.turnRight(); // LEFT to UP
        assertEquals(Direction.UP, cursor.getCurrentDirection());

        cursor.turnRight(); // UP to RIGHT
        assertEquals(Direction.RIGHT, cursor.getCurrentDirection());
    }

    @Test
    void testTurnLeft() {
        // Initial direction is RIGHT
        cursor.turnLeft(); // RIGHT to UP
        assertEquals(Direction.UP, cursor.getCurrentDirection());

        cursor.turnLeft(); // UP to LEFT
        assertEquals(Direction.LEFT, cursor.getCurrentDirection());

        cursor.turnLeft(); // LEFT to DOWN
        assertEquals(Direction.DOWN, cursor.getCurrentDirection());

        cursor.turnLeft(); // DOWN to RIGHT
        assertEquals(Direction.RIGHT, cursor.getCurrentDirection());
    }

    @Test
    void testReachExit() {
        assertFalse(cursor.reachExit(maze.getRightEntry()));
        cursor.setCurrentPosition(maze.getRightEntry());
        assertTrue(cursor.reachExit(maze.getRightEntry()));
    }

}