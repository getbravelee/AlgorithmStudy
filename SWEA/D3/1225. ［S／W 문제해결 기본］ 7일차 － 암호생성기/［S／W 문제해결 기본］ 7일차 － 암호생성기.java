import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
            int i = 1;
            while(true) {
                int num = q.poll();
                if(num - i<= 0) {
                    num = 0;
                    q.add(num);
                    break;
                }
                q.add(num - i);

                i++;
                if (i == 6) {
                    i = 1;
                }
            }

                System.out.print("#" + tc + " ");
                for (int a = 0; a < 8; a++) {
                    System.out.print(q.poll() + " ");
                }
                System.out.println("\n");
        }

    }
}
