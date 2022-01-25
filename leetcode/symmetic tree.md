
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

이 방법의 시간복잡도는 O(n)이고 공간복잡도의 worse case는 트리가 일직선으로 이루어져 Height가 O(n)인 경우이므로 O(n)이다.


