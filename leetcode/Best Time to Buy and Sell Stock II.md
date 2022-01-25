You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

앞으로의 물건의 예상 가격이 주어 질 때 팔 수 있는 물건의 최대 가격을 구하는 문제입니다.

Greedy 로 풀면 됩니다.

이 문제에서 중요한 포인트는 물건을 판 당일에 그 물건을 다시 살 수 있다 라는 점입니다.

예를 들어 [1, 5, 7, 6] 이 주어졌을 때 일반적으로 1 에 사서 7 에 파는 게 답이라는 사실을 알 수 있습니다.

하지만 조금 틀어서 생각하면 1 에 사서 5 에 팔고, 다시 5 에 사서 7 에 팔면 동일한 결과가 나옵니다.

즉, 가격에 관계 없이 항상 물건을 사서 다음 날이 비싸면 판다 라는 관점으로 접근하면 됩니다.


```java
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]) {
                sum += prices[i+1] - prices[i];
            }
        }

        return sum;
    }
}
```