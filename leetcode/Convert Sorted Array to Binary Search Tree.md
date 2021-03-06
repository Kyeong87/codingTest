이분탐색 하듯이 트리를 순회하면 됩니다.
배열이 오름차순으로 되어 있기 때문에 중앙에 있는 값이 무조건 root 가 되야 합니다.
부모 노드 nums[mid] 를 만들고 나면 왼쪽 서브트리는 0 ~ mid - 1 로 만든 트리고 오른쪽 서브트리는 mid + 1 ~ nums.length - 1 로 만든 트리입니다.


```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0, nums.length - 1);
    }

    public TreeNode traverse(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = low + (high - low)/2;

        return new TreeNode(
            nums[mid],
            traverse(nums, low, mid - 1),
            traverse(nums, mid + 1, high)
        );
    }
}
```