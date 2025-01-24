package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;

public class Runner{
    private Maze maze;
    private Cursor cursor;

    public Runner(char[][] aMaze){
        maze = new Maze(aMaze);
        cursor = new Cursor(maze, new Position(0,0), Direction.RIGHT);
    }

    //validate whether the path is correct
    public void validationPath(String path){
        PathValidation pathValidation = new PathValidation(maze, cursor);
        if(pathValidation.validateFromLeftEntry(path)){ //starts from left entry
            System.out.println("Correct Path");
        }else if(pathValidation.validateFromRightEntry(path)){ //starts from right entry
            System.out.println("Correct Path");
        }else{
            System.out.println("Incorrect Path");
        }
    }
}