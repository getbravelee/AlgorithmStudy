import java.io.*;
import java.util.*;

public class Main {

    static int[][] sandRatio1 = { // 왼쪽
            {0, 0, 2, 0, 0},
            {0, 10, 7, 1, 0},
            {5, 0, 0, 0, 0},
            {0, 10, 7, 1, 0},
            {0, 0, 2, 0, 0}
    };
    static int[][] sandRatio2 = { // 아래쪽
            {0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {2, 7, 0, 7, 2},
            {0, 10, 0, 10, 0},
            {0, 0, 5, 0, 0}
    };
    static int[][] sandRatio3 = { // 오른쪽
            {0, 0, 2, 0, 0},
            {0, 1, 7, 10, 0},
            {0, 0, 0, 7, 5},
            {0, 1, 7, 10, 0},
            {0, 0, 2, 0, 0}
    };
    static int[][] sandRatio4 = { // 위쪽
            {0, 0, 5, 0, 0},
            {0, 10, 0, 10, 0},
            {2, 7, 0, 7, 2},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0}
    };

    static int N, x, y;
    static int[] dx = {0, 1, 0, -1}; // 왼쪽, 아래, 오른쪽, 위 방향
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static int outSand = 0;

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

        x = N / 2;
        y = N / 2;
        int dist = 1; // 이동하는 거리
        int dir = 0; // 방향 (0: 왼쪽, 1: 아래, 2: 오른쪽, 3: 위)

        while (true) {
            for (int i = 0; i < 2; i++) { // 각 거리마다 두 번씩 방향 전환
                for (int j = 0; j < dist; j++) {
                    x += dx[dir];
                    y += dy[dir];
                    if (x < 0 || y < 0) {
                        System.out.println(outSand);
                        return;
                    }
                    func(x, y, dir);
                }
                dir = (dir + 1) % 4; // 방향 전환
            }
            dist++;
        }
    }

    static void func(int x, int y, int dir) {
        int sand = map[x][y];
        map[x][y] = 0;
        int[][] sandRatio;

        switch (dir) {
            case 0: sandRatio = sandRatio1; break; // 왼쪽
            case 1: sandRatio = sandRatio2; break; // 아래쪽
            case 2: sandRatio = sandRatio3; break; // 오른쪽
            default: sandRatio = sandRatio4; break; // 위쪽
        }

        int spreadSand = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int nx = x + i - 2;
                int ny = y + j - 2;
                int ratio = sandRatio[i][j];
                int amount = sand * ratio / 100;

                if (ratio > 0) {
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        map[nx][ny] += amount;
                    } else {
                        outSand += amount; // 맵 밖으로 나가는 모래
                    }
                    spreadSand += amount;
                }
            }
        }

        // 알파 위치
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        int remainingSand = sand - spreadSand;
        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
            map[nx][ny] += remainingSand;
        } else {
            outSand += remainingSand;
        }
    }
}
