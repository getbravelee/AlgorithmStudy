import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] graph = new String[n][n];

        for(int i = 0; i < n; i++) {
            graph[i] = br.readLine().split("");
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            Set<Integer> friends = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if(graph[i][j].equals("Y")) {
                    friends.add(j);
                    for(int k = 0; k < n; k++) {
                        if(graph[j][k].equals("Y") && k != i) {
                            friends.add(k);
                        }
                    }
                }
            }
            result = Math.max(result, friends.size());
        }
        System.out.println(result);
    }
}