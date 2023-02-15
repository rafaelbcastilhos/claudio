package generator;

import model.Orders;
import model.Product;
import java.util.List;
import java.util.Random;

public class GenerateArrayInteger {
    public Orders createIntegers(int quantity){
        List<Product> prods = new GenerateProduct().getProducts();
        Orders ints = new Orders();

        for (int i = 0; i < quantity; i++)
            ints.addOrder(prods.get(new Random().nextInt(quantity)).getRating());

        return ints;
    }
}
