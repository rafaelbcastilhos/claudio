package rest;

import com.squareup.okhttp.Request;

public class ClientLambda {
    public static void main(String[] args) {
        String type = args[0];
        String size = args[1];
        String method = args[2];
        for (int i = 0; i < 10; i++) {
            Request request = new Request.Builder()
                    .url("http://aws.api.client.endpoint:8080/")
                    .method("POST", null)
                    .addHeader("method", method)
                    .addHeader("type", type)
                    .addHeader("size", size)
                    .build();
        }
    }
}
