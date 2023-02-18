package generator;

import model.Product;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateProduct {
    private final List<Product> products = generate();

    public List<Product> getProducts() {
        return products;
    }

    private List<Product> generate(){
        Product product1 = new Product(
                "Processador AMD Ryzen 5 5600X, 3.7GHz (4.6GHz Max Turbo), Cache 35MB, 6 Núcleos, 12 Threads",
                1169.99,
                new Random().nextInt(10),
                "Tecnologia",
                5,
                false
        );

        Product product2 = new Product(
                "Smart TV 43 Polegadas LED 4K UHD, 3 HDMI, 1 USB, Wi-Fi, Bluetooth, HDR",
                2149.99,
                new Random().nextInt(10),
                "Tecnologia",
                4,
                true
        );

        Product product3 = new Product(
                "Headset Gamer, Drivers 53mm, Microfone Plugável, P2, PC, PS4, XBOX ONE",
                199.99,
                new Random().nextInt(10),
                "Tecnologia",
                5,
                true
        );

        Product product4 = new Product(
                "Notebook Intel Core i5-1135G7 EVO, 16GB RAM, SSD 512GB, 14 Full HD",
                4599.99,
                new Random().nextInt(10),
                "Tecnologia",
                3,
                false
        );

        Product product5 = new Product(
                "O passageiro",
                56.99,
                new Random().nextInt(10),
                "Livros",
                5,
                false
        );

        Product product6 = new Product(
                "A mandíbula de Caim",
                49.99,
                new Random().nextInt(10),
                "Livros",
                4,
                true
        );

        Product product7 = new Product(
                "O que sobra",
                74.90,
                new Random().nextInt(10),
                "Livros",
                3,
                false
        );

        Product product8 = new Product(
                "Protetor Solar Facial ISDIN Fusion Water 5 Stars FPS 60",
                69.90,
                new Random().nextInt(10),
                "Higiene",
                4,
                false
        );

        Product product9 = new Product(
                "Kit Potes de Plástico Hermético, 10 unidades",
                99.90,
                new Random().nextInt(10),
                "Cozinha",
                5,
                true
        );

        Product product10 = new Product(
                "Chaleira Elétrica, Preto/Inox, 127v",
                87.52,
                new Random().nextInt(10),
                "Cozinha",
                4,
                false
        );

        return Arrays.asList(product1, product2, product3, product4, product5, product6,
                product7, product8, product9, product10);
    }
}
