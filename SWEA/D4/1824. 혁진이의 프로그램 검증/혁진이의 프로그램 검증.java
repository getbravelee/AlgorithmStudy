import java.util.*;
import java.io.*;

public class Solution {
    static char[][] map;
    static int R, C;
    static int memory;
    static boolean[][][][] visited;
    static int[] dx = { -1, 1, 0, 0 }; // 위, 아래, 좌, 우
    static int[] dy = { 0, 0, -1, 1 };
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            visited = new boolean[R][C][16][4]; // 메모리 상태와 방향에 따른 방문 기록

            for (int i = 0; i < R; i++) {
                String s = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            memory = 0; // 메모리 초기화
            if (bfs()) {  // BFS로 경로 탐색
                sb.append("#").append(tc).append(" YES\n");
            } else {
                sb.append("#").append(tc).append(" NO\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, 0, 3 }); // 시작점 (0, 0), 메모리 0, 오른쪽(3) 방향
        visited[0][0][0][3] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            int mem = current[2], dir = current[3];

            char command = map[x][y];

            // 종료 조건
            if (command == '@') {
                return true;
            }

            // 메모리 변경
            if (Character.isDigit(command)) {
                mem = command - '0';
            } else if (command == '+') {
                mem = (mem + 1) % 16;
            } else if (command == '-') {
                mem = (mem + 15) % 16;
            }

            // 방향 변경
            if (command == '<') {
                dir = 2; // 왼쪽
            } else if (command == '>') {
                dir = 3; // 오른쪽
            } else if (command == '^') {
                dir = 0; // 위
            } else if (command == 'v') {
                dir = 1; // 아래
            } else if (command == '_') {
                dir = (mem == 0) ? 3 : 2; // 메모리가 0이면 오른쪽, 아니면 왼쪽
            } else if (command == '|') {
                dir = (mem == 0) ? 1 : 0; // 메모리가 0이면 아래, 아니면 위
            }

            if (command == '?') {
                for (int i = 0; i < 4; i++) {
                    int nx = (x + dx[i] + R) % R;
                    int ny = (y + dy[i] + C) % C;
                    if (!visited[nx][ny][mem][i]) {
                        visited[nx][ny][mem][i] = true;
                        queue.offer(new int[] { nx, ny, mem, i });
                    }
                }
            } else {
                int nx = (x + dx[dir] + R) % R;
                int ny = (y + dy[dir] + C) % C;
                if (!visited[nx][ny][mem][dir]) {
                    visited[nx][ny][mem][dir] = true;
                    queue.offer(new int[] { nx, ny, mem, dir });
                }
            }
        }
        return false;
    }
}