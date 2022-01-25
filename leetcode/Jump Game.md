You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.


음이 아닌 정수 배열 nums
배열의 각 요소는 해당 위치에서 최대 점프 길이냄
처음에는 배열의 첫 번째 인덱스 에 위치
인덱스에서 점프하면서 배열의 끝에 도달 할 수 있는지 확인하십시오.

bfs 

```java
class Solution {
    public int N;
    public boolean canJump(int[] nums) {
      	// 배열의 길이 
        N = nums.length;
        
        boolean[] visited = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<Integer>();
    
        visited[0] = true;
        queue.add(0);
        
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            
            // 현재 배열의 위치에서 점프할 수 있는 길이만큼 다 이동해보기
            for (int i = 1; i <= nums[idx]; i++) {
                int newIdx = idx + i;
                
                // 점프했을 때 범우 밖이거나 이미 방문했었으면 탐색 X
                if (!isIn(newIdx) || visited[newIdx])
                    continue;
                
                // 배열의 끝에 도달했으면 종료
                if (newIdx == N - 1)
                    return true;
                
                visited[newIdx] = true;
                queue.add(newIdx);
            }
        }
        
        return visited[N-1];
    }
    
    public boolean isIn(int x) {
        if (0 <= x && x < N)
            return true;;
        return false;
    }
    
}
```