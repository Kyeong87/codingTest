Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

nums 배열의 중복된 숫자를 찾는 문제입니다.

중복된 숫자는 여러번 나올수 있으며 나머지 숫자들은 전부 한번만 등장합니다.

nums 배열의 길이가 n 이라고 할 때 등장하는 숫자들의 범위는 1 ~ n 입니다.

토끼와 거북이 알고리즘으로 풀 수 있습니다.

nums 에 있는 값들을 인덱스로 취급해서 계속 이동합니다.

중복된 값이 최소 한개는 존재하기 때문에 반드시 싸이클이 생깁니다.

```java
class Solution {
    public int findDuplicate(int[] nums) {
        // find cycle
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // find cycle start point        
        int index = 0;
        while (slow != index) {
            index = nums[index];
            slow = nums[slow];
        }

        return index;
    }
}
```