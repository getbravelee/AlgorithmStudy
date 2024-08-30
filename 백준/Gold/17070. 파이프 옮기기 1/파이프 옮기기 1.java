import java.util.*;
import java.io.*;

public class Main {

    static int N, map[][], cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        pipe(0, 1, 1);
        System.out.println(cnt);

    }

    public static void pipe(int x, int y, int dir) {

        if (x >= N || y >= N || map[x][y] == 1) return; // 안되는 경우

        

        if (dir == 3) {
            // 대각선은 3칸을 차지하므로 3칸 모두 벽돌이 있으면 안된다.
            if(map[x][y-1] == 1 || map[x-1][y] == 1) return;
        }

        if(x == N-1 && y == N-1) {
            cnt++;
            return;
        }
        
        // 가로
        if (dir == 1) {
            pipe(x, y + 1, 1);
            pipe(x + 1, y + 1, 3);
        }
        // 세로
        else if (dir == 2) {
            pipe(x + 1, y, 2);
            pipe(x + 1, y + 1, 3);
        }
        // 대각선
        else if (dir == 3) {
            pipe(x, y + 1, 1);
            pipe(x + 1, y, 2);
            pipe(x + 1, y + 1, 3);
        }
    }
}