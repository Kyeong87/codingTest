There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

이 문제는 시간 복잡도가 logN이 되도록 문제를 풀어야 한다, 단순 선형 탐색으로 문제를 풀어도 정답은 되지만, 출제의도가 아니다.





우선 피벗을 기준으로, 정렬된 배열들이 섞이게 된다. 중요한 점은, 피벗을 기준으로 각자 정렬을 유지하고 있다는 것이다. 피벗을 기준으로 정렬을 이루고 있기 때문에, 이진 탐색으로 피벗을 찾을 수 있다.







배열의 첫번째 값을 기준 값으로 코드를 작성하면 된다. 중간값이 첫번째 값보다 크다면, start = mid + 1을 진행한다.

중간값이 첫번째 값보다 작다면, end = mid - 1이 되어야 한다. 이진 탐색을 통해서 피벗의 인덱스를 찾을 수 있다.





피벗의 인덱스를 찾은 이후에, 피벗을 기준으로 정렬이 되어 있으므로 이진 탐색이 가능하다.





이 문제를 통해서 얻을 수 있는 것은, 피벗을 통해서 섞인 배열에서도 이진 탐색을 할 수 있다는 것이다.



```java
class Solution {
    public int search(int[] nums, int target){
        int result = 0;
        int start = 0;
        int end = nums.length - 1;
        
        int idx = 0;
        
        int val = nums[0];
        int mid = 0;
        
        // Find Ascending Last Index
        while(start <= end){
            mid = (start + end) / 2;
            
            if(val <= nums[mid]){
                idx = mid;
                start = mid + 1; 
            }else{
                end = mid - 1;
            }
        }
        
        System.out.println(idx);
        
        if(nums[0] <= target && target <= nums[idx]){
            start = 0;
            end = idx + 1;
            result = -1;
            
            while(start <= end){
                mid = (start + end) / 2;
                
                if(nums[mid] < target){
                    start = mid + 1;
                }else if(nums[mid] > target){
                    end = mid - 1;
                }else{
                    result = mid;
                    break;
                }
            }
            
        }else if(idx < nums.length - 1 && nums[idx + 1] <= target && target <= nums[nums.length - 1]){
            start = idx + 1;
            end = nums.length - 1;
            result = -1;
            
            while(start <= end){
                mid = (start + end) / 2;
                
                if(nums[mid] < target){
                    start = mid + 1;
                }else if(nums[mid] > target){
                    end = mid - 1;
                }else{
                    result = mid;
                    break;
                }    
            }
        }else
            result = -1;
        
    
        return result;
    }
}
```