Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

nums 배열이 주어진다.

인덱스 i, j, k (0 <= i < j < k <= n-1)라 할 때, nums[i] < nums[j] < nums[k] 를 충족하는 부분배열이 존재하는지 구하는 문제이다.



nums = [1,0,2,-1,3] 를 예로 들어 보자.


```java
public boolean increasingTriplet(int[] nums) {
    int small = Integer.MAX_VALUE;
    int big = Integer.MAX_VALUE;
 
    for (int num: nums) {
        if (num <= small) {
            small = num;// update x to be a smaller value
        } else if (num <= big) {
            big = num; // update y to be a smaller value
        } else {
            return true;
        }
    }
 
    return false;
}
```