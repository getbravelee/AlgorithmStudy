import java.util.*;

class Fish implements Comparable<Fish> {
    int x, y, dist;

    public Fish(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Fish other) {
        if (this.dist == other.dist) {
            if (this.x == other.x) {
                return this.y - other.y;
            }
            return this.x - other.x;
        }
        return this.dist - other.dist;
    }
}

public class Main {
    static int n;
    static int[][] grid;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 9) {
                    x = i;
                    y = j;
                    grid[i][j] = 0;
                }
            }
        }

        System.out.println(solve(x, y));
    }

    static int solve(int startX, int startY) {
        int size = 2;
        int eaten = 0;
        int time = 0;

        while (true) {
            Fish fish = bfs(startX, startY, size);

            if (fish == null) {
                return time;
            }

            time += fish.dist;
            startX = fish.x;
            startY = fish.y;
            eaten++;
            grid[startX][startY] = 0;

            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }
    }

    static Fish bfs(int startX, int startY, int size) {
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        Queue<Fish> q = new LinkedList<>();
        q.offer(new Fish(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Fish current = q.poll();
            int x = current.x;
            int y = current.y;
            int dist = current.dist;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && grid[nx][ny] <= size) {
                    visited[nx][ny] = true;
                    if (grid[nx][ny] > 0 && grid[nx][ny] < size) {
                        pq.offer(new Fish(nx, ny, dist + 1));
                    }
                    q.offer(new Fish(nx, ny, dist + 1));
                }
            }
        }

        return pq.isEmpty() ? null : pq.poll();
    }
}