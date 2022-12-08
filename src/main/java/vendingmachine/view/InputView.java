package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.utils.ViewMessage.*;

public class InputView {
    public static String readVendingMachineMoney() {
        System.out.println(INPUT_VENDING_MACHINE_MONEY);
        return Console.readLine();
    }
}
