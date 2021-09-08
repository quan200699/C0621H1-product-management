package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.Main.scanner;

public class ProductManagement {
    private List<Product> products = new ArrayList<>();

    public ProductManagement() {
        products.add(new Product("001", "IPhone 13", 4000000, 200, "new"));
        products.add(new Product("002", "IPhone 12", 3000000, 200, "new"));
        products.add(new Product("003", "IPhone 11", 1300000, 200, "new"));
        products.add(new Product("004", "IPhone X", 800000, 200, "new"));
        products.add(new Product("005", "IPhone 8", 600000, 200, "new"));
        products.add(new Product("006", "IPhone 6", 200000, 200, "new"));
        products.add(new Product("007", "IPhone 5", 100000, 200, "new"));
    }

    public void showAll() {
        int count = 0;
        for (Product product : products) {
            System.out.println(product);
            count++;
            if (count == 5) {
                count = 0;
                scanner.nextLine();
            }
        }
    }

    public void add(Product product) {
        products.add(product);
    }

    public void updateProduct(String id, Product product) {
        int index = findProductById(id);
        products.set(index, product);
    }

    private int findProductById(String id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
