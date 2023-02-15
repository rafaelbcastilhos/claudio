package rest;

import database.Item;
import database.Repository;
import model.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.DatasetMethod;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Controller
public class ApiServer {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Object root(HttpServletRequest request) throws IOException {
        String method = request.getHeader("method");
        String id = request.getHeader("id");
        System.out.println("method: " + method);

        String bodyString = null;
        byte[] bodyBytes = null;
        Date initDeserialize = null;
        Date endDeserialize = null;
        Orders deserialized = null;
        if (method.equals("JSON") || method.equals("XML")){
            bodyString = request.getReader().lines().reduce("",String::concat);
            initDeserialize = new Date();
            deserialized = new DatasetMethod().deserializeString(method, bodyString);
            endDeserialize = new Date();
        }

        if (method.equals("MSGPACK") || method.equals("KRYO")){
            InputStream is = request.getInputStream();
            bodyBytes = is.readAllBytes();
            initDeserialize = new Date();
            deserialized = new DatasetMethod().deserializeBytes(method, bodyBytes);
            endDeserialize = new Date();
        }
        long timeDeserialize = endDeserialize.getTime() - initDeserialize.getTime();

        Item item = Repository.getInstance().get(id);
        item.setTimeDeserialize(timeDeserialize);
        Repository.getInstance().update(item);

        return deserialized;
    }
}
