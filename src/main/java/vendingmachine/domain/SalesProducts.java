package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static vendingmachine.utils.ErrorMassage.*;

public class SalesProducts {
    private List<Product> products = new ArrayList<>();

    public SalesProducts(String input) throws IllegalArgumentException {
        String[] splitInputs = input.split(";");
        List<String> inputs = addInformationToInputs(splitInputs);

        for (String unit : inputs) {
            System.out.println(">" + unit);
            this.products.add(new Product(unit));
        }
    }

    private List<String> addInformationToInputs(String[] splitInputs) {
        List<String> inputs = new ArrayList<>();
        for (String information : splitInputs) {
            String replaced = information.replace("[", "")
                    .replace("]", "");

            if (information.length() - 2 != replaced.length()) {
                throw new IllegalArgumentException(PRODUCT_SEPARATOR_SQUARE_BRACKETS);
            }

            inputs.add(replaced.trim());
        }
        return inputs;
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
