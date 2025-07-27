import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N + 1];
        int[] score = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        
        if (N == 1) {
            System.out.println(stair[1]);
            return;
        } else if (N == 2) {
            System.out.println(stair[1] + stair[2]);
            return;
        } else if (N == 3) {
            System.out.println(Math.max(stair[1], stair[2]) + stair[3]);
            return;
        }
        
        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        score[3] = Math.max(stair[1], stair[2]) + stair[3];
        
        for(int i = 4; i <= N; i++) {
            score[i] = Math.max(score[i-2], score[i-3] + stair[i-1]) + stair[i]; 
        }
        
        System.out.println(score[N]);
    }
}