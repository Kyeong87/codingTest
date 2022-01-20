```java
class Solution {
public int climbStairs(int n) {
int a = 0, b = 1;
int res = a + b;

        for (int i = 0; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }
}
```

피보나치처럼 풀면 된다는데 하 
난 진짜 모르겠다
