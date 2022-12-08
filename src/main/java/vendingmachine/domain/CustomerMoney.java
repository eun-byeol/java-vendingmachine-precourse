package vendingmachine.domain;

import static vendingmachine.utils.ErrorMassage.*;

public class CustomerMoney {
    private int customerMoney;

    public CustomerMoney(String inputMoney) {
        int money = validateInteger(inputMoney);
        validatePositiveNumber(money);
        this.customerMoney = money;
    }

    private int validateInteger(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_NOT_INTEGER);
        }
    }

    private void validatePositiveNumber(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(MONEY_NOT_POSITIVE_NUMBER);
        }
    }
}
