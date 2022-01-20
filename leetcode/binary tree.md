inorder 로 풀으라고 했음. 왼쪽 자신 오른쪽..??

```java

/**
* 이진트리
* input 1 null 2 3
* output 1 3 2
* inorder      left self right
* preorder     self left right
* postorder    left right self
  */
  public class Test {

List<Integer> ret;

public static void main(String[] args) {
TreeNode root = new TreeNode(1);
TreeNode t1 = new TreeNode(2);
TreeNode t2 = new TreeNode(3);
root.right = t1;
t1.left = t2;

Test test = new Test();
for(Integer i : test.inorderTraversal(root)) {
System.out.print(i + " ");
}

System.out.println();

for(Integer i : test.preorderTraversal(root)) {
System.out.print(i + " ");
}

System.out.println();

for(Integer i : test.postorderTraversal(root)) {
System.out.print(i + " ");
}
}

public List<Integer> inorderTraversal(TreeNode root) {
ret = new ArrayList<Integer>();
inorderTraverse(root);
return ret;
}

public List<Integer> preorderTraversal(TreeNode root) {
ret = new ArrayList<Integer>();
preorderTraverse(root);
return ret;
}

public List<Integer> postorderTraversal(TreeNode root) {
ret = new ArrayList<Integer>();
postorderTraverse(root);
return ret;
}

private void preorderTraverse(TreeNode self) {
if(self == null) return;
ret.add(self.val);
preorderTraverse(self.left);
preorderTraverse(self.right);
}

private void inorderTraverse(TreeNode self) {
if(self == null) return;
inorderTraverse(self.left);
ret.add(self.val);
inorderTraverse(self.right);
}

private void postorderTraverse(TreeNode self) {
if(self == null) return;
postorderTraverse(self.left);
postorderTraverse(self.right);
ret.add(self.val);
}
}

class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode(int i) { val = i; }
}
```
