package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public class PathRecorder implements Observer{  //record the path
    private StringBuilder path = new StringBuilder();

    public void update(String command){
        path.append(command);
    }

    public String getCanonicalPath(){
        return path.toString();
    }

    public String getFactorizedPath(){
        return toFactorized(getCanonicalPath());
    }

    public String toFactorized(String path){
        int index = 0;
        String str = "";
        while(index < path.length()){
            int numSame = 0;
            for(int i = index; i < path.length(); i++){
                if(path.charAt(index) != path.charAt(i)){
                    break;
                }else{
                    numSame++;
                }
            }
            str += numSame +""+ path.charAt(index);
            index += numSame;
        }
        return str;
    }

    public static String toCanonical(String path){
        String str = "";
        int index = 0;
        while(index < path.length()){
            String num = "";
            while(path.charAt(index) >= '0' && path.charAt(index) <= '9'){
                num += path.charAt(index);
                index++;
            }
            int number = Integer.parseInt(num);
            for(int i = 0; i < number; i++){
                str += path.charAt(index);
            }
            index++;
        }
        return str;
    }
}