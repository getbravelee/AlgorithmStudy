import java.io.*;
import java.util.*;
 
class Solution {
    static int H, W, N, x, y;
    static char[][] board;
    static String command;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static char[] pos = {'^', '>', 'v', '<'};
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
             
            board = new char[H][W];
            for (int i = 0; i < H; i++) {
                board[i] = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    for (char p : pos) {
                        if (board[i][j] == p) {
                            x = i; y = j;
                        }
                    }
                }
            }
             
            N = Integer.parseInt(br.readLine());
            command = br.readLine();
            for (char cmd : command.toCharArray()) {
                switch (cmd) {
                    case 'U': move(0); break;
                    case 'R': move(1); break;
                    case 'D': move(2); break;
                    case 'L': move(3); break;
                    case 'S': shoot(); break;
                }
            }
             
            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                System.out.println(new String(board[i]));
            }
        }
    }
     
    public static void move(int d) {
        board[x][y] = pos[d];
        int nx = x + dx[d], ny = y + dy[d];
        if (0 <= nx && nx < H && 0 <= ny && ny < W && board[nx][ny] == '.') {
            board[nx][ny] = pos[d]; board[x][y] = '.';
            x = nx; y = ny;
        }
    }
     
    public static void shoot() {
        int idx = 0;
        for (int p = 0; p < 4; p++) {
            if (board[x][y] == pos[p]) {
                idx = p;
                break;
            }
        }
        int bx = x + dx[idx], by = y + dy[idx];
        while (0 <= bx && bx < H && 0 <= by && by < W) {
            if (board[bx][by] == '#') break;
            else if (board[bx][by] == '*') {
                board[bx][by] = '.';
                break;
            }
            bx += dx[idx]; by += dy[idx];
        }
    }
 
}