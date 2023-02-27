import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LocalClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        // STRUCT S JSON localhost:8080
        // Recebe os argumentos passados por linha de comando
        String type = args[0]; // tipo de dados para serem serializados
        String size = args[1]; // tamanho dos dados para serem serializados
        String method = args[2]; // método de serialização a ser utilizado
        String to = args[3]; // URL do servidor que receberá a requisição

        // Cria um cliente HTTP utilizando a biblioteca OkHttpClient
        OkHttpClient ok = new OkHttpClient();
        ok.setConnectTimeout(30, TimeUnit.SECONDS); // configura o timeout de conexão
        ok.setWriteTimeout(30, TimeUnit.SECONDS); // configura o timeout de escrita
        ok.setReadTimeout(30, TimeUnit.SECONDS); // configura o timeout de leitura

        // Cria um objeto RequestBody vazio para ser utilizado nas requisições
        RequestBody reqbody = RequestBody.create(null, new byte[0]);

        // Loop que envia 10 requisições ao servidor
        for (int i = 0; i < 10; i++) {
            // Cria um objeto Request com as informações necessárias
            Request request = new Request.Builder()
                    .url("http://52.86.15.16:8080/client") // URL do servidor
                    .method("POST", reqbody) // método HTTP POST
                    .addHeader("method", method) // adiciona o método de serialização na requisição
                    .addHeader("type", type) // adiciona o tipo de dados na requisição
                    .addHeader("size", size) // adiciona o tamanho dos dados na requisição
                    .addHeader("to", to) // adiciona a URL do servidor de destino na requisição
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
