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

    public boolean moveForward() {
        Position newPosition = currentPosition.moveOneStep(currentDirection);
        if(maze.isValidPosition(newPosition)){ //check if the position is valid
            currentPosition = newPosition;
            System.out.println("Successfully moved forward");
            return true;
        }else{
            System.out.println("wrong position");
            return false;
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
        System.out.println("Successfully turned right");
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
        System.out.println("Successfully turned left");
    }


    public void printPosition(){ //for test
        System.out.println("Current Position: " + currentPosition.getRow()+ " " + currentPosition.getCol());
    }

    public void pirntDirection(){ //for test
        System.out.println("Current Direction: " + currentDirection.name());
    }

    public void setCurrentPosition(Position newPosition){
        currentPosition = newPosition;
    }

    public void setCurrentDirection(Direction newDirection){
        currentDirection = newDirection;
    }

    public Position getCurrentPosition(){
        return currentPosition;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }
}