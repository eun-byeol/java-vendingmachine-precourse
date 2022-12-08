package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.enums.Coin;

import java.util.*;

public class RandomCoinMaker {
    List<Integer> coinAmount = Arrays.asList(
            Coin.COIN_500.getAmount(),
            Coin.COIN_100.getAmount(),
            Coin.COIN_50.getAmount(),
            Coin.COIN_10.getAmount()
    );

    private Map<Coin, Integer> initCoins() {
        Map<Coin, Integer> coins = new HashMap<>();
        coins.put(Coin.COIN_500, 0);
        coins.put(Coin.COIN_100, 0);
        coins.put(Coin.COIN_50, 0);
        coins.put(Coin.COIN_10, 0);
        return coins;
    }

    public Map<Coin, Integer> createRandomCoins(int money) {
        Map<Coin, Integer> coins = initCoins();
        while (money >= 50) {
            int randomCoin = pickRandomNumber();
            if (money > randomCoin) {
                money -= randomCoin;
                Coin key = Coin.selectCoinByAmount(randomCoin);
                int keyCount = coins.get(key);
                coins.put(key, keyCount + 1);
            }
        }
        int updateCount = coins.get(Coin.COIN_10) + (money / Coin.COIN_10.getAmount());
        coins.put(Coin.COIN_10, updateCount);
        return coins;
    }

    public Integer pickRandomNumber() {
        return Randoms.pickNumberInList(coinAmount);
    }
}
