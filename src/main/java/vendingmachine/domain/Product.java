package vendingmachine.domain;

import vendingmachine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

import static vendingmachine.utils.ErrorMassage.*;

public class Product {
    private final String name;
    private final int price;
    private int quantity;

    public Product(String productInformation) {
        String[] splitInputs = productInformation.split(",");
        List<String> inputs = new ArrayList<>();

        for (String information : splitInputs) {
            inputs.add(information.trim());
        }

        this.name = validateName(inputs.get(0));
        this.price = validatePrice(inputs.get(1));
        this.quantity = validateQuantity(inputs.get(2));
    }

    private String validateName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException(PRODUCT_NAME_SIZE_BIGGER_THAN_ONE);
        }
        return name;
    }

    private int validatePrice(String price) {
        int priceNumber = validateInteger(price);
        validatePriceSize(priceNumber);
        validateDivideUnitNumber(priceNumber);
        return priceNumber;
    }

    private int validateQuantity(String quantity) {
        int quantityNumber = validateInteger(quantity);
        validateQuantitySize(quantityNumber);
        return quantityNumber;
    }

    private int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PRODUCT_NUMBER_NOT_INTEGER);
        }
    }

    private void validatePriceSize(int price) {
        if (price < Coin.COIN_100.getAmount()) {
            throw new IllegalArgumentException(PRODUCT_PRICE_RANGE_HAS_TO_OVER_100);
        }
    }

    private void validateDivideUnitNumber(int price) {
        if (price % Coin.COIN_10.getAmount() != 0) {
            throw new IllegalArgumentException(PRODUCT_PRICE_COULD_BE_DIVIDED_BY_TEN);
        }
    }

    private void validateQuantitySize(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(PRODUCT_QUANTITY_NOT_POSITIVE_NUMBER);
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
