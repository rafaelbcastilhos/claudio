package rest;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        String method = args[0];
        int size = Integer.parseInt(args[1]);

        if (method.equals("INTEGER")) {}
        if (method.equals("DOUBLE")) {}
        if (method.equals("STRING")) {}
        if (method.equals("STRUCT")) {}
        OkHttpClient ok = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://ip")
                .method("POST", null)
                .build();

        System.out.println("request: " + request);

        Response response = ok.newCall(request).execute();
        System.out.println("response: " + response);
    }
}
