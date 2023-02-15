package formatter;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import model.Orders;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Serializer {
    public String json(Orders orders){
        return new Gson().toJson(orders);
    }

    public String xml(Orders orders){
        XmlMapper mapper = new XmlMapper();
        try {
            return mapper.writeValueAsString(orders);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] msgPack(Orders orders) {
        ObjectMapper  objectMapper = new ObjectMapper(new MessagePackFactory().setReuseResourceInParser(false));
        Map<String, Object> map = new HashMap<>();
        map.put("orders", orders.getOrders());
        byte[] bs;
        try {
            bs = objectMapper.writeValueAsBytes(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return bs;
    }

    public byte[] kryo(Orders orders){
        Kryo kryo = new Kryo();
        Output output =
                new Output(new ByteArrayOutputStream(), 1024 * 100000);
        kryo.writeObject(output, orders);
        return output.toBytes();
    }
}
