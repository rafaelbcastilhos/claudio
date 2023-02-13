package rest;

import com.opencsv.CSVWriter;
import com.squareup.okhttp.*;
import formatter.Serializer;
import generator.GenerateOrder;
import model.Orders;
import utils.DatasetSize;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws IOException {
        String type = args[0];
        String size = args[1];
        String fileName = "client_".concat(type).concat("_").concat(size).concat(".csv");
        CSVWriter writer = new CSVWriter(new FileWriter(fileName));
        String[] header = {"bytes_serialize", "time_serialize", "time_request"};
        writer.writeNext(header);

        Orders orders = new GenerateOrder().createOrders(DatasetSize.SMALL);

        OkHttpClient ok = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        for (int i = 0; i < 10; i++) {
            Date initSerialize = new Date();
            String serialized = new Serializer().json(orders);
            Date endSerialize = new Date();
            long bytesSerialize = serialized.getBytes().length;

            RequestBody requestBody = RequestBody.create(mediaType, serialized);
            Request request = new Request.Builder()
                    .url("http://localhost:8080/")
                    .method("POST", requestBody)
                    .build();

            System.out.println("request: " + request);

            Date initRequest = new Date();
            Response response = ok.newCall(request).execute();
            Date endRequest = new Date();
            long timeSerialize = endSerialize.getTime() - initSerialize.getTime();
            long timeRequest = endRequest.getTime() - initRequest.getTime();
            System.out.println("response: " + response.body().string());
            String[] row = {
                    String.valueOf(bytesSerialize),
                    String.valueOf(timeSerialize),
                    String.valueOf(timeRequest)
            };
            writer.writeNext(row);
        }
    }
}
