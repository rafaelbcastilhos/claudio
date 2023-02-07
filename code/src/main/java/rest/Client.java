package rest;

import com.squareup.okhttp.*;
import formatter.Serializer;
import generator.GenerateOrder;
import model.Orders;
import utils.DatasetSize;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
//        String method = args[0];
//        int size = Integer.parseInt(args[1]);
        Orders orders = new GenerateOrder().createOrders(DatasetSize.SMALL);
//        if (method.equals("INTEGER")) {}
//        if (method.equals("DOUBLE")) {}
//        if (method.equals("STRING")) {}
//        if (method.equals("STRUCT")) {}
        OkHttpClient ok = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, new Serializer().json(orders));
        Request request = new Request.Builder()
                .url("http://localhost:8080/")
                .method("POST", requestBody)
                .build();

        System.out.println("request: " + request);

        Response response = ok.newCall(request).execute();
        System.out.println("response: " + response.body().string());
    }
}
