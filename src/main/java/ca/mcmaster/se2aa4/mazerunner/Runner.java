package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;

public class Runner{
    private Maze maze;
    private Cursor cursor;

    public Runner(char[][] aMaze){
        maze = new Maze(aMaze);
        cursor = new Cursor(maze, new Position(0,0), Direction.RIGHT);
    }

    public void validationPath(String path){
        PathValidation pathValidation = new PathValidation(maze, cursor);
        if(pathValidation.validateFromLeftEntry(path)){
            System.out.println("The path is valid");
        }else if(pathValidation.validateFromRightEntry(path)){
            System.out.println("The path is valid");
        }else{
            System.out.println("The path is not valid");
        }
    }
}