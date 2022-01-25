```java
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null && needle==null) return 0;

        int start =0;
        int suc =0;
        for(int i = 0; i<needle.length();i++) {
            char chk = needle.charAt(i);
            for(int j = 0; j<haystack.length();j++) {
                char chk2 = haystack.charAt(j);
                if(chk==chk2) {
                    if(start==0) start = j;
                    suc++;
                }
            }
        }
        if(suc==needle.length()) return start;
        return -1;
        

    }
}
```
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