import java.io.*;
import java.util.*;

public class Main {

    static int N, X, Y, D, G;
    static int[][] map;
    static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static int[] next = {1, 2, 3, 0};
    static int maxX, maxY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[101][101];
        int total = 0;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            List<Integer> history = new ArrayList<>();
            history.add(D);
            map[Y][X] = 1;
                for (int j = 1; j <= G; j++) {
                    int size = history.size();
                    for (int k = size-1; k >= 0; k--) {
                        int idx = history.get(k);
                        history.add(next[idx]);
                    }
                }

                for (int k = 0; k < history.size(); k++) {
                    int idx = history.get(k);
//                    System.out.println("idx: " + idx);
                    X += dir[idx][1];
                    Y += dir[idx][0];
                    map[Y][X] = 1;
                    maxX = Math.max(maxX, X);
                    maxY = Math.max(maxY, Y);

//                    System.out.println("x: " + X);
//                    System.out.println("y: " + Y);
                }

//            System.out.println("----------------");
        }
//        for (int i = 0; i < 101; i++) {
//            String s = "";
//            for (int j = 0; j < 100; j++) {
//                s += map[i][j];
//            }
//            System.out.println(s);
//        }
        // 갯수 카운트
        int[][] d = {{0,1}, {1,0}, {1,1}};
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if(map[i][j] == 1) {
                    int cnt = 1;
                    for (int k = 0; k < 3; k++) {
                        int ny = i + d[k][0];
                        int nx = j + d[k][1];
                        if(ny <= maxY && nx <= maxX && map[ny][nx] == 1) {
                            cnt++;
                        }
                    }
                    if(cnt == 4) {
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
    }

}
