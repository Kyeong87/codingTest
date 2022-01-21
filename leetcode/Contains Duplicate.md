Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

- 중복되는 숫자가 1개라도 있으면 true

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }
}
```