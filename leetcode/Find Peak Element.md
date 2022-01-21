A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

peak element는 이웃한 element보다 큰 element 입니다.

문제에서는 정수 배열이 주어졌을 때 peak element가 존재하면 아무 peak element의 인덱스를 반환하라고 되어있습니다.

그리고 시간복잡도 O(log n)를 사용하라고 되어있습니다.

그냥 peak element를 구하는 방법은 매우 간단합니다.

순차적으로 탐색하면서 더 커지는 순간을 구해도 충분하죠.

하지만 예시가 1000개이고 1000 번 째 숫자 때 숫자가 증가한다고 가정하면 효율이 매우 떨어지고 O(log n)으로 해결했다고 할 수 없습니다.

(당연히 제출하더라도 실패할 거구요)

따라서, 이진 탐색으로 O(log n)의 시간 복잡도가 소요되게 구현하시면 됩니다.




```java
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
```