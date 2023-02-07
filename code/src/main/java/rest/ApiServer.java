package rest;

import formatter.Deserializer;
import model.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ApiServer {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Orders root(HttpServletRequest request) throws IOException {
        return new Deserializer().json(request.getReader().lines().reduce("",String::concat));
    }
}
