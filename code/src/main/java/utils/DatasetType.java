package utils;

import generator.GenerateOrder;

public class DatasetType {
    public static Object getType(String type, String size){
//        if (type.equals("BOOL")) {}
//        if (type.equals("INTEGER")) {}
//        if (type.equals("DOUBLE")) {}
//        if (type.equals("CHAR")) {}
//        if (type.equals("STRING")) {}
        if (type.equals("STRUCT")) {
            return new GenerateOrder().createOrders(DatasetSize.getSize(size));
        }
        else return null;
    }
}
