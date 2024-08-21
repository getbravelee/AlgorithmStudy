import java.util.*;
import java.io.*;

public class Solution {
    static int[][] map, newMap;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String cmd = st.nextToken();

            map = new int[N][N];
            visited = new boolean[N][N];
            newMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            switch(cmd) {
                case "up" : up(); break;
                case "down" : down(); break;
                case "left" : left(); break;
                case "right" : right(); break;
            }

            sb.append("#").append(tc).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(newMap[i][j]).append(" ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
    public static Deque<Integer> push (Queue<Integer> q) {
        Deque<Integer> res = new LinkedList<>();
        boolean check = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (tmp == 0) {
                continue;
            }
            else if (res.isEmpty() || !check) {
                res.add(tmp);
                check = true;
            }
            else {
                if (res.peekLast() == tmp) {
                    res.add(res.pollLast() * 2);
                    check = false;
                }
                else {
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    public static void up() {
        for (int j = 0; j < N; j++) {
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < N; i++) q.add(map[i][j]);

            Deque<Integer> res = push(q);
            for (int i = 0; i < N; i++) {
                if (!res.isEmpty()) newMap[i][j] = res.poll();
            }
        }
    }

    public static void down() {
        for (int j = 0; j < N; j++) {
            Queue<Integer> q = new LinkedList<>();
            for (int i = N-1; i >= 0 ; i--) q.add(map[i][j]);

            Deque<Integer> res = push(q);
            for (int i = N-1; i >= 0 ; i--) {
                if (!res.isEmpty()) newMap[i][j] = res.poll();
            }
        }
    }

    public static void right() {
        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            for (int j = N-1; j >= 0; j--) q.add(map[i][j]);

            Deque<Integer> res = push(q);
            for (int j = N-1; j >= 0; j--) {
                if (!res.isEmpty()) newMap[i][j] = res.poll();
            }
        }
    }

    public static void left() {
        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < N; j++) q.add(map[i][j]);

            Deque<Integer> res = push(q);
            for (int j = 0; j < N; j++) {
                if (!res.isEmpty()) newMap[i][j] = res.pollFirst();
            }
        }
    }
}