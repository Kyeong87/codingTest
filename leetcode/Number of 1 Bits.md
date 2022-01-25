```java
public class Solution {
    public int hammingWeight(int n) {
        int sum = 0;

        while (n != 0) {
            sum += (n & 1);
            n >>>= 1;
        }

        return sum;
    }
}
```
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.




시프트 연산을 진행하면서 풀면 됩니다.

주의할 점은 음수도 주어질 수 있기 때문에 >>> 연산을 사용해야 합니다.

1. 시프트 연산자
1)  `>>` : 오른쪽으로  주어진 비트 수만큼 이동
    : 앞에 비어 있는 빈칸은 부호 비트로 채운다
2)  `<<`  : 왼쪽으로 주어진 비트 수만큼 이동
    : 뒤에 비어 있는 빈칸은 0으로 채운다.

3)  `>>>` (자바에만 있는 연산자) : 오른쪽으로 주어진 비트 수만큼 이동
    : 앞에 비어있는 빈칸은 0으로 채운다.