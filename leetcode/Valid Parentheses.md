# 문제 (Easy) - Valid Parenthses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.   
An input string is valid if:   
1.Open brackets must be closed by the same type of brackets.   
2.Open brackets must be closed in the correct order.   

## 풀이
1.  브라캣 순서대로 닫으면 true, 아니면 false 이게 아닌가.. 문제 이해가 안되네
2. "([)]" 이게 왜 false 인지.. 아놔.. 또 못풀었네

```java
class Solution {
    public boolean isValid(String s) {
        int fal = 0;
        int suc = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char aa = getString(a);
            
            for (int j = 0; j < s.length(); j++) {
                if(i==j) continue;
                if (s.length()-1 > i && aa != s.charAt(j)) {
                    fal++;
                }else if(aa == s.charAt(j)){
                    suc++;
                }
            }
        }
        if(suc>0) return true;
        else return false;
    }
    public char getString(char a) {
        switch(a) {
            case '{': { return '}'; }
            case '[': { return ']'; }
            case '(': { return ')'; }
                default: { return 'a'; }
        }
    }
}
```

## 다른사람풀이
여는 괄호가 있으면 닫는 괄호가 반드시 존재해야 하고 ( 괄호가 } 나 ] 괄호와 매칭 될 수 없습니다.   
스택을 이용하여 여는 괄호가 나오면 그대로 Stack 에 넣어주고, 닫는 괄호가 나오면 Stack.peek() 값과 비교하여 쌍이 제대로 맞는지 확인하면 됩니다.   
단순하게 switch 문이나 if - else 문으로 짤수도 있지만 HashMap 을 사용하면 반복되는 로직을 어느정도 줄일 수 있습니다.
key = 닫는 괄호, value = 여는 괄호로 저장해두고 닫는 괄호가 주어졌을 때 stack 의 가장 최근 값이 여는 괄호와 일치하는 지 바로 비교할 수 있습니다


```java
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != map.get(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
```

## 결론