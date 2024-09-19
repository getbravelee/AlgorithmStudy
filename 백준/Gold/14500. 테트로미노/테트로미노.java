import java.io.*;
import java.util.*;

public class Main {

    static int N, M, sum, maxSum;
    static int[][] map, copy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxSum = Math.max(maxSum, Shape.one(i,j));
                maxSum = Math.max(maxSum, Shape.two(i,j));
                maxSum = Math.max(maxSum, Shape.three(i,j));
                maxSum = Math.max(maxSum, Shape.four(i,j));
                maxSum = Math.max(maxSum, Shape.five(i,j));
                maxSum = Math.max(maxSum, Shape.six(i,j));
                maxSum = Math.max(maxSum, Shape.seven(i,j));
                maxSum = Math.max(maxSum, Shape.eight(i,j));
                maxSum = Math.max(maxSum, Shape.nine(i,j));
                maxSum = Math.max(maxSum, Shape.ten(i,j));
                maxSum = Math.max(maxSum, Shape.eleven(i,j));
                maxSum = Math.max(maxSum, Shape.twelve(i,j));
                maxSum = Math.max(maxSum, Shape.thirteen(i,j));
                maxSum = Math.max(maxSum, Shape.fourteen(i,j));
                maxSum = Math.max(maxSum, Shape.fifteen(i,j));
                maxSum = Math.max(maxSum, Shape.sixteen(i,j));
                maxSum = Math.max(maxSum, Shape.seventeen(i,j));
                maxSum = Math.max(maxSum, Shape.eighteen(i,j));
                maxSum = Math.max(maxSum, Shape.nineteen(i,j));
            }
        }

        System.out.println(maxSum);
    }

    static class Shape {
        public static int one(int x, int y) {
            sum = 0;
            if (x <= N - 4) {
                sum = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 3][y];
            }
            return sum;
        }

        public static int two(int x, int y) {
            sum = 0;
            if (y <= M - 4) {
                sum = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x][y + 3];
            }
            return sum;
        }

        public static int three(int x, int y) {
            sum = 0;
            if (x <= N - 2 && y <= M - 2) {
                sum = map[x][y] + map[x][y + 1] + map[x + 1][y] + map[x + 1][y + 1];
            }
            return sum;
        }

        public static int four(int x, int y) {
            sum = 0;
            if (x <= N - 3 && y <= M - 2) {
                sum = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 2][y + 1];
            }
            return sum;
        }

        public static int five(int x, int y) {
            sum = 0;
            if (x <= N - 3 && y <= M - 2) {
                sum = map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1] + map[x + 2][y];
            }
            return sum;
        }

        public static int six(int x, int y) {
            sum = 0;
            if (x <= N - 2 && y <= M - 3) {
                sum = map[x][y] + map[x + 1][y] + map[x][y + 1] + map[x][y + 2];
            }
            return sum;
        }

        public static int seven(int x, int y) {
            sum = 0;
            if (x <= N - 2 && y <= M - 3) {
                sum = map[x][y] + map[x + 1][y + 2] + map[x][y + 1] + map[x][y + 2];
            }
            return sum;
        }

        public static int eight(int x, int y) {
            sum = 0;
            if (x <= N - 2 && y <= M - 3) {
                sum = map[x + 1][y] + map[x + 1][y + 1] + map[x + 1][y + 2] + map[x][y + 2];
            }
            return sum;
        }

        public static int nine(int x, int y) {
            sum = 0;
            if (x <= N - 2 && y <= M - 3) {
                sum = map[x + 1][y] + map[x + 1][y + 1] + map[x + 1][y + 2] + map[x][y];
            }
            return sum;
        }

        public static int ten(int x, int y) {
            sum = 0;
            if (x <= N - 3 && y <= M - 2) {
                sum = map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1];
            }
            return sum;
        }

        public static int eleven(int x, int y) {
            sum = 0;
            if (x <= N - 3 && y <= M - 2) {
                sum = map[x][y] + map[x][y + 1] + map[x + 1][y] + map[x + 2][y];
            }
            return sum;
        }

        public static int twelve(int x, int y) {
            sum = 0;
            if (x <= N - 3 && y <= M - 2) {
                sum = map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 2][y + 1];
            }
            return sum;
        }

        public static int thirteen(int x, int y) {
            sum = 0;
            if (x <= N - 3 && y <= M - 2) {
                sum = map[x][y + 1] + map[x + 1][y + 1] + map[x + 1][y] + map[x + 2][y];
            }
            return sum;
        }

        public static int fourteen(int x, int y) {
            sum = 0;
            if (x <= N - 2 && y <= M - 3) {
                sum = map[x][y + 1] + map[x][y + 2] + map[x + 1][y] + map[x + 1][y + 1];
            }
            return sum;
        }

        public static int fifteen(int x, int y) {
            sum = 0;
            if (x <= N - 2 && y <= M - 3) {
                sum = map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 1][y + 2];
            }
            return sum;
        }

        public static int sixteen(int x, int y) {
            sum = 0;
            if (x <= N - 2 && y <= M - 3) {
                sum = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1];
            }
            return sum;
        }

        public static int seventeen(int x, int y) {
            sum = 0;
            if (x <= N - 2 && y <= M - 3) {
                sum = map[x][y + 1] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 1][y + 2];
            }
            return sum;
        }

        public static int eighteen(int x, int y) {
            sum = 0;
            if (x <= N - 3 && y <= M - 2) {
                sum = map[x + 1][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1];
            }
            return sum;
        }

        public static int nineteen(int x, int y) {
            sum = 0;
            if (x <= N - 3 && y <= M - 2) {
                sum = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1];
            }
            return sum;
        }
    }
}