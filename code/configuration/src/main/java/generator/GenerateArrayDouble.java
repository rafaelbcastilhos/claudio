package generator;

import model.Orders;
import model.Product;
import java.util.List;
import java.util.Random;

public class GenerateArrayDouble implements Generator {
    public Orders generate(int quantity){
        List<Product> prods = new GenerateProduct().getProducts();
        Orders doubles = new Orders();

        for (int i = 0; i < quantity; i++)
            doubles.addOrder(prods.get(new Random().nextInt(10)).getPrice());

        return doubles;
    }
}
