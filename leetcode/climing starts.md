# 문제 (Easy) - Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

```java
public int climbStairs(int n) {
    if (n <= 1) {
    return 1;
    }

    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
    }
```

1. 동적프로그래밍 DP를 이용하여 분할하여 값을 계산합니다. 피보나치 수열과 유사하게 n-1 + n-2 에서의 경우의 수를 합치면 n번째의 가능한 경우의 수가 나오므로 앞에서부터 분할하여 정복해나갑니다.

