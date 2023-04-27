package ufsc.tcc.cco.client;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.squareup.okhttp.*;
import database.Item;
import database.Repository;
import model.Orders;
import utils.DatasetMethod;
import utils.DatasetType;
import utils.Headers;
import java.io.IOException;
import java.util.*;

public class ClientApplication implements
        RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String type = request.getHeaders().get("type");
        String size = request.getHeaders().get("size");
        String method = request.getHeaders().get("method");
        String to = request.getHeaders().get("to");
        String id = UUID.randomUUID().toString();

        // Create an Orders object based on the "type" and "size" headers using DatasetType class
        Orders obj = new DatasetType().getType(type, size);
        System.out.println("size: " + obj.getOrders().size());

        OkHttpClient ok = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = null;
        Date initSerialize = null;
        Date endSerialize = null;
        long bytesSerialize = 0;

        // Serialize the Orders object based on the "method" header using DatasetMethod class
        if (method.equals("JSON") || method.equals("XML")){
            initSerialize = new Date();
            String serialized = new DatasetMethod().serializeString(method, obj);
            System.out.println("serialize: " + serialized);
            endSerialize = new Date();
            bytesSerialize = serialized.getBytes().length;
            requestBody = RequestBody.create(mediaType, serialized);
        }

        if (method.equals("MSGPACK") || method.equals("KRYO")){
            initSerialize = new Date();
            byte[] serialized = new DatasetMethod().serializeBytes(method, obj);
            endSerialize = new Date();
            bytesSerialize = serialized.length;
            String base64Data = Base64.getEncoder().encodeToString(serialized);

            requestBody = RequestBody.create(mediaType, base64Data);
        }
        Request requestClient = new Request.Builder()
                .url(to)
                .method("POST", requestBody)
                .addHeader("method", method)
                .addHeader("id", id)
                .build();

        System.out.println("request: " + requestClient);
        System.out.println("headers: " + request.getHeaders());

        Date initRequest = new Date();
        Response response = null;
        try {
            response = ok.newCall(requestClient).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Date endRequest = new Date();

        // Calculate the time taken to serialize
        long timeSerialize = endSerialize.getTime() - initSerialize.getTime();

        // Calculate the time taken to request
        long timeRequest = endRequest.getTime() - initRequest.getTime();
        System.out.println("response: " + response.code());

        Item item = Repository.getInstance().get(id);
        item.setType(type);
        item.setSize(size);
        item.setBytesSerialize(bytesSerialize);
        item.setTimeSerialize(timeSerialize);
        item.setTimeRequest(timeRequest);
        Repository.getInstance().update(item);

        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withHeaders(new Headers().getHeaders())
                .withBody(null);
    }
}
