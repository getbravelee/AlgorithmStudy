import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    static Map<Integer, Character> directions = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1;  // 사과가 있는 위치
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            directions.put(X, C);
        }

        System.out.println(simulate());
    }

    static int simulate() {
        int time = 0;
        int x = 0, y = 0; // 뱀의 시작 위치
        int dir = 0; // 0: 동, 1: 남, 2: 서, 3: 북
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        board[0][0] = 2; // 뱀이 있는 위치

        while (true) {
            if (directions.containsKey(time)) {
                dir = (dir + (directions.get(time) == 'L' ? 3 : 1)) % 4;
            }
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2) {
                time++;
                break;
            }

            if (board[nx][ny] != 1) {
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0; // 꼬리 제거
            }
            board[nx][ny] = 2;
            snake.addFirst(new int[]{nx, ny});
            x = nx;
            y = ny;
            time++;
        }

        return time;
    }
}