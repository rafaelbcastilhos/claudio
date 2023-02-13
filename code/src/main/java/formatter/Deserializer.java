package formatter;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import model.Orders;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import java.io.IOException;
import java.util.Date;

public class Deserializer {
    public Orders json(String input){
        Date init = new Date();
        Orders request = new Gson().fromJson(input, Orders.class);
        Date end = new Date();
        System.out.println(end.getTime()-init.getTime());
        return request;
    }

    public Orders xml(String input){
        XmlMapper mapper = new XmlMapper();
        try {
            Date init = new Date();
            Orders value = mapper.readValue(input, Orders.class);
            Date end = new Date();
            System.out.println(end.getTime()-init.getTime());
            return value;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Orders msgPack(byte[] input){
        ObjectMapper  objectMapper = new ObjectMapper(new MessagePackFactory().setReuseResourceInParser(false));
        Date init = new Date();
        Orders deserialized = null;
        try {
            deserialized = objectMapper.readValue(input, Orders.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Date end = new Date();
        System.out.println(end.getTime()-init.getTime());
        return deserialized;
    }

    public Orders kryo(byte[] input){
        Kryo kryo = new Kryo();

        Input serialized = new Input(input);
        Date init = new Date();
        Orders orders = kryo.readObject(serialized, Orders.class);
        Date end = new Date();
        System.out.println(end.getTime()-init.getTime());
        return orders;
    }
}
