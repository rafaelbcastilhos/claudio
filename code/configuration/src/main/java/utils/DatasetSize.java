package utils;

public class DatasetSize {
    public static int getSize(String input){
        if (input.equals("S"))
            return SMALL;
        if (input.equals("M"))
            return MEDIUM;
        if (input.equals("B"))
            return BIG;
        else
            return 0;
    }
    public static final int SMALL = 100,
            MEDIUM = 1000,
            BIG = 100000;
}