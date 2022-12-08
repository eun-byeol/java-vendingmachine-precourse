package vendingmachine.domain;

import static vendingmachine.utils.ErrorMassage.*;

public class MachineMoney {
    private final int machineMoney;
    private static final int UNIT_AMOUNT = 10;

    public MachineMoney(String inputMoney) {
        int money = validateInteger(inputMoney);
        validatePositiveNumber(money);
        validateDividedTen(money);
        this.machineMoney = money;
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

    private void validateDividedTen(int money) {
        if (money % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException(MACHINE_MONEY_COULD_BE_DIVIDED_BY_TEN);
        }
    }
}
