package vendingmachine.domain;

import vendingmachine.view.InputView;

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

    public int returnPriceOfCheapestProduct() {
        int minPrice = Integer.MAX_VALUE;
        for (Product product : products) {
            if (product.getPrice() < minPrice) {
                minPrice = product.getPrice();
            }
        }
        return minPrice;
    }

    public boolean isAllSoldOut() {
        for (Product product : products) {
            if (!product.isOutOfStock()) {
                return false;
            }
        }
        return true;
    }

    public List<Product> getProducts() {
        return products;
    }
}
