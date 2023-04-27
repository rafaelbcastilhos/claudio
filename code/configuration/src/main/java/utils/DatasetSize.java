package utils;

public class DatasetSize {
    public static int getSize(String input){
        if (input.equals("S"))
            return 1;
        if (input.equals("M"))
            return 100;
        if (input.equals("B"))
            return 10000;
        else
            return 0;
    }
}