```java

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    class Solution {
        public int sumRootToLeaf(TreeNode root) {
            return calSum(root,0);
        }
        public int calSum(TreeNode root,int sum)
        {
            if(root==null)
                return 0;
            sum=(sum<<1)+root.val;
            if(root.left==null && root.right==null)
                return sum;
            return calSum(root.left,sum)+calSum(root.right,sum);
        }
    }
}

```