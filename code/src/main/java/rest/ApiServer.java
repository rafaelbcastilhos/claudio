package rest;

import com.opencsv.CSVWriter;
import formatter.Deserializer;
import model.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Controller
public class ApiServer {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Orders root(HttpServletRequest request) throws IOException {
        String fileName = "server_".concat(".csv");
        CSVWriter writer = new CSVWriter(new FileWriter(fileName, true));
        String[] header = {"time_deserialize"};
        writer.writeNext(header);
        Date initDeserialize = new Date();
        Orders orders = new Deserializer().json(request.getReader().lines().reduce("",String::concat));
        Date endDeserialize = new Date();

        long timeDeserialize = endDeserialize.getTime() - initDeserialize.getTime();

        String[] row = {
                String.valueOf(timeDeserialize)
        };
        writer.writeNext(row);
        return orders;
    }
}
