package vendingmachine.enums;

import java.util.Arrays;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin selectCoinByAmount(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.amount == amount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public int getAmount() {
        return amount;
    }
}
