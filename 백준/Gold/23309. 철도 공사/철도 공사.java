import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prev = new int[1000001];
        int[] next = new int[1000001];

        st = new StringTokenizer(br.readLine());
        // 처음 역 세팅
        int firstStation = Integer.parseInt(st.nextToken());
        int lastStation = firstStation;

        for (int i = 1; i < N; i++) {
            int currStation = Integer.parseInt(st.nextToken());
            next[lastStation] = currStation;
            prev[currStation] = lastStation;
            lastStation = currStation; // 마지막 역 갱신
        }
        next[lastStation] = firstStation;
        prev[firstStation] = lastStation;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int X = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case "BN" :
                    int Y = Integer.parseInt(st.nextToken());
                    int nextX = next[X];

                    next[X] = Y;
                    prev[Y] = X;

                    if(nextX != 0) { // X뒤에 원래 역이 있었다면
                        next[Y] = nextX;
                        prev[nextX] = Y;
                    }
                    sb.append(nextX).append("\n");
                    break;

                case "BP" :
                    Y = Integer.parseInt(st.nextToken());
                    int prevX = prev[X];

                    prev[X] = Y;
                    next[Y] = X;

                    if (prevX != 0) {
                        prev[Y] = prevX;
                        next[prevX] = Y;
                    }

                    sb.append(prevX).append("\n");
                    break;

                case "CN" :
                    nextX = next[X];
                    next[X] = next[nextX];
                    prev[next[nextX]] = X;
                    sb.append(nextX).append("\n");
                    break;
                case "CP" :
                    prevX = prev[X];
                    prev[X] = prev[prevX];
                    next[prev[prevX]] = X;
                    sb.append(prevX).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
