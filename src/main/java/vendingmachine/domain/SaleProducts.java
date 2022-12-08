package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class SaleProducts {
    private List<Product> products = new ArrayList<>();

    public SaleProducts(String input) {
        String[] splitInputs = input.split(";");
        List<String> inputs = new ArrayList<>();

        for (String information : splitInputs) {
            inputs.add(information.replace("[", "")
                            .replace("]", "")
                            .trim());
        }

        for (String unit : inputs) {
            this.products.add(new Product(unit));
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
