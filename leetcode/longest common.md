```java
import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String cmnPrefix = "";
        int minLength = Math.min(strs[0].length(), strs[strs.length - 1].length());
        System.out.println(Arrays.toString(strs));
        for (int i = 0; i < minLength; i++) {
            System.out.println(strs[0].charAt(i));
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) 
                break;
            
            cmnPrefix = cmnPrefix + strs[0].charAt(i);
        }
        return cmnPrefix;
    }
}
```

- 이해가 안가네 arrays.sort가 저런 정렬이였따니 하   
- 이번에도 망한거 같아.. 울고싶다