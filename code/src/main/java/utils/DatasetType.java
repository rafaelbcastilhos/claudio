package utils;

import generator.*;
import model.Orders;

public class DatasetType {
    public Orders getType(String type, String size){
        if (type.equals("BOOL"))
            return new GenerateArrayBool().generate(DatasetSize.getSize(size));
        if (type.equals("INTEGER"))
            return new GenerateArrayInteger().generate(DatasetSize.getSize(size));
        if (type.equals("DOUBLE"))
            return new GenerateArrayDouble().generate(DatasetSize.getSize(size));
        if (type.equals("CHAR"))
            return new GenerateArrayChar().generate(DatasetSize.getSize(size));
        if (type.equals("STRING"))
            return new GenerateArrayString().generate(DatasetSize.getSize(size));
        if (type.equals("STRUCT"))
            return new GenerateOrder().generate(DatasetSize.getSize(size));
        else return null;
    }
}
