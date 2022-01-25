```java
class Solution {
    public int maxSubArray(int[] nums) {
    	
    	int currentSum = nums[0];
    	int maxSum = nums[0];
    	
    	for(int i=1; i<nums.length; i++) {
    		currentSum = Math.max(nums[i]+currentSum, nums[i]);
    		maxSum = Math.max(currentSum, maxSum);
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