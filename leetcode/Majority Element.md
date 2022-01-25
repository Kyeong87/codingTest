무어의 알고리즘을 이용해도 된다.
: 다수 원소의 출현횟수의 총합은 나머지 원소의 출현횟수보다 많다

```java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
```