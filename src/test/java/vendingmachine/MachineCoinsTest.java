package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vendingmachine.domain.MachineCoins;
import vendingmachine.enums.Coin;

import static org.assertj.core.api.Assertions.assertThat;

public class MachineCoinsTest {
    MachineCoins machineCoins = new MachineCoins(450);

    private int sumRemainCoins(int input) {
        machineCoins.giveChange(input);
        int sum = 0;
        for (Coin key : machineCoins.getCoins().keySet()) {
            int count = machineCoins.getCoins().get(key);
            sum += count * key.getAmount();
        }
        return sum;
    }

    @ParameterizedTest
    @DisplayName("동전 개수가 최소한이 되게 잔돈을 돌려준다.")
    @CsvSource(value = {"100,350", "300,150", "500,0"})
    void sumRemainCoinsTest(int input, int expected) {
        assertThat(sumRemainCoins(input)).isEqualTo(expected);
    }
}
