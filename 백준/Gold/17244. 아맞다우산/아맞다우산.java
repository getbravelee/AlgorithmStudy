import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int startX, startY;
    static int[] select;
    static boolean[] Selected;
    static int[][] visited;
    static List<Item> items = new ArrayList<>();
    static int itemCnt;
    static int ans = Integer.MAX_VALUE;

    static class Item {
        int x, y, id;

        public Item(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if(c == 'S') {
                    startX = i;
                    startY = j;
                }
                else if (c == 'X') {
                    items.add(new Item(i,j,items.size()));
                }
            }
        }
        itemCnt = items.size();
        Selected = new boolean[itemCnt];
        select = new int[itemCnt];
        perm(0);
        System.out.println(ans);
    }

    static void perm(int depth) {
        if(depth == itemCnt) {
            bfs(startX, startY);
            return;
        }
        for (int i = 0; i < itemCnt; i++) {
            if(!Selected[i]) {
                Selected[i] = true;
                select[depth] = i;
                perm(depth + 1);
                Selected[i] = false;
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited = new int[N][M];
        int X = x, Y = y, Time = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }
        cute : for(int idx : select) { // 타겟 물건
            int itemX = items.get(idx).x;
            int itemY = items.get(idx).y;
            int itemId = items.get(idx).id;

            q.offer(new Point(X,Y,Time));
            while(!q.isEmpty()) {
                Point tmp = q.poll();

                if(tmp.x == itemX && tmp.y == itemY) { // 타켓에 도착했을 때
                    X = itemX; Y = itemY; Time = tmp.time; // 타켓에서 다시 다음 타겟찾기 위해 초기화
                    q.clear();
                    continue cute;
                }

                if(visited[tmp.x][tmp.y] == itemId) continue;
                visited[tmp.x][tmp.y] = itemId;

                for(int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] != itemId && map[nx][ny] != '#') {
                        q.offer(new Point(nx,ny,tmp.time+1));
                    }
                }
            }
        }

        // 마지막 도착지 가기
        q.offer(new Point(X,Y,Time));
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            if(map[tmp.x][tmp.y] == 'E') {
                ans = Math.min(ans, tmp.time);
                break;
            }
            if(visited[tmp.x][tmp.y] == 6) continue;
            visited[tmp.x][tmp.y] = 6;
            for(int j = 0; j < 4; j++) {
                int nx = tmp.x + dx[j];
                int ny = tmp.y + dy[j];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] != 6 && map[nx][ny] != '#') {
                    q.offer(new Point(nx,ny,tmp.time+1));
                }
            }
        }

    }
}