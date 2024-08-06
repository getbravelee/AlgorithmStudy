import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int n;
    static List<Integer>[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        arr = new ArrayList[n+1];
        result = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        dfs(1);

        for(int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }

    }
    public static void dfs(int k) {
        visited[k] = true;
        for(int i : arr[k]) {
            if(!visited[i]) {
                result[i] = k;
                dfs(i);
            }
        }
    }

}