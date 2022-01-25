# 문제 (Easy) - Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

![스크린샷 2022-01-24 오후 6 03 34](https://user-images.githubusercontent.com/93639793/150752685-a3672e45-faf7-492b-a8af-f8fa0656b319.png)
## 풀이
1. String으로 온 문자열을 다 더해서 리턴

```java
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i =0;i<s.length();i++) {
            char a = s.charAt(i);

            if(a == 'L') sum += 50;
            else if(a == 'V') sum += 5;
            else if(a == 'D') sum += 500;
            else if(a == 'M') sum += 1000;
            else if(a == 'I') {
                if(i < s.length()-1) {
                    if(s.charAt(i+1) == 'V') {
                        sum += 4;
                        i = i + 1;
                    }else if(s.charAt(i+1) == 'X') {
                        sum += 9;
                        i = i + 1;
                    }else {
                        sum += 1;
                    }
                }else {
                    sum += 1;
                }
            }else if(a == 'X') {
                if(i < s.length()-1) {
                    if(s.charAt(i+1) == 'L') {
                        sum += 40;
                        i = i + 1;
                    }else if(s.charAt(i+1) == 'C') {
                        sum += 90;
                        i = i + 1;
                    }else {
                        sum += 10;
                    }
                }else {
                    sum += 10;
                }
            }else if(a == 'C') {
                if(i < s.length()-1) {
                    if(s.charAt(i+1) == 'D') {
                        sum += 400;
                        i = i + 1;
                    }else if(s.charAt(i+1) == 'M') {
                        sum += 900;
                        i = i + 1;
                    }else {
                        sum += 100;
                    }
                }else {
                    sum += 100;
                }
            }
        }
        return sum;
    }
}
```
![스크린샷 2022-01-24 오후 6 06 25](https://user-images.githubusercontent.com/93639793/150753125-4bafe27b-7e7a-4e35-9931-87be5e61c90c.png)

### 49.74%

## 다른사람 풀이
1. 아 설명을 제대로 안읽었나보다
2. 바로 뒤에 나오는 숫자보다 작으면 1을 빼는 거였는데? 이런.. 그생각을 못했따. 

```java
class Solution {
    public int romanToInt(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = getNumber(c);

            if (i + 1 == s.length()) {
                sum += num;
                continue;
            }

            char next = s.charAt(i + 1);

            // 바로 뒤에 나오는 숫자보다 작으면 숫자를 빼야함
            if (num < getNumber(next)) {
                sum -= num;
            } else {
                sum += num;
            }
        }

        return sum;
    }

    public int getNumber(char character) {
        switch(character) {
            case 'V': { return 5; }
            case 'X': { return 10; }
            case 'L': { return 50; }
            case 'C': { return 100; }
            case 'D': { return 500; }
            case 'M': { return 1000; }
            default: { return 1; }
        }
    }
}
```

###99.85%

## 결론
- 문제를 더 자세히 어떠한 패턴이 있는지 이해를 해보자!
