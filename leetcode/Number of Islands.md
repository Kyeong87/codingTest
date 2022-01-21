Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


- 1이 땅, 0이 물, 1로 이어진 땅이 몇갠지 구하기


```java
class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R;
    static int C;

    public int numIslands(char[][] grid) {
        R = grid.length;
        C = grid[0].length;
        int ans = 0;
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        for (int i = 0; i < 4; i++){
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (0 <= newR && newR < R && 0 <= newC && newC < C && grid[newR][newC] == '1'){
                dfs(grid, newR, newC);
            }
        }
    }
}
``` 

1. dfs
2.  대부분 visited 배열을 따로 두어, 이미 방문했던 곳인지 확인을 하지만  
    grid 배열에  '1'로 바꾸면 되기 때문에 그럴 필요가 없다.
첫 인덱스부터 마지막 인덱스까지 dfs를 돌며,    
    연결된 섬을 확인하고 dfs가 끝나면 1을 증가시키는 방식을 사용한다.