# 문제 (Easy) - Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

#번역
두 개의 배열 nums1, nums2 를 nums1 에 하나로 합치는 문제입니다.
두 배열은 이미 정렬되어있고 합쳐진 nums1 도 정렬되어야 합니다.
nums1 은 nums2 의 길이인 n 만큼의 추가 공간이 있으며 해당 공간은 0 으로 채워져 있습니다.
=> 아 nums1 에 합치라는 거구나.... 영어 차암

## 풀이

```java
import java.util.*;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arrSum = new int[m+n];

        for(int i=0; i<m+n; i++) {
            if(nums1[i] !=0) continue;
            if(nums2[i-nums1.length] !=0) continue;
            
            if(i<nums1.length) {
                arrSum[i] = nums1[i];   
            }else {
                arrSum[i] = nums2[i-nums1.length];
            }
        }
        
        System.out.println(Arrays.toString(arrSum));
    }
}
```

1. 항상 부족해.. 무언가 부족해


## 다른사람 풀이
단순하게 비교해서 넣으면 되는 문제입니다.
이렇게 추가 공간 없이 in place 로 구현해야 하는 문제는 새로 바뀐 값이 이후 로직에 영향을 주면 안됩니다.
따라서 배열의 뒤부터 비교해가며 넣어줍니다.
i 또는 j 가 0 이 되고 나면 나머지 하나가 0 이 될때까지 배열을 채워야 합니다.
i 는 이미 배열에 채워져 있기 때문에 j 가 0 이 될 때까지만 값을 넣어주면 됩니다

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }

        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}
```