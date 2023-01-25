package formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Orders;
import org.msgpack.core.MessagePack;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MsgPack {
    public byte[] msgPackSerialize(Orders orders) {
        ObjectMapper objectMapper = new MessagePackMapper();
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

    public Orders msgPackDeserialize(byte[] input){
        ObjectMapper objectMapper = new MessagePackMapper();
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
}
