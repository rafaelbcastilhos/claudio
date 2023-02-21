package ufsc.tcc.cco.server;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import database.Item;
import database.Repository;
import model.Orders;
import utils.DatasetMethod;
import utils.Headers;
import java.util.Date;

public class ServerApplication implements
        RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String method = request.getHeaders().get("method");
        String id = request.getHeaders().get("id");
        System.out.println("method: " + method);
        System.out.println("id: " + id);

        System.out.println("headers: " + request.getHeaders());

        String bodyString = null;
        Date initDeserialize = null;
        Date endDeserialize = null;
        Orders deserialized = null;

        if (method.equals("JSON") || method.equals("XML")){
            bodyString = request.getBody();
            initDeserialize = new Date();
            deserialized = new DatasetMethod().deserializeString(method, bodyString);
            endDeserialize = new Date();
        }

        if (method.equals("MSGPACK") || method.equals("KRYO")){
            byte[] is = request.getBody().getBytes();
            initDeserialize = new Date();
            deserialized = new DatasetMethod().deserializeBytes(method, is);
            endDeserialize = new Date();
        }
        long timeDeserialize = endDeserialize.getTime() - initDeserialize.getTime();

        Repository.getInstance().create(new Item(
                id,
                method,
                timeDeserialize
        ));

        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withHeaders(new Headers().getHeaders())
                .withBody(null);
    }
}
