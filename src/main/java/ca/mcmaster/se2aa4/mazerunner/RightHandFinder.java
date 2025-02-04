package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import java.util.*;

public class RightHandFinder implements FindingPath{
    public String findPath(char[][] aMaze){
        Maze maze = new Maze(aMaze);
        Cursor cursor = new Cursor(maze, maze.getLeftEntry(), Direction.RIGHT);
        ArrayList<String> path = new ArrayList<String>();

        while(!cursor.reachExit(maze.getRightEntry())){
            Position rightPosition = cursor.getCurrentPosition().getRightPosition(cursor.getCurrentDirection());
            Position leftPosition = cursor.getCurrentPosition().getLeftPosition(cursor.getCurrentDirection());
            Position nextPosition = cursor.getCurrentPosition().getNextPosition(cursor.getCurrentDirection());
            if(maze.isValidPosition(rightPosition)){ //right position is valid
                cursor.turnRight();
                cursor.moveForward();
                path.add("R");
                path.add("F");
            }else if(maze.isValidPosition(nextPosition)){ //if next position is valid
                cursor.moveForward();
                path.add("F");
            }else if(maze.isValidPosition(leftPosition)){ //if left position is valid
                cursor.turnLeft();
                cursor.moveForward();
                path.add("L");
                path.add("F");
            }else{
                cursor.turnRight();
                cursor.turnRight();
                path.add("R");
                path.add("R");
            }

        }
        String result = "";
        for(String s : path){
            result += s;
        }
        return result;
    }

}