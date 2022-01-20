```java
class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return true;
        
        String str = s.toLowerCase();

        String match = "[^\uAC00-\uD7A30-9a-zA-Z]";
        str = str.replaceAll(match, "");
        
        // 중간값부터 비교
        int toLeft = str.length() / 2;
        int toRight = str.length() / 2;

        // 짝수면 toLeft 를 하나 빼줌
        if (str.length() % 2 == 0) {
            toLeft -= 1;
        }

        while (toLeft >= 0) {
            if (str.charAt(toLeft--) != str.charAt(toRight++)) {
                return false;
            }
        }

        return true;

    }
```