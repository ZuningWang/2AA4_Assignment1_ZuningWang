package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.CommandLine;
import ca.mcmaster.se2aa4.mazerunner.Direction;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("Starting Maze Runner");
        Options options = new Options();
        options.addOption("i", true, "input file path");
        CommandLineParser parser = new DefaultParser();

        char[][] maze = null;
        try {
            CommandLine cmd = parser.parse(options, args);
            int numRow = 0;
            int numCol = 0;
            if(cmd.hasOption("i")){
                logger.trace("Reading the maze from file " + cmd.getOptionValue("i"));
                BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue("i")));
                String line;
                while ((line = reader.readLine()) != null) {
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            System.out.print("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            System.out.print("PASS ");
                        }
                    }
                    numCol = line.length();
                    System.out.print(System.lineSeparator());
                    numRow++;
                }
                maze = new char[numRow][numCol];
                BufferedReader areader = new BufferedReader(new FileReader(cmd.getOptionValue("i")));
                String newline;
                int rowIndex = 0;
                while ((newline = areader.readLine()) != null) {
                    for (int idx = 0; idx < newline.length(); idx++) {
                        maze[rowIndex][idx] = newline.charAt(idx);
                    }
                    rowIndex++;
                    System.out.print(System.lineSeparator());
                }
            }

            Maze aMaze = new Maze(maze);
            aMaze.printMaze();
            System.out.println("Num row is " + numRow);
            System.out.println("Num col is " + numCol);
            Position position = new Position(0,0);
            Cursor cursor = new Cursor(aMaze, position, Direction.LEFT);
            cursor.printPosition();
            cursor.moveForward();
            cursor.printPosition();
            cursor.turnRight();
            cursor.moveForward();
            cursor.printPosition();


        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\", e);
        }
        logger.trace("Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("End of MazeRunner");
    }
}
