package formatter;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import model.Orders;

import java.io.ByteArrayOutputStream;
import java.util.Date;

public class KryoJava {
    public byte[] kryoSerialize(Orders orders){
        Kryo kryo = new Kryo();
        Date init = new Date();
        Output output =
                new Output(new ByteArrayOutputStream(), 1024 * 100000);
        kryo.writeObject(output, orders);
        byte[] serialized = output.toBytes();
        Date end = new Date();
        System.out.println(end.getTime()-init.getTime() + " - " + serialized.length);
        return serialized;
    }

    public Orders kryoDeserialize(byte[] input){
        Kryo kryo = new Kryo();

        Input serialized = new Input(input);
        Date init = new Date();
        Orders orders = kryo.readObject(serialized, Orders.class);
        Date end = new Date();
        System.out.println(end.getTime()-init.getTime());
        return orders;
    }
}
