문제는 주어진 숫자를 자리수마다 제곱하여 더하고 그 수가 만약 1로 수렴한다면 Happy Number 이다. 라는 문제입니다. 생각보다 어렵지 않은 문제라고 생각되어 아래와 같이 작성하여 제출했습니다.
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.


```java
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> cache = new HashSet();//Set을 통해서 중복된 값들은 자동으로 제거
        while(!cache.contains(n)){
            cache.add(n);
            n = getSum(n);
            
            if(n == 1){
                return true;
            }
        }
        return false;
    }
    
    public int getSum(int num){
        int sum = 0;
        while(num > 0){
            //num > 0보다 클 때까지,
            //num이 19라면,
            //19 -> 19 % 10 = 9, 9 * 9, 1의 자릿수
            //19 / 10, 1 * 1; 10의 자릿수
            //81 + 1;
            //82 -> 82 % 10 = 2, 2 * 2, 1의 자릿수
            //82 / 10 = 8, 8 * 8
            //4 + 64 
            //68 -> 68 % 10 = 8, 8 * 8
            //68 / 10 = 6, 6 * 6
            //100, 100 % 10 = 0, 0*0,
            //10, 10 % 10 = 0, 0*0,
            //1, 1 % 10 =1 , 1 * 1
            //1로 떨어짐
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}
```



 List에서 cotains은 O(n)이고, HashSet에서 contains는 O(1)이다. List는 많으면 많을 수록 증가하고, Set은 항상 1이다. 메모리 측면에서도 효율적이라고 한다.
 - 자료구조를 선택하는 것에 있어, 지식을 넓혀나가야 한다.
 List vs Set과 같이 메소드를 하나 사용하는 것에 있어 효율이 다르다는 것을 명심하자.
 - 각 자릿수, 문자를 하나씩과 같을 때, 항상 splits 메소드를 쓰지는 말자.
 더 좋은 방법은 자릿 수, 해당 번 째 문자를 구하는 방법은 존재할 것이다.