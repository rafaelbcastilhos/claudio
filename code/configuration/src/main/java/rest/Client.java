package rest;

import com.squareup.okhttp.*;
import database.Item;
import database.Repository;
import model.Orders;
import utils.DatasetMethod;
import utils.DatasetType;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class Client {
    public static void main(String[] args) throws IOException {
        String type = args[0];
        String size = args[1];
        String method = args[2];
        String id = UUID.randomUUID().toString();

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
                System.out.println("serialize: " + Arrays.toString(serialized));
                endSerialize = new Date();
                bytesSerialize = serialized.length;
                requestBody = RequestBody.create(mediaType, serialized);
            }
            Request request = new Request.Builder()
                    .url("http://localhost:8080/")
                    .method("POST", requestBody)
                    .addHeader("method", method)
                    .addHeader("id", id)
                    .build();

            System.out.println("request: " + request);

            Date initRequest = new Date();
            Response response = ok.newCall(request).execute();
            Date endRequest = new Date();
            long timeSerialize = endSerialize.getTime() - initSerialize.getTime();
            long timeRequest = endRequest.getTime() - initRequest.getTime();
            System.out.println("response: " + response.code());

//            Repository.getInstance().create(new Item(
//                    id,
//                    type,
//                    size,
//                    method,
//                    bytesSerialize,
//                    timeSerialize,
//                    timeRequest
//            ));
        }
    }
}
