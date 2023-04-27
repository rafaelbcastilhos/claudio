import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LocalClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        // STRUCT S JSON localhost:8080
        // Recebe os argumentos passados por linha de comando
//        String type = args[0]; // tipo de dados para serem serializados
//        String size = args[1]; // tamanho dos dados para serem serializados
//        String method = args[2]; // método de serialização a ser utilizado
//        String to = args[3]; // URL do servidor que receberá a requisição

        // Cria um cliente HTTP utilizando a biblioteca OkHttpClient
        OkHttpClient ok = new OkHttpClient();
        ok.setConnectTimeout(30, TimeUnit.SECONDS); // configura o timeout de conexão
        ok.setWriteTimeout(30, TimeUnit.SECONDS); // configura o timeout de escrita
        ok.setReadTimeout(30, TimeUnit.SECONDS); // configura o timeout de leitura

        // Cria um objeto RequestBody vazio para ser utilizado nas requisições
        RequestBody reqbody = RequestBody.create(null, new byte[0]);

        for (Configuration configuration: configurationRequest()){
            // Loop que envia 10 requisições ao servidor
            for (int i = 0; i < 1; i++) {
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
//        methods.add("JSON");methods.add("XML");
        methods.add("MSGPACK");
//        methods.add("KRYO");
        ArrayList<String> types = new ArrayList<>();
        types.add("STRUCT");
//        types.add("STRING");types.add("CHAR");types.add("DOUBLE");types.add("INTEGER");types.add("BOOL");
        ArrayList<String> sizes = new ArrayList<>();
        sizes.add("S");
        sizes.add("M");
        sizes.add("B");

        for (String type : types) {
            for (String size : sizes) {
                for (String method : methods) {
                    Configuration configuration = new Configuration(
                            type,
                            size,
                            method,
                            "https://y0r12wthq0.execute-api.us-east-1.amazonaws.com/v1/client",
                            "https://y0r12wthq0.execute-api.us-east-1.amazonaws.com/v1/server"
                    );
                    list.add(configuration);
                }
            }
        }
        return list;
    }
}
