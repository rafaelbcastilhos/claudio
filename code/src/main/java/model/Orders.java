package model;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders = new ArrayList<>();

    public Orders() {}

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
