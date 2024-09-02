import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 물고기 클래스 정의, Comparable 인터페이스를 구현하여 우선순위 큐에서 사용할 수 있도록 함
class Fish implements Comparable<Fish> {
    int x, y, dist;  // 물고기의 위치(x, y)와 현재 위치에서의 거리(dist)

    // 생성자: 위치와 거리를 초기화
    public Fish(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    // Comparable 인터페이스의 compareTo 메서드를 오버라이드하여 우선순위 큐에서의 정렬 기준 정의
    @Override
    public int compareTo(Fish other) {
        // 거리가 같은 경우
        if (this.dist == other.dist) {
            // x 좌표가 같은 경우 y 좌표를 기준으로 정렬
            if (this.x == other.x) {
                return this.y - other.y;
            }
            // 그렇지 않으면 x 좌표를 기준으로 정렬
            return this.x - other.x;
        }
        // 거리가 다른 경우 거리를 기준으로 정렬
        return this.dist - other.dist;
    }
}

public class Main {
    static int n;  // 그리드의 크기 (n x n)
    static int[][] grid;  // 그리드 배열
    static int[] dx = {-1, 0, 0, 1};  // 이동 방향을 나타내는 배열 (상, 좌, 우, 하)
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());    // 그리드 크기 입력 받음
        grid = new int[n][n];  // 그리드 초기화

        int x = 0, y = 0;  // 아기 상어의 초기 위치
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());  // 그리드 상태 입력 받음
                if (grid[i][j] == 9) {  // 아기 상어의 초기 위치를 찾음
                    x = i;
                    y = j;
                    grid[i][j] = 0;  // 아기 상어가 있던 위치를 빈 칸으로 변경
                }
            }
        }

        // 결과 출력: solve 메서드를 호출하여 아기 상어가 더 이상 먹을 물고기가 없을 때까지의 시간 계산
        System.out.println(solve(x, y));
    }

    // 아기 상어의 이동 및 먹이 탐색을 수행하는 메서드
    static int solve(int startX, int startY) {
        int size = 2;  // 아기 상어의 초기 크기
        int eaten = 0;  // 현재 크기에서 먹은 물고기 수
        int time = 0;  // 총 경과 시간

        while (true) {
            // BFS를 통해 현재 위치에서 먹을 수 있는 가장 가까운 물고기를 찾음
            Fish fish = bfs(startX, startY, size);

            // 더 이상 먹을 물고기가 없으면 현재까지의 시간을 반환
            if (fish == null) {
                return time;
            }

            // 먹을 수 있는 물고기를 찾았을 경우
            time += fish.dist;  // 물고기까지의 이동 시간을 더함
            startX = fish.x;  // 아기 상어의 위치를 물고기의 위치로 갱신
            startY = fish.y;
            eaten++;  // 먹은 물고기 수 증가
            grid[startX][startY] = 0;  // 물고기를 먹은 위치를 빈 칸으로 변경

            // 아기 상어가 현재 크기에서 먹어야 할 물고기 수를 모두 먹었을 경우 크기를 증가시킴
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }
    }

    // BFS를 통해 아기 상어가 현재 위치에서 먹을 수 있는 물고기를 찾는 메서드
    static Fish bfs(int startX, int startY, int size) {
        boolean[][] visited = new boolean[n][n];  // 방문 여부를 체크하기 위한 배열
        PriorityQueue<Fish> pq = new PriorityQueue<>();  // 우선순위 큐를 이용해 먹을 물고기를 선택
        Queue<Fish> q = new LinkedList<>();  // BFS를 위한 큐
        q.offer(new Fish(startX, startY, 0));  // 아기 상어의 초기 위치와 거리를 큐에 추가
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Fish current = q.poll();  // 현재 위치를 큐에서 꺼냄
            int x = current.x;
            int y = current.y;
            int dist = current.dist;

            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 그리드 안에 있고 방문하지 않았으며, 현재 상어 크기보다 작은 물고기나 빈 칸일 때
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && grid[nx][ny] <= size) {
                    visited[nx][ny] = true;  // 방문 처리
                    if (grid[nx][ny] > 0 && grid[nx][ny] < size) {
                        // 먹을 수 있는 물고기라면 우선순위 큐에 추가
                        pq.offer(new Fish(nx, ny, dist + 1));
                    }
                    // 큐에 다음 위치 추가
                    q.offer(new Fish(nx, ny, dist + 1));
                }
            }
        }

        // 먹을 수 있는 물고기가 없으면 null 반환, 있으면 가장 가까운 물고기를 반환
        return pq.isEmpty() ? null : pq.poll();
    }
}