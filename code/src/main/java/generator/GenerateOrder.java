package generator;

import model.Order;
import model.Orders;
import model.Product;
import model.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateOrder {
    public Orders createOrders(int quantity){
        Orders orders = new Orders();
        Products products = new Products();

        for (int j = 0; j < 5; j++)
            products.addProduct(new GenerateProduct().getProducts().get(j));

        for (int i = 0; i < quantity; i++){
            double totalPrice = 0.0;
            for(Product p : products.getProducts())
                totalPrice += p.getPrice() * p.getQuantity();

            Order order = new Order(
                new GeneratePerson().getShippers().get(1),
                    new GeneratePerson().getTransporters().get(1),
                    new GeneratePerson().getDestinators().get(1),
                    products,
                    totalPrice,
                    getDeliveryMethod(new Random().nextInt(5))
            );
            orders.addOrder(order);
        }

        return orders;
    }

    private String getDeliveryMethod(int index){
        List<String> list = List.of("Sedex", "PAC", "Express", "Retira", "Dropoff");
        return list.get(index);
    }
}
