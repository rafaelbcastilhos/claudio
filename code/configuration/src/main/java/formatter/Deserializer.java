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

public class Deserializer {
    public Orders json(String input){
        return new Gson().fromJson(input, Orders.class);
    }

    public Orders xml(String input){
        XmlMapper mapper = new XmlMapper();
        try {
            return mapper.readValue(input, Orders.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Orders msgPack(byte[] input){
        ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory().setReuseResourceInParser(false));
        Orders deserialized = null;
        try {
            deserialized = objectMapper.readValue(input, Orders.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return deserialized;
    }

    public Orders kryo(byte[] input){
        Kryo kryo = new Kryo();
        Input serialized = new Input(input);
        return kryo.readObject(serialized, Orders.class);
    }
}
