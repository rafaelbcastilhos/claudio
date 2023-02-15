package model;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Object> array = new ArrayList<>();

    public Orders() {}

    public void addOrder(Object order) {
        this.array.add(order);
    }

    public List<Object> getOrders() {
        return array;
    }
}
