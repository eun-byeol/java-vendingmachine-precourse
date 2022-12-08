package vendingmachine.view;

import vendingmachine.enums.Coin;

import java.util.Map;
import java.util.Map.Entry;

import static vendingmachine.utils.ViewMessage.*;

public class OutputView {
    public static void printVendingMachineCoins(Map<Coin, Integer> coins) {
        System.out.println(OUTPUT_VENDING_MACHINE_COINS);
        for (Entry<Coin, Integer> entrySet : coins.entrySet()) {
            System.out.printf(
                    OUTPUT_COIN_AMOUNT,
                    entrySet.getKey().getAmount(),
                    entrySet.getValue()
            );
        }
    }
}
