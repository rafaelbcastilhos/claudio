import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LocalClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        // STRUCT S JSON M localhost:8080
        String type = args[0];
        String size = args[1];
        String method = args[2];
        String distance = args[3];
        String to = args[4];
        OkHttpClient ok = new OkHttpClient();
        RequestBody reqbody = RequestBody.create(null, new byte[0]);
        for (int i = 0; i < 10; i++) {
            Request request = new Request.Builder()
                    .url("https://bvfntueu6e.execute-api.us-east-1.amazonaws.com/v1/client")
                    .method("POST", reqbody)
                    .addHeader("method", method)
                    .addHeader("type", type)
                    .addHeader("size", size)
                    .addHeader("distance", distance)
                    .addHeader("to", to)
                    .build();
            Response response = ok.newCall(request).execute();
            System.out.println(response.code());
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
