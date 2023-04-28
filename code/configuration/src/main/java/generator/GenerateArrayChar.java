package generator;

import model.Orders;
import java.util.Random;

public class GenerateArrayChar implements Generator {
    public Orders generate(int quantity){
        Orders chars = new Orders();

        for (int i = 0; i < quantity; i++)
            chars.addOrder(new GenerateOrder().getDeliveryMethod(new Random().nextInt(5)));

        return chars;
    }
}
