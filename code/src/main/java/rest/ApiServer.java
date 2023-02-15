package rest;

import com.opencsv.CSVWriter;
import model.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.DatasetMethod;
import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Controller
public class ApiServer {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Object root(HttpServletRequest request) throws IOException {
        String method = request.getHeader("method");
        System.out.println("method: " + method);
        String fileName = "server_".concat(".csv");
        CSVWriter writer = new CSVWriter(new FileWriter(fileName, true));
        String[] header = {"time_deserialize"};
        writer.writeNext(header);

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

        String[] row = {
                String.valueOf(timeDeserialize)
        };
        writer.writeNext(row);
        return deserialized;
    }
}
