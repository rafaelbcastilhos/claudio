package utils;

import formatter.Deserializer;
import formatter.Serializer;
import model.Orders;
import java.util.Arrays;

public class DatasetMethod {
    // Método responsável por serializar um objeto Orders em formato de string, de acordo com o método especificado
    public String serializeString(String method, Orders orders) {
        if (method.equals("JSON"))
            return new Serializer().json(orders);
        if (method.equals("XML"))
            return new Serializer().xml(orders);
        else
            return null;
    }

    // Método responsável por serializar um objeto Orders em formato de array de bytes, de acordo com o método especificado
    public byte[] serializeBytes(String method, Orders orders) {
        if (method.equals("MSGPACK"))
            return new Serializer().msgPack(orders);
        if (method.equals("KRYO"))
            return new Serializer().kryo(orders);
        else
            return null;
    }

    // Método responsável por desserializar uma string em formato de objeto Orders, de acordo com o método especificado
    public Orders deserializeString(String method, String orders) {
        if (method.equals("JSON"))
            return new Deserializer().json(orders);
        if (method.equals("XML"))
            return new Deserializer().xml(orders);
        else
            return null;
    }

    // Método responsável por desserializar um array de bytes em formato de objeto Orders, de acordo com o método especificado
    public Orders deserializeBytes(String method, byte[] orders) {
        if (method.equals("MSGPACK"))
            return new Deserializer().msgPack(orders);
        if (method.equals("KRYO")){
            System.out.println(Arrays.toString(orders));
            return new Deserializer().kryo(orders);
        }
        else
            return null;
    }
}
