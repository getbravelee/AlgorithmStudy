import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static class Node implements Comparable<Node> {
        int to, from, value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            pq.offer(new Node(t, f, v));
        }

        int total = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int to = find(tmp.to);
            int from = find(tmp.from);

            if (!isSameParent(to, from)) {
                total += tmp.value;
                union(tmp.to, tmp.from);
            }
        }

        System.out.println(total);

    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        }

        else {
            return false;
        }
    }
}
