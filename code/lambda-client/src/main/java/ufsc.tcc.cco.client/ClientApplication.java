package ufsc.tcc.cco.client;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.squareup.okhttp.*;
import model.Orders;
import utils.DatasetMethod;
import utils.DatasetType;
import java.io.IOException;
import java.util.*;

public class ClientApplication implements
        RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String type = request.getHeaders().get("type");
        String size = request.getHeaders().get("size");
        String method = request.getHeaders().get("method");
        String id = UUID.randomUUID().toString();

        Orders obj = new DatasetType().getType(type, size);

        OkHttpClient ok = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
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
        Request requestClient = new Request.Builder()
                .url("http://aws.server.api.endpoint/")
                .method("POST", requestBody)
                .addHeader("method", method)
                .addHeader("id", id)
                .build();

        System.out.println("request: " + requestClient);

        Date initRequest = new Date();
        Response response = null;
        try {
            response = ok.newCall(requestClient).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Date endRequest = new Date();
        long timeSerialize = endSerialize.getTime() - initSerialize.getTime();
        long timeRequest = endRequest.getTime() - initRequest.getTime();
        System.out.println("response: " + response.code());

//        Repository.getInstance().create(new Item(
//                id,
//                type,
//                size,
//                method,
//                bytesSerialize,
//                timeSerialize,
//                timeRequest
//        ));


        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Access-Control-Allow-Origin", "*");
        header.put("Access-Control-Allow-Headers", "*");
        header.put("Access-Control-Allow-Methods", "OPTIONS,POST,GET");
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withHeaders(header)
                .withBody(null);
    }
}
