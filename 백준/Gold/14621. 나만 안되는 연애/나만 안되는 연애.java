import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxCnt;
    static int[] parent;
    static char[] gens;

    static class Node implements Comparable<Node> {
        int from, to, value, check;

        public Node(int from, int to, int value, int check) {
            this.from = from;
            this.to = to;
            this.value = value;
            this.check = check;
        }

        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        gens = new char[N];
        String s = br.readLine();
        String newS = s.replace(" ", "");
        gens = newS.toCharArray();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int check = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(gens[v1-1] != gens[v2-1]) check = 1;
            else check = 0;

            pq.offer(new Node(v1, v2, w, check));
        }

        int total = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int from = find(tmp.from);
            int to = find(tmp.to);

            if (!isSameParent(from, to) && tmp.check == 1) {
                total += tmp.value;
                union(from, to);
                cnt++;
            }
        }
        if(cnt != N-1) {
            System.out.println(-1);
        }
        else {
            System.out.println(total);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        }
        return false;
    }
}
