import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map, castle;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int[] dir = {1, 2, 4, 8}; // 서 북 동 남
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int cntRoom, maxArea, res;
    static HashMap<Integer, Set<Integer>> sideRoom = new HashMap<>(); // 인접 방 정보, 키 : 방번호, 벨류 : 인접방 번호
    static List<Integer> areaList = new ArrayList<>(); // 방 넓이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        castle = new int[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    bfs(i,j,num++);
                    cntRoom++;
                }
            }
        }

        System.out.println(cntRoom);
        System.out.println(maxArea);
        for (int i = 1; i <= cntRoom; i++) {
            if (sideRoom.get(i) != null) {
                for(int j : sideRoom.get(i)) {
                    res = Math.max(res, areaList.get(i - 1) + areaList.get(j - 1));
                }
            }
        }
        System.out.println(res);
//        for (int i = 0; i < N; i++) {
//            String s = "";
//            for (int j = 0; j < M; j++) {
//                s += map[i][j] + " ";
//            }
//            System.out.println(s);
//        }
    }

    static void bfs(int x, int y, int num) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        map[x][y] = num;
        int area = 1;
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    // 열린 방향 찾고, 다음 방이 열려있다면 (예 : 현재 동쪽이 열려있음. 다음 방은 서쪽이 열려 있어야 함)
                    if((castle[p.x][p.y] & dir[i]) == 0 && (castle[nx][ny] & dir[(i+2)%4]) == 0 && map[nx][ny] == 0) {
                        map[nx][ny] = num;
                        q.offer(new Point(nx, ny));
                        area++;
                    }
                    // 인접방 정보
                    else if(map[nx][ny] != 0 && map[nx][ny] != num) {
                        set.add(map[nx][ny]); // 인접 방 정보
                    }
                }
            }
        }
        sideRoom.put(num, set);
        areaList.add(area);
        maxArea = Math.max(maxArea, area);
    }
}