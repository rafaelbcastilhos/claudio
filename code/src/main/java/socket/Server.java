package socket;

import com.opencsv.CSVWriter;
import formatter.Deserializer;
import model.Orders;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        String type = args[0];
        String size = args[1];
        String fileName = "server_".concat(type).concat("_").concat(size).concat(".csv");
        CSVWriter writer = new CSVWriter(new FileWriter(fileName));
        String[] header = {"time_deserialize"};
        writer.writeNext(header);

        ServerSocket serverSocket = new ServerSocket(8081);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = in.readLine();
            System.out.println(request);
            Date initDeserialize = new Date();
            Orders orders = new Deserializer().json(request);
            Date endDeserialize = new Date();

            out.println(orders);
            long timeDeserialize = endDeserialize.getTime() - initDeserialize.getTime();

            String[] row = {
                    String.valueOf(timeDeserialize)
            };
            writer.writeNext(row);

            in.close();
            out.close();
            clientSocket.close();
            writer.close();
            if (orders == null) break;
        }
        serverSocket.close();
    }
}
