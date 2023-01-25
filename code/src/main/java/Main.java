import formatter.KryoJava;
import formatter.MsgPack;
import formatter.Xml;
import generator.GenerateOrder;
import formatter.Json;
import model.Orders;

public class Main {
    public static void main(String[] args) {
        Orders orders = new GenerateOrder().createOrders(1);

        System.out.println("JSON");
        String jsonString = new Json().gsonSerialize(orders);
        Orders jsonObject = new Json().gsonDeserialize(jsonString);
        System.out.println("================================");
        System.out.println("XML");
        String xmlString = new Xml().jacksonSerialize(orders);
        Orders xmlObject = new Xml().jacksonDeserialize(xmlString);
        System.out.println("================================");
        System.out.println("KRYO");
        byte[] kryoByte = new KryoJava().kryoSerialize(orders);
        Orders kryoObject = new KryoJava().kryoDeserialize(kryoByte);
        System.out.println("================================");
        System.out.println("MSGPACK");
        byte[] msgPackByte = new MsgPack().msgPackSerialize(orders);
        Orders msgPackObject = new MsgPack().msgPackDeserialize(msgPackByte);
    }
}
