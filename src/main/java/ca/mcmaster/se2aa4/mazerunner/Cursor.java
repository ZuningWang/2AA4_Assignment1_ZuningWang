package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;

public class Cursor{
    private Maze maze;
    private Position currentPosition;
    private Direction currentDirection;

    public Cursor(Maze maze, Position position, Direction direction){
        this.maze = maze;
        currentPosition = position;
        currentDirection = direction;
    }

    public void moveForward() {
        Position newPosition = currentPosition.moveOneStep(currentDirection);
        if(maze.isValidPosition(newPosition)){
            currentPosition = newPosition;
        }else{
            System.out.println("wrong position");
        }
    }

    public void turnRight(){
        switch(currentDirection){
            case Direction.UP:
                currentDirection = Direction.RIGHT;
                break;
            case Direction.DOWN:
                currentDirection = Direction.LEFT;
                break;
            case Direction.LEFT:
                currentDirection = Direction.UP;
                break;
            case Direction.RIGHT:
                currentDirection = Direction.DOWN;
                break;
        }
    }

    public void turnLeft(){
        switch(currentDirection){
            case Direction.UP:
                currentDirection = Direction.LEFT;
                break;
            case Direction.DOWN:
                currentDirection = Direction.RIGHT;
                break;
            case Direction.LEFT:
                currentDirection = Direction.DOWN;
                break;
            case Direction.RIGHT:
                currentDirection = Direction.UP;
                break;
        }
    }


    public void printPosition(){
        System.out.println("Current Position: " + currentPosition.getRow()+ " " + currentPosition.getCol());
    }

    public void pirntDirection(){
        System.out.println("Current Direction: " + currentDirection.name());
    }
}