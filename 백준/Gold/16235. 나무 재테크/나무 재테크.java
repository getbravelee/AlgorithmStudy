import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[][] A,nutrients;
    static List<Tree>[][] map;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};

    static class Tree implements Comparable<Tree> {
        int old;

        public Tree(int old) {
            this.old = old;
        }

        public int compareTo(Tree o) {
            return this.old - o.old;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        nutrients = new int[N][N];
        map = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
                nutrients[i][j] = 5;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;
            int age = Integer.parseInt(st.nextToken());
            map[r][c].add(new Tree(age));
        }

        // 사계절 싸이클
        for (int k = 0; k < K; k++) {
            //봄
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Spring(i, j);
                }
            }
            //가을
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Fall(i, j);
                }
            }
            //겨울
            Winter();

        }
        // 나무 개수
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += map[i][j].size();
            }
        }

        System.out.println(cnt);
    }

    public static void Spring(int x, int y) {
        if (!map[x][y].isEmpty()) {
            Collections.sort(map[x][y]);
            List<Tree> newTrees = new ArrayList<>();
            List<Tree> deadTrees = new ArrayList<>();

            // 분리: 생존 나무와 죽은 나무 처리
            for (Tree tree : map[x][y]) {
                if (nutrients[x][y] >= tree.old) {
                    nutrients[x][y] -= tree.old;
                    tree.old++;
                    newTrees.add(tree);
                } else {
                    deadTrees.add(tree);
                }
            }
            map[x][y] = newTrees; // 생존 나무만 남기기

            // 죽은 나무 처리
            for (Tree tree : deadTrees) {
                nutrients[x][y] += tree.old / 2;
            }
        }
    }

    public static void Fall(int x, int y) {
        for (Tree t : map[x][y]) {
            if (t.old % 5 == 0) {
                for(int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        map[nx][ny].add(new Tree(1));
                    }
                }
            }
        }
    }

    public static void Winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrients[i][j] += A[i][j];
            }
        }
    }
}