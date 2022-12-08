package vendingmachine.utils;

public class ErrorMassage {
    private static final String ERROR_TAG = "[ERROR] ";
    public static final String MACHINE_MONEY_NOT_LONG = ERROR_TAG + "자판기 보유 금액은 정수여야 합니다.";
    public static final String MACHINE_MONEY_NOT_POSITIVE_NUMBER = ERROR_TAG + "자판기 보유 금액은 0보다 커야 합니다.";
    public static final String MACHINE_MONEY_COULD_BE_DIVIDED_BY_TEN = ERROR_TAG + "자판기 보유 금액은 10원으로 나누어 떨어져야 합니다.";
}
