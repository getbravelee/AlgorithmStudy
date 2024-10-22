import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int maxSum;

    // 부메랑의 네 가지 방향에 대한 상대적인 좌표
    static int[][][] boo = {
            {{0, 0}, {-1, 0}, {0, 1}},  // 왼쪽 위로 꺾이는 모양
            {{0, 0}, {-1, 0}, {0, -1}}, // 오른쪽 위로 꺾이는 모양
            {{0, 0}, {1, 0}, {0, -1}},  // 오른쪽 아래로 꺾이는 모양
            {{0, 0}, {1, 0}, {0, 1}}    // 왼쪽 아래로 꺾이는 모양
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxSum = 0;
        dfs(0, 0, 0);  // 초기 좌표와 합계로 DFS 시작
        System.out.println(maxSum);
    }

    static void dfs(int x, int y, int sum) {
        if (x >= N) {
            maxSum = Math.max(maxSum, sum);  // 최대 합계 갱신
            return;
        }

        // 다음 좌표 계산
        int nextX = x;
        int nextY = y + 1;

        if (nextY == M) {
            nextX++;
            nextY = 0;
        }

        // 현재 위치에 부메랑을 놓을 수 있는지 확인하고, 놓을 수 있다면 DFS 진행
        if (!visited[x][y]) {
            for (int i = 0; i < 4; i++) {
                if (canPlaceBoo(x, y, i)) {
                    placeBoo(x, y, i, true); // 부메랑 놓음
                    dfs(nextX, nextY, sum + calcSum(x, y, i));
                    placeBoo(x, y, i, false); // 부메랑 다시 회수
                }
            }
        }

        // 현재 위치에 부메랑을 놓지 않고 다음으로 넘어감
        dfs(nextX, nextY, sum);
    }

    // 부메랑을 놓을 수 있는지 확인
    static boolean canPlaceBoo(int x, int y, int direction) {
        for (int[] d : boo[direction]) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    // 부메랑을 놓거나 회수
    static void placeBoo(int x, int y, int direction, boolean flag) {
        for (int[] d : boo[direction]) {
            int nx = x + d[0], ny = y + d[1];
            visited[nx][ny] = flag;
        }
    }

    // 부메랑을 놓았을 때의 합계 계산
    static int calcSum(int x, int y, int direction) {
        int total = 0;
        for (int[] d : boo[direction]) {
            int nx = x + d[0], ny = y + d[1];
            total += map[nx][ny];
        }
        return total + map[x][y];  // 보의 중심은 두 번 더해짐
    }
}