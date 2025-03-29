import java.util.HashMap;

public class FibonacciDP {
    // Top-Down Approach (Memoization)
    static HashMap<Integer, Long> memo = new HashMap<>();

    public static long fibMemo(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        long result = fibMemo(n - 1) + fibMemo(n - 2);
        memo.put(n, result);
        return result;
    }

    // Bottom-Up Approach (Tabulation)
    public static long fibTabulation(int n) {
        if (n <= 1) return n;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci using Memoization: " + fibMemo(n));
        System.out.println("Fibonacci using Tabulation: " + fibTabulation(n));
    }
}
