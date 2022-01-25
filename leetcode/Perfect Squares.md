Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

```java
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++){
            for (int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
```

- - dp 배열은 perfect square의 조합으로 만들 수 있는 최소의 수 배열이다.

dp[0]은 0의 최소 조합이므로, 당연히 0

이 후, 그 자신보다 같거나 작은 perfect square의 dp값을 타고가

전부 비교해, 가장 작은 값을 계산하는 방식이다.