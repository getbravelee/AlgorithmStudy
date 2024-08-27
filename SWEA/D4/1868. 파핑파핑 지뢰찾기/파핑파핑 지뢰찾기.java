import java.io.*;
import java.util.*;

public class Solution {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Select implements Comparable<Select> {
        int x, y, cnt;

        Select(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public int compareTo(Select o) {
            return o.cnt - this.cnt;
        }
    }

    static boolean[][] visited;
    static String[][] map;
    static int N, cnt;
    static Queue<Point> q;

    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new String[N][N];
            visited = new boolean[N][N];
            cnt = 0;

            PriorityQueue<Select> pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().split("");
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isZero(i, j)) {
                        pq.offer(new Select(i,j,countDot(i,j)));
                    }
                    else if(map[i][j].equals("*")) visited[i][j] = true;
                }
            }
            while (!pq.isEmpty()) {
                Select tmp = pq.poll();
                if (visited[tmp.x][tmp.y]) continue;
                bfs(tmp.x, tmp.y);
                cnt++;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        cnt++;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isZero(int x, int y) {
        if(map[x][y].equals("*")) {
            visited[x][y] = true;
            return false;
        }

        boolean res = false;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny].equals("*")) return false;
                else res = true;
            }
        }
        return res;
    }

    public static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(!checkBoom(nx, ny)) {
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }

    }

    public static boolean checkBoom(int x, int y) {
        boolean boom = false;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(map[nx][ny].equals("*")) boom = true;
            }
        }
        return boom;
    }

    public static int countDot(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(map[nx][ny].equals(".")) cnt++;
            }
        }
        return cnt;
    }
}
