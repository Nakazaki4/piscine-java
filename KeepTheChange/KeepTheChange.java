import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        if (amount <= 0 || coins == null || coins.isEmpty()) {
            return new ArrayList<>();
        }

        int[] dp = new int[amount + 1];
        
        int[] coinUsed = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (dp[i - coin] + 1 < dp[i]) {
                        dp[i] = dp[i - coin] + 1;
                        coinUsed[i] = coin;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        
        if (dp[amount] > amount) {
            return result; 
        }

        int currentAmount = amount;
        while (currentAmount > 0) {
            int coin = coinUsed[currentAmount];
            result.add(coin);
            currentAmount -= coin;
        }

        result.sort(Collections.reverseOrder());
        return result;
    }
}