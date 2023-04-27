import formatter.Deserializer;
import formatter.Serializer;
import generator.GenerateOrder;
import model.Orders;
import utils.DatasetSize;

public class Main {
    public static void main(String[] args) {
        Orders orders = new GenerateOrder().generate(10);

        System.out.println("JSON");
        String jsonString = new Serializer().json(orders);
        Orders jsonObject = new Deserializer().json(jsonString);
        System.out.println("================================");
        System.out.println("XML");
        String xmlString = new Serializer().xml(orders);
        Orders xmlObject = new Deserializer().xml(xmlString);
        System.out.println("================================");
        System.out.println("KRYO");
        byte[] kryoByte = new Serializer().kryo(orders);
        Orders kryoObject = new Deserializer().kryo(kryoByte);
        System.out.println("================================");
        System.out.println("MSGPACK");
        byte[] msgPackByte = new Serializer().msgPack(orders);
        Orders msgPackObject = new Deserializer().msgPack(msgPackByte);
    }
}
