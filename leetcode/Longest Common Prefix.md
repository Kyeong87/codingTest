# 문제 (Easy) - Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:   
Input: strs = ["flower","flow","flight"]   
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]   
Output: ""   
Explanation: There is no common prefix among the input strings.

## 풀이
1.  배열안에 같은 문자열이 동일하게 포함된 애 찾아서 리턴하는거
2. sort로 문자열 짧은걸순으로 정렬하고 하나하나 비교하려고 했는데 실패   
3. 지금 코테 떨어져서 멘붕임 못해먹겠음

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        char[] arr = new char[strs[0].length()];
        for(int j=0;j<strs[0].length();j++) {
            char a = strs[0].charAt(j);
            arr[j] = a;
        }
        String str = "";
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<strs.length;j++) {
                if(j==0) continue;
                char a = strs[j].charAt(i);
                System.out.println(a+" : "+arr[i]);
                if(a==arr[i]) {
                    str += arr[i];
                }
            }
        }
        
        return str;
    }
}
```

## 다른사람 풀이
1. StringBuilder 사용하여 for문 통과하면 sb에 append
2. 생각 지도 못했다 저런함수가 있는줄

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (String str : strs) {
                if (str.length() <= i || c != str.charAt(i)) {
                    return sb.toString();
                }
            }

            sb.append(c);
        }


        return sb.toString();
    }
}
```
### 73.41%

### 결론