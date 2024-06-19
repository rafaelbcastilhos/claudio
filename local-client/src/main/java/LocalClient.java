import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LocalClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Cria um cliente HTTP utilizando a biblioteca OkHttpClient
        OkHttpClient ok = new OkHttpClient();
        ok.setConnectTimeout(30, TimeUnit.SECONDS); // configur a o timeout de conexão
        ok.setWriteTimeout(30, TimeUnit.SECONDS); // configura o timeout de escrita
        ok.setReadTimeout(30, TimeUnit.SECONDS); // configura o timeout de leitura

        // Cria um objeto RequestBody vazio para ser utilizado nas requisições
        RequestBody reqbody = RequestBody.create(null, new byte[0]);

        for (Configuration configuration: configurationRequest()){
            // Loop que envia 100 requisições ao servidor
            for (int i = 0; i < 100; i++) {
                // Cria um objeto Request com as informações necessárias
                Request request = new Request.Builder()
                        .url(configuration.getFrom()) // URL do servidor
                        .method("POST", reqbody) // método HTTP POST
                        .addHeader("method", configuration.getMethod()) // adiciona o método de serialização na requisição
                        .addHeader("type", configuration.getType()) // adiciona o tipo de dados na requisição
                        .addHeader("size", configuration.getSize()) // adiciona o tamanho dos dados na requisição
                        .addHeader("to", configuration.getTo()) // adiciona a URL do servidor de destino na requisição
                        .build();

                // Executa a requisição e recebe a resposta
                Response response = ok.newCall(request).execute();

                // Imprime o código HTTP da resposta
                System.out.println(response.code());

                // Aguarda 1 segundo antes de enviar a próxima requisição
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    public static ArrayList<Configuration> configurationRequest(){
        ArrayList<Configuration> list = new ArrayList<>();
        ArrayList<String> methods = new ArrayList<>();
        methods.add("JSON");
        methods.add("XML");
        methods.add("MSGPACK");
        methods.add("KRYO");
        ArrayList<String> types = new ArrayList<>();
        types.add("STRUCT");
        types.add("STRING");
        types.add("CHAR");
        types.add("DOUBLE");
        types.add("INTEGER");
        types.add("BOOL");
        ArrayList<String> sizes = new ArrayList<>();
        sizes.add("1");
        sizes.add("100");
        sizes.add("1000");

        for (String type : types) {
            for (String size : sizes) {
                for (String method : methods) {
                    Configuration configuration = new Configuration(
                            type,
                            size,
                            method,
                            "http://address_client/client", // Substituir address_client pelo IP ou endereço do cliente
                            "http://address_server/server" // Substituir address_server pelo IP ou endereço do servidor
                    );
                    list.add(configuration);
                }
            }
        }
        return list;
    }
}
