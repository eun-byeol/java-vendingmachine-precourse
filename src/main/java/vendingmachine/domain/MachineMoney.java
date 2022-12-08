package vendingmachine.domain;

import static vendingmachine.utils.ErrorMassage.*;

public class MachineMoney {
    private final long machineMoney;
    private static final long UNIT_AMOUNT = 10L;

    public MachineMoney(String inputMoney) {
        Long money = validateLong(inputMoney);
        validatePositiveNumber(money);
        validateDividedTen(money);
        this.machineMoney = money;
    }

    private Long validateLong(String inputMoney) {
        try {
            return Long.parseLong(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MACHINE_MONEY_NOT_LONG);
        }
    }

    private void validatePositiveNumber(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException(MACHINE_MONEY_NOT_POSITIVE_NUMBER);
        }
    }

    private void validateDividedTen(long money) {
        if (money % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException(MACHINE_MONEY_COULD_BE_DIVIDED_BY_TEN);
        }
    }
}
