import java.io.*;
import java.util.*;

public class Main {

    static int N,M,islandCnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> q;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent;

    static class Point {
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node> {
        int to, from, value;

        Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

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

        islandCnt = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) islandIndexing(i, j, islandCnt++);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0) makeBridge(i, j, map[i][j]);
            }
        }
        islandCnt--;
        parent = new int[islandCnt];
        for (int i = 1; i < islandCnt; i++) {
            parent[i] = i;
        }

        int res = kruskal();
        System.out.println(res == 0 ? -1 : res);

    }

    public static void islandIndexing(int x, int y, int idx) {
        q = new LinkedList<>();

        q.offer(new Point(x, y));
        visited[x][y] = true;
        map[x][y] = idx;

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                    map[nx][ny] = idx;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void makeBridge(int x, int y, int idx) {
        q = new LinkedList<>();
        visited = new boolean[N][M];
        for (int i = 0; i < 4; i++) {
            q.offer(new Point(x, y));
            visited[x][y] = true;
            int move = 0;

            while (!q.isEmpty()) {
                Point tmp = q.poll();

                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != idx) {
                    visited[nx][ny] = true;

                    if (map[nx][ny] == 0) {
                        q.offer(new Point(nx, ny));
                        move++;
                    }
                    else {
                        int to = map[nx][ny]-1;
                        int from = idx-1;
                        int value = move;
                        if (value > 1) {
                            pq.offer(new Node(to, from, value));
                        }
                        break;
                    }
                }
            }
        }
    }
    public static int kruskal() {
        int total = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            int to = find(tmp.to);
            int from = find(tmp.from);

            if (!isSameParent(to, from)) {
                total += tmp.value;
                union(to, from);
            }
        }
        int rx = parent[1];
        for (int i = 2; i < islandCnt; i++) {
            if (rx != find(parent[i])) {
                return 0;
            }
        }

        return total;
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        int rx = find(parent[x]);
        return rx;

    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x<y) {
            parent[y]=x;
        }
        else {
            parent[x] =y;
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return true;
        else return false;
    }

}
