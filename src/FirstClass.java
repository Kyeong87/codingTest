import java.io.*;
import java.util.*;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

class Result {

    public static int n = 3;
    public static int m = 3;
    public static int[][] graph = new int[3][3];
    public static int[][] count = new int[8][8];

    // 이동할 8 가지 방향 정의 (상, 하, 좌, 우, 대각위오른쪽, 대각아래오른쪽, 대각위왼쪽, 대각아래왼쪽)
    public static int dx[] = {-1, 1, 0, 0, -1, 1, -1, 1};
    public static int dy[] = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void solution(String s, String keypad) {
        // s = 비밀번호
        // keypad = 키 순서
        int j = 0;
        for (int i = 0; i < 9; i++) {
            if(i==6) j=0;
            if(i>=3 && i<=5) {
                graph[1][j] = keypad.charAt(i) - '0';

                j++;
            }else if(i>=6 && i<=8) {
                graph[2][j] = keypad.charAt(i) - '0';
                j++;
            }else {
                graph[0][i] = keypad.charAt(i) - '0';
            }
        }

        int sumcount = 0;
        for(int l=0;l<s.length();l++) {
            int target = s.charAt(l) - '0';
            for(int it=0;it<3;it++) {
                for(int k=0;k<3;k++) {
                    if(graph[it][k]==target) {
                        if(l==0) {
                            bfs(it, k, l);
                        }else {
                            if(target == s.charAt(l-1) - '0') {

                                l = 1 + l;
                            }else if (Arrays.stream(count[l-1]).anyMatch(i -> i == target)) {
//                                System.out.println(Arrays.asList(arr).contains(stringToSearch));
//                                arr[i].equals(stringToSearch);
                                sumcount = sumcount + 1;
                                bfs(it, k, l);
                            } else {
                                sumcount = sumcount + 2;
                                bfs(it, k, l);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sumcount);
    }
    public static int[][] bfs(int x, int y, int j) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 8가지 방향으로의 위치 확인
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (graph[nx][ny] == 0) continue;
                if (graph[nx][ny] > 0) {
                    count[j][i] = graph[nx][ny];
                }
            }
        }

        return count;
    }

}

public class FirstClass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String keypad = bufferedReader.readLine();

        Result.solution(s, keypad);

        bufferedReader.close();
    }
}