import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] s = new String[n];
        String[] tmp = new String[m];
        int cnt = 0;
        for(int i = 0; i < n+m; i++) {
            if(i < n) {
                s[i] = br.readLine();
            }
            else {
                tmp[i-n] = br.readLine();
            }
        }
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tmp[j].equals(s[i])) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}