package generator;

import model.Orders;
import model.Product;
import java.util.List;
import java.util.Random;

public class GenerateArrayString implements Generator {
    public Orders generate(int quantity){
        List<Product> prods = new GenerateProduct().getProducts();
        Orders strings = new Orders();

        for (int i = 0; i < quantity; i++)
            strings.addOrder(prods.get(new Random().nextInt(10)).getDescription());

        return strings;
    }
}
