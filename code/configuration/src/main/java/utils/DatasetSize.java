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
    public static final int SMALL = 100, // 100 items no array
            MEDIUM = 1000, // 1000 items no array
            BIG = 100000; // 100000 items no array
}