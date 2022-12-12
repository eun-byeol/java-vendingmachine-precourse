package vendingmachine.view;

import vendingmachine.enums.Coin;

import java.util.Map;
import java.util.Map.Entry;

import static vendingmachine.utils.ViewMessage.*;

public class OutputView {
    public static void printVendingMachineCoins(Map<Coin, Integer> coins) {
        System.out.println(OUTPUT_VENDING_MACHINE_COINS);
        printCoinAmount(coins);
    }

    private static void printCoinAmount(Map<Coin, Integer> coins) {
        coins.forEach((key, value) -> {
            System.out.printf(OUTPUT_COIN_AMOUNT, key.getAmount(), value);
        });
    }

    public static void printCustomerMoney(int money) {
        System.out.printf(OUTPUT_CUSTOMER_MONEY, money);
    }

    public static void printChanges(Map<Coin, Integer> changes) {
        System.out.println(OUTPUT_CHANGES);
        printCoinAmount(changes);
    }
}
