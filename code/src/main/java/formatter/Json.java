package formatter;

import com.google.gson.Gson;
import model.Orders;
import java.util.Date;

public class Json {
    public String gsonSerialize(Orders orders){
        Date init = new Date();
        String gson = new Gson().toJson(orders);
        Date end = new Date();
        System.out.println(end.getTime()-init.getTime() + " - " + gson.getBytes().length);
        return gson;
    }

    public Orders gsonDeserialize(String input){
        Date init = new Date();
        Orders request = new Gson().fromJson(input, Orders.class);
        Date end = new Date();
        System.out.println(end.getTime()-init.getTime());
        return request;
    }
}
