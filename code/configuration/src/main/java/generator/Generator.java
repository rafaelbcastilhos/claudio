package generator;

import model.Orders;

public interface Generator {
    Orders generate(int quantity);
}
