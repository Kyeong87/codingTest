```java
class Solution {
    public int singleNumber(int[] nums) {
        int[] arr = new int[nums.length];
        
        for(int i=0;i < nums.length;i++) {
            arr[nums[i]]++;
        }
        int result =0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]==1) {
                result = i;
                
            }
        }
        return result;
    }
}
```

- 런타임 에러. 


```java
class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            ans ^= nums[i];
        }

        return ans;
    
    }
}
```

^= xor 연산자