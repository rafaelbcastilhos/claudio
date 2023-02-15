package rest;

import com.opencsv.CSVWriter;
import com.squareup.okhttp.*;
import model.Orders;
import utils.DatasetMethod;
import utils.DatasetType;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws IOException {
        String type = args[0];
        String size = args[1];
        String method = args[2];
        String fileName = "client_".concat(type).concat("_").concat(size).concat(".csv");
        CSVWriter writer = new CSVWriter(new FileWriter(fileName));
        String[] header = {"bytes_serialize", "time_serialize", "time_request"};
        writer.writeNext(header);

        Orders obj = new DatasetType().getType(type, size);

        OkHttpClient ok = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        for (int i = 0; i < 10; i++) {
            RequestBody requestBody = null;
            Date initSerialize = null;
            Date endSerialize = null;
            long bytesSerialize = 0;
            if (method.equals("JSON") || method.equals("XML")){
                initSerialize = new Date();
                String serialized = new DatasetMethod().serializeString(method, obj).toString();
                System.out.println("serialize: " + serialized);
                endSerialize = new Date();
                bytesSerialize = serialized.getBytes().length;
                requestBody = RequestBody.create(mediaType, serialized);
            }

            if (method.equals("MSGPACK") || method.equals("KRYO")){
                initSerialize = new Date();
                byte[] serialized = new DatasetMethod().serializeBytes(method, obj);
                System.out.println("serialize: " + serialized);
                endSerialize = new Date();
                bytesSerialize = serialized.length;
                requestBody = RequestBody.create(mediaType, serialized);
            }
            Request request = new Request.Builder()
                    .url("http://localhost:8080/")
                    .method("POST", requestBody)
                    .addHeader("method", method)
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
