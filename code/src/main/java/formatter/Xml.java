package formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.*;
import java.util.Date;

public class Xml {
    public String jacksonSerialize(Orders orders){
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

    public Orders jacksonDeserialize(String input){
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
}
