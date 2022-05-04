# 문제 (Easy) - Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

![스크린샷 2022-05-04 오후 6 20 18](https://user-images.githubusercontent.com/93639793/166654511-5bba295a-a6fb-4362-9385-89aab54f39e0.png)

## 해석
주어진 이진 트리를 가지고 해당 트리가 거울에 비친 자신과 같은지(가운데를 중심으로 대칭인지) 판별하라.
트리가 좌우 대칭이려면 루트노드를 중심으로 왼쪽 서브트리를 좌우대칭한 것이 오른쪽 서브트리와 같아야 한다.  
그러려면 왼쪽 서브트리의 왼쪽 자식노드와 오른쪽 서브트리의 오른쪽 자식노드의 값이 같아야 하고  
왼쪽 서브트리의 오른쪽 자식노드와 오른쪽 서브트리의 왼쪽 자식노드의 값이 같아야 한다.   
<br>

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return isMirror(root,root);
    }
    
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        
        //t1과 t2가 둘다 null이면 true
        if(t1 == null && t2 == null) return true;
        
        //t1,t2중에 하나만 널이면 양쪽이 같지 않으므로 false
        if(t1 == null || t2 == null) return false;
        
        //t1과 t2의 값이 달라도 false
        if(t1.val != t2.val) return false;
        
        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}

```
13번째 줄의 (t1 == null || t2 == null)는 위에서 이미 둘다 null인 경우를 체크했으므로 t1이나 t2가 둘중 하나만 null인 경우를 체크한다.


이 방법의 시간복잡도는 O(n)이고 공간복잡도의 worse case는 트리가 일직선으로 이루어져 Height가 O(n)인 경우이므로 O(n)이다.

출처: https://beccacatcheserrors.tistory.com/21 [베카의에러뿌시기]
