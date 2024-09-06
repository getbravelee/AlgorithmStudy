import java.util.*;
import java.io.*;

public class Solution {
    /*
     * 제일 높은곳까지 가야한다. -> 제일 높은 곳 위치로부터 탐색을 하자
     * 높은곳에서 시작해서 모든 방향 탐색하면서 k만큼 깎아가며 최장경로 탐색
     * 언제깎아야할까 ? 현재 노드에서 갈 수 있는 경로가 같거나 남은 k만큼 깎을 수 있을때 깎자
     * 만약 깎아서 갔던 경로가 최대값보다 작다면 다시 이전으로 돌아가 다시 탐색
     * */
    static int N, K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int maxNum;
    static int answer;

    static class Point {
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
            }
            maxNum = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxNum = Math.max(maxNum, arr[i][j]);
                }
            }
            answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == maxNum) {
                        visited[i][j] = true;
                        dfs(i, j, 1, maxNum, 0);
                        visited[i][j] = false;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    // cnt : 공사한 횟수
    public static void dfs(int x, int y, int dist, int curr, int cnt) {
        answer = Math.max(answer, dist);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if(visited[nx][ny] == true) {
                continue;
            }
            if(arr[nx][ny] < curr) {
                visited[nx][ny] = true;
                dfs(nx, ny, dist+1, arr[nx][ny], cnt);
                visited[nx][ny] = false;
            }
            else {
                if(cnt == 0) {
                    if(arr[nx][ny] - K < curr) {
                        visited[nx][ny] = true;
                        dfs(nx, ny, dist+1, curr-1, cnt+1);
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }
}