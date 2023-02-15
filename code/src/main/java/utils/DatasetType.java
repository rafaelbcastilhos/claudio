package utils;

import generator.GenerateArrayInteger;
import generator.GenerateOrder;
import model.Orders;

public class DatasetType {
    public Orders getType(String type, String size){
//        if (type.equals("BOOL")) {}
        if (type.equals("INTEGER"))
            return new GenerateArrayInteger().createIntegers(DatasetSize.getSize(size));
//        if (type.equals("DOUBLE")) {}
//        if (type.equals("CHAR")) {}
//        if (type.equals("STRING")) {}
        if (type.equals("STRUCT"))
            return new GenerateOrder().createOrders(DatasetSize.getSize(size));
        else return null;
    }
}
