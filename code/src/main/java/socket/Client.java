package socket;

import com.opencsv.CSVWriter;
import formatter.Serializer;
import generator.GenerateOrder;
import model.Orders;
import utils.DatasetSize;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws IOException {
        String type = args[0];
        String size = args[1];
        String fileName = "client_".concat(type).concat("_").concat(size).concat(".csv");
        CSVWriter writer = new CSVWriter(new FileWriter(fileName));
        String[] header = {"bytes_serialize", "time_serialize", "time_request"};
        System.out.println(Arrays.toString(header));
        writer.writeNext(header);
        System.out.println("escrevi");

        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        Orders orders = new GenerateOrder().createOrders(DatasetSize.SMALL);

        for (int i = 0; i < 10; i++) {
            clientSocket = new Socket("127.0.0.1", 8081);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Date initSerialize = new Date();
            String serialized = new Serializer().json(orders);
            Date endSerialize = new Date();
            long bytesSerialize = serialized.getBytes().length;

            Date initRequest = new Date();
            out.println(new Serializer().json(orders));
            String resp = in.readLine();
            Date endRequest = new Date();
            System.out.println(resp);

            long timeSerialize = endSerialize.getTime() - initSerialize.getTime();
            long timeRequest = endRequest.getTime() - initRequest.getTime();

            String[] row = {
                    String.valueOf(bytesSerialize),
                    String.valueOf(timeSerialize),
                    String.valueOf(timeRequest)
            };
            writer.writeNext(row);

            in.close();
            out.close();
            clientSocket.close();
        }
        writer.close();
    }
}
