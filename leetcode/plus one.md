# 문제 (Easy) - Plus one

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

## 풀이

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 10;
        String[] arr = new String[digits]
        digits[digits.length-1] = 10;
        
        int length = (int)(Math.log10(sum)+1);

        if(length>1) {
            String[] arr = String.valueOf(sum).split("");
            System.out.println(arr);
        }else {
            digits[digits.length-1] = sum;
        }
        return digits;
    }
}
```

1. 아 9를 1,0 으로 바꾸는데 막힌다.
2. 험난한 코딩테스트

##다른사람 풀이
```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;        

        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;

            if (digits[i] < 10) {
                return digits;
            }

            digits[i] = 0;
        }

        int[] res = new int[n + 1];
        res[0] = 1;

        return res;
    }
}
```
1. 내가 앞서갔네.. if 로 10보다 작다 체크하면 됐는데 math까지 썼네
2. return 방법도...