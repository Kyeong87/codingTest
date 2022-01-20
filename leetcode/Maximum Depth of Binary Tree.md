1. dfs
   Binary tree의 최대 높이는 root node로부터 leaf node까지의 최장 거리이다.
   정의에 따라 tree를 traverse하면서, leaf node까지의 최장 거리를 계산하면 된다.
   
```java
class Solution {
  public int maxDepth(TreeNode root) {
      if (root == null) return 0;
      return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
  }
}
```

2. bfs
   Stack을 이용해 위의 recursion을 iteration으로 변환할 수 있다.
   
1.root node부터 Queue에 삽입한다.   
2.Queue의 size만큼 iteration을 수행하며 Queue에 삽입된 front 노드를 poll, 해당 노드의 자식 노드들을 Queue에 offer 한다.   
3,같은 level에 있는 node들을 모두 검사한 후 depth를 증가시킨다.   
4.2~3을 반복한다.   .


```java
class Solution {
  public int maxDepth(TreeNode root) {
      if(root == null) return 0;
      
      Queue<TreeNode> queue = new LinkedList<>();
      int depth = 0;
      queue.offer(root);
      while(!queue.isEmpty()) {
          int size = queue.size();
          for(int i=0; i<size; i++) {
              TreeNode currNode = queue.poll();
              if(currNode.left != null) queue.offer(currNode.left);
              if(currNode.right != null) queue.offer(currNode.right);
          }
          depth++;
      }
      return depth;
  }
}
```