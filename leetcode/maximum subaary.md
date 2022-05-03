Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++) {
            currentSum = Math.max(nums[i]+currentSum, nums[i]);
            maxSum = Math.max(currentSum, maxSum);
            System.out.println(maxSum);
        }  

        return maxSum;
    }
}
```


Follow up을 확인하면 시간복잡도가 O(n)으로 해결되는 문제임을 알 수 있습니다.
그래서 어떻게 하면 시간복잡도가 O(n)이 될 수 있을지 고민해봤어요.
O(n)이 되려면 주어진 숫자 만큼 for문을 1회 실행 한다고 생각하면 됩니다.

이렇게 어느 지점 부터 합을 시작해도 되는지 관리 하지 않아도 위 알고리즘을 이용하면 자동으로 관리 하게 됩니다.
그리고 시간복잡도는 O(n)가 되죠.

출처:https://firework-ham.tistory.com/83

- 인쇄해보면 
  1
  1
  4
  4
  5
  6
  6
  6   
  2개씩 더해서 큰값을 찾아서 가지고 있으면, 결국 제일 큰 값이 나옴...
- 이게 [4,-1,2,1] 무조건 이 값을 찾아야 된다는 강박을 버려야함
    그냥  답이 더한 값 6을 구하면 되는 거다!!