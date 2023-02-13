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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Serializer {
    public String json(Orders orders){
        Date init = new Date();
        String gson = new Gson().toJson(orders);
        Date end = new Date();
        return gson;
    }

    public String xml(Orders orders){
        XmlMapper mapper = new XmlMapper();
        try {
            Date init = new Date();
            String xml = mapper.writeValueAsString(orders);
            Date end = new Date();
            System.out.println(end.getTime()-init.getTime() + " - " + xml.getBytes().length);
            return xml;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] msgPack(Orders orders) {
        ObjectMapper  objectMapper = new ObjectMapper(new MessagePackFactory().setReuseResourceInParser(false));
        Map<String, Object> map = new HashMap<>();
        map.put("orders", orders.getOrders());
        Date init = new Date();
        byte[] bs;
        try {
            bs = objectMapper.writeValueAsBytes(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Date end = new Date();
        System.out.println(end.getTime() - init.getTime() + " - " + bs.length);
        return bs;
    }

    public byte[] kryo(Orders orders){
        Kryo kryo = new Kryo();
        Date init = new Date();
        Output output =
                new Output(new ByteArrayOutputStream(), 1024 * 100000);
        kryo.writeObject(output, orders);
        byte[] serialized = output.toBytes();
        Date end = new Date();
        System.out.println(end.getTime()-init.getTime() + " - " + serialized.length);
        return serialized;
    }
}
