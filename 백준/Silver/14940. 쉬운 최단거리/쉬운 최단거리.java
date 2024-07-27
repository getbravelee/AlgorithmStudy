import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    static int[][] graph;
    static int n;
    static int m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    static class Point {
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        int startX = 0, startY = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        bfs(startX, startY);
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    graph[i][j] = -1;
                }
                sb.append(graph[i][j] + " ");
            }
            System.out.println(sb.toString());
        }

    }
    public static int[][] bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        // 재방문 못하도록 크기가 똑같은 방문 그래프 초기화
        visited = new boolean[n][m];

        // 초기값
        q.offer(new Point(x, y));
        visited[x][y] = true;
        graph[x][y] = 0;

        // 큐가 빌때까지 탐색
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            for(int i = 0; i < 4; i++) {
                // 다음 위치 초기화 : 다음 위치 탐색하기 위함
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    // 0이면 패스
                    if(graph[nx][ny] == 0) {
                        continue;
                    }

                    // 이어져있으면 위치 값 + 1
                    graph[nx][ny] = graph[tmp.x][tmp.y] + 1;
                    // 방문 표시 : 재방문 하지 않기
                    visited[nx][ny] = true;

                    // 방문 하지 않았고 범위 내에 있다면 다음 경로 큐에 추가
                    q.offer(new Point(nx, ny));
                }
            }
        }
        return graph;
    }
}