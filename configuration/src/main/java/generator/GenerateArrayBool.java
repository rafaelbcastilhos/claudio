package generator;

import model.Orders;
import model.Product;
import java.util.List;
import java.util.Random;

public class GenerateArrayBool implements Generator {
    public Orders generate(int quantity){
        List<Product> prods = new GenerateProduct().getProducts();
        Orders bools = new Orders();

        for (int i = 0; i < quantity; i++)
            bools.addOrder(prods.get(new Random().nextInt(10)).getOnSale());

        return bools;
    }
}
