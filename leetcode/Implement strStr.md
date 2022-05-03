Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Example 1:

Input: haystack = "hello", needle = "ll"   
Output: 2   

Example 2:
Input: haystack = "aaaaa", needle = "bba"   
Output: -1

- 아 풀수있었는데 까비.......

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;

        if(!haystack.contains(needle))
            return -1;
        else{
            char c = needle.charAt(0);
            for(int i=0;i<haystack.length();i++){
                if(c==haystack.charAt(i)){
                    if(needle.equals(haystack.substring(i,needle.length()+i)))
                        return i;
                }
            }
        }
        return -1;
    }
}
```

- substring(시작위치,끝위치) 짜르기 -> 
    - ex) arr = {abcdef}
    - substring(2,4) -> c,d -> 모야...왜 e는 안나옴? 이상해..
- equals 'll' 이랑 같은지 자른게..