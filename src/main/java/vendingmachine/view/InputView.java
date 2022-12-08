package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.utils.ViewMessage.*;

public class InputView {
    public static String readVendingMachineMoney() {
        System.out.println(INPUT_VENDING_MACHINE_MONEY);
        return Console.readLine();
    }

    public static String readProductInformation() {
        System.out.println(INPUT_NAME_PRICE_QUANTITY_OF_PRODUCT);
        return Console.readLine();
    }

    public static String readCustomerMoney() {
        System.out.println(INPUT_CUSTOMER_MONEY);
        return Console.readLine();
    }
}
