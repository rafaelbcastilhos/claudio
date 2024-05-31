package generator;

import model.Orders;
import model.Product;
import java.util.List;
import java.util.Random;

public class GenerateArrayInteger implements Generator {
    public Orders generate(int quantity){
        List<Product> prods = new GenerateProduct().getProducts();
        Orders ints = new Orders();

        for (int i = 0; i < quantity; i++)
            ints.addOrder(prods.get(new Random().nextInt(10)).getRating());

        return ints;
    }
}
