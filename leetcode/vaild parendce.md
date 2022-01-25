
```java
class Solution {
    public boolean isValid(String s) {
        String[] arr1 = {"(","[","{"};
        String[] arr2 = {")","]","}"};
        String[] arr = s.split("");
        int retunr = 0;

        for(int i=0;i<arr.length;i++) {
            int test = Arrays.asList(arr1).indexOf(arr[i]);
            System.out.println(test+" : "+ i);
            if(test==i) {
                i++;
            }else {
                retunr++;
            }
        }
        
        if(retunr > 0) return false;
        else return true;
    }
}
```
- 아 스위치문.....젠장

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        
        for(int i=0; i<n; i++){
            char c= s.charAt(i);
            switch(c){
                case '(':
                case '[':
                case '{':{
                    stk.push(c);
                    break;
                }
                case ')':{
                    if(stk.size() >0 && stk.peek()== '('){
                        stk.pop();
                        break;
                    }
                    else{
                        return false;
                    }
                }
                case ']':{
                    if(stk.size() >0 && stk.peek() == '['){
                        stk.pop();
                        break;
                    }
                    else{
                        return false;
                    }
                }
                    case '}':{
                    if(stk.size() >0 && stk.peek() == '{'){
                        stk.pop();
                        break;
                    }
                    else{
                        return false;
                    }
                }
                default:{
                    return false;
                }
            }
        }
        if(stk.size() ==0)
        return true;
        else
            return false;
    }
}
```