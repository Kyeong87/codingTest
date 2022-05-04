
# 문제 (Easy) - Binary Tree Inorder Traversal.

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


```java
public List<Integer> inorderTraversal(TreeNode root) {

        // 1. Recursion - inorder
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
        }
private void inorderTraversal(TreeNode node,List<Integer> list){
        if(node == null) return;
        inorderTraversal(node.left,list);
        list.add(node.val);
        inorderTraversal(node.right,list);
        }
```
