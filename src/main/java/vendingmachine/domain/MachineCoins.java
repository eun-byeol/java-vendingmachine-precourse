package vendingmachine.domain;

import vendingmachine.enums.Coin;

import java.util.Map;

public class MachineCoins {
    private Map<Coin, Integer> coins;
    private RandomCoinMaker randomCoinMaker = new RandomCoinMaker();

    public MachineCoins(int money) {
        coins = randomCoinMaker.createRandomCoins(money);
    }
}
