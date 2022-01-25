Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

이 문제는 섬의 수와 비슷합니다. 이 문제에서는 경계선에 있는 세포만 포위할 수 없다.   
그래서 우리는 먼저 Number of Islands와 같은 경계선에있는 O를 병합하고 O를 '#'으로 대체 한 다음 보드를 스캔하고   
모든 O의 왼쪽을 바꿀 수 있습니다 (있는 경우).   
- 그러니까 경계선에 있는 O 는 x가 될 수 없으니까 

1. Depth-first Search(dfs)

```java
public void solve(char[][] board) {
    if(board == null || board.length==0) 
        return;
 
    int m = board.length;
    int n = board[0].length;
 
    //merge O's on left & right boarder
    for(int i=0;i<m;i++){
        if(board[i][0] == 'O'){
            merge(board, i, 0);
        }
 
        if(board[i][n-1] == 'O'){
            merge(board, i, n-1);
        }
    }
 
    //merge O's on top & bottom boarder
    for(int j=0; j<n; j++){
         if(board[0][j] == 'O'){
            merge(board, 0, j);
        }
 
        if(board[m-1][j] == 'O'){
            merge(board, m-1, j);
        }
    }
 
    //process the board
    for(int i=0;i<m;i++){
        for(int j=0; j<n; j++){
            if(board[i][j] == 'O'){
                board[i][j] = 'X';
            }else if(board[i][j] == '#'){
                board[i][j] = 'O';
            }
        }
    }
}
 
public void merge(char[][] board, int i, int j){
    board[i][j] = '#';
 
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
 
    for(int k=0; k<4; k++){
        int x = i+dx[k];
        int y = j+dy[k];
 
        if(x>=0 && x<board.length
          && y>=0 && y<board[0].length
          && board[x][y]=='O'){
            merge(board, x, y);
        }
    }
}
```

- 여기서 dx랑 dy는 왜 항상 다른거지 ㅠㅠ


2.bfs
```java
public void solve(char[][] board) {
    if(board==null || board.length==0 || board[0].length==0)
        return;
 
    int m=board.length;
    int n=board[0].length;
 
 
    for(int j=0; j<n; j++){
        if(board[0][j]=='O'){
            bfs(board, 0, j);
        }
    }
 
    for(int j=0; j<n; j++){
        if(board[m-1][j]=='O'){
            bfs(board, m-1, j);
        }
    }
 
    for(int i=0; i<m; i++){
        if(board[i][0]=='O'){
            bfs(board, i, 0);
        }
    }
 
    for(int i=0; i<m; i++){
        if(board[i][n-1]=='O'){
            bfs(board, i, n-1);
        }
    }
 
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(board[i][j]=='O'){
                board[i][j]='X';
            }
            if(board[i][j]=='1'){
                board[i][j]='O';
            }
        }
    }
}
 
public void bfs(char[][] board, int o, int p){
    int m=board.length;
    int n=board[0].length;
 
    int index = o*n+p;
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.offer(index);
    board[o][p]='1';
 
    while(!queue.isEmpty()){
        int top = queue.poll();
        int i=top/n;
        int j=top%n;
 
        if(i-1>=0 && board[i-1][j]=='O'){
            board[i-1][j]='1';
            queue.offer((i-1)*n+j);
        }
        if(i+1<m && board[i+1][j]=='O'){
            board[i+1][j]='1';
            queue.offer((i+1)*n+j);
        }
        if(j-1>=0 && board[i][j-1]=='O'){
            board[i][j-1]='1';
            queue.offer(i*n+j-1);
        }
        if(j+1<n && board[i][j+1]=='O'){
            board[i][j+1]='1';
            queue.offer(i*n+j+1);
        }
    }
}
```