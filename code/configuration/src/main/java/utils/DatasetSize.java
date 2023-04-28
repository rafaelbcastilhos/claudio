package utils;

public class DatasetSize {
    public int getSize(String input){
        if (input.equals("1"))
            return 1;
        if (input.equals("100"))
            return 100;
        if (input.equals("1000"))
            return 1000;
        else
            return 0;
    }
}