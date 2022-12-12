package vendingmachine.utils;

public class ErrorMassage {
    private static final String ERROR_TAG = "[ERROR] ";
    public static final String MONEY_NOT_INTEGER = ERROR_TAG + "금액은 정수여야 합니다.";
    public static final String MONEY_NOT_POSITIVE_NUMBER = ERROR_TAG + "금액은 0보다 커야 합니다.";
    public static final String MACHINE_MONEY_COULD_BE_DIVIDED_BY_TEN = ERROR_TAG + "자판기 보유 금액은 10원으로 나누어 떨어져야 합니다.";

    public static final String PRODUCT_SEPARATOR_COMMA = ERROR_TAG + "상품명, 가격, 수량은 쉼표(,)로 구분해야 합니다.";
    public static final String PRODUCT_SEPARATOR_SQUARE_BRACKETS = ERROR_TAG + "개별 상품은 대괄호([])로 묶어 입력해야 합니다.";
    public static final String PRODUCT_NAME_SIZE_BIGGER_THAN_ONE = ERROR_TAG + "상품명은 최소 1자 이상이어야 합니다.";
    public static final String PRODUCT_NUMBER_NOT_INTEGER = ERROR_TAG + "상품 가격과 수량은 정수여야 합니다.";
    public static final String PRODUCT_PRICE_RANGE_HAS_TO_OVER_100 = ERROR_TAG + "상품 가격은 100원 이상이어야 합니다.";
    public static final String PRODUCT_PRICE_COULD_BE_DIVIDED_BY_TEN = ERROR_TAG + "상품 가격은 10원으로 나누어 떨어져야 합니다.";
    public static final String PRODUCT_QUANTITY_NOT_POSITIVE_NUMBER = ERROR_TAG + "상품 수량은 최소 1개 이상이어야 합니다.";

    public static final String PRODUCT_IS_OUT_OF_STOCK = ERROR_TAG + "재고가 없습니다.";
    public static final String NOT_ENOUGH_MONEY = ERROR_TAG + "투입 금액이 부족합니다.";
    public static final String PRODUCT_NAME_IS_NOT_VALID = ERROR_TAG + "등록된 상품이 아닙니다.";
}
