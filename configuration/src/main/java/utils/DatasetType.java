package utils;

import generator.*;
import model.Orders;

public class DatasetType {
    // Verifica o tipo de dados fornecido e chama o método de geração apropriado com o tamanho fornecido.
    public Orders getType(String type, String size){
        if (type.equals("BOOL"))
            return new GenerateArrayBool().generate(Integer.parseInt(size));
        if (type.equals("INTEGER"))
            return new GenerateArrayInteger().generate(Integer.parseInt(size));
        if (type.equals("DOUBLE"))
            return new GenerateArrayDouble().generate(Integer.parseInt(size));
        if (type.equals("CHAR"))
            return new GenerateArrayChar().generate(Integer.parseInt(size));
        if (type.equals("STRING"))
            return new GenerateArrayString().generate(Integer.parseInt(size));
        if (type.equals("STRUCT"))
            return new GenerateOrder().generate(Integer.parseInt(size));
        // Se o tipo de dados fornecido não for válido, retorna nulo.
        else return null;
    }
}
