package vendingmachine.domain;

import vendingmachine.enums.Coin;
import vendingmachine.view.OutputView;

import java.util.LinkedHashMap;
import java.util.Map;

public class MachineCoins {
    private LinkedHashMap<Coin, Integer> coins;
    private RandomCoinMaker randomCoinMaker = new RandomCoinMaker();

    public MachineCoins(int money) {
        coins = randomCoinMaker.createRandomCoins(money);
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public static void main(String[] args) {
        OutputView.printVendingMachineCoins(new MachineCoins(450).getCoins());
    }
}
