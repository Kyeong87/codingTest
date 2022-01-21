Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

위의 문제를 번역하면 간단하다. 재귀함수는 정의가 가장 중요하다.  
getCount라는 함수는 P 혹은 Q의 개수를 의미한다.   
어떤 노드에서, 왼쪽 트리의 P 혹은 Q의 개수와 오른쪽 트리의 P 혹은 Q의 개수의 합은 현재 노드를 포함한 P와 Q의 노드의 개수와 같다. P와 Q의 개수가 최초로 2가 되는 곳이 공통조상이라고 볼 수 있다.


```java
class Solution {
    TreeNode answer = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getCount(root, p, q);
        return answer;
    }
    
    int getCount(TreeNode root, TreeNode p, TreeNode q){
        int result = 0;
        
        if(root == null) return 0;
        
        if(root == p || root == q)
            result = 1;
        
        result += getCount(root.left, p, q);
        result += getCount(root.right, p, q);
        
        if(result == 2 && answer == null)
            answer = root;
        
        return result;   
    }
}

```


아래도 동일한 결과를 갖는 코드이다. 재귀적으로 생각하면, 현재 함수에서 루트의 왼쪽과 루트의 오른쪽을 호출하므로 베이스 케이스(리프 노드 혹은 NULL)에 도달할 때까지 계속 함수가 호출된다. 베이스 케이스까지 도달하면, 호출된 함수들의 리턴이 시작되면서 최종적으로 원하는 결과를 얻게 된다.`

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root;
        else if(left != null || right != null) return left == null ? right : left;
        else return null;
    }
}

```

아래는 해쉬맵 함수를 이용한 풀이를 설명한다, 모든 노드들의 부모 노드들을 저장해두고, P와 Q에서 역으로 탐색하며 같은 부모 노드를 리턴하도록 한다. 


```java
class Solution {
    HashMap<TreeNode, TreeNode> parent = new HashMap<>(); // Key : Child, Value : Parent
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parent.put(root, null);
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        while(!qu.isEmpty()){
            TreeNode node = qu.poll();
            
            if(node.left != null){
                parent.put(node.left, node);
                qu.add(node.left);
            }
                
            if(node.right != null){
                parent.put(node.right, node);
                qu.add(node.right);
            }
        }
        
        HashSet<TreeNode> hs = new HashSet<>();
        while(p != null){
            hs.add(p);
            p = parent.get(p);
        }
        
        while(q != null){
            if(hs.contains(q))
                return q;
            
            q = parent.get(q);
        }
        
        return null;    
    }
}

```