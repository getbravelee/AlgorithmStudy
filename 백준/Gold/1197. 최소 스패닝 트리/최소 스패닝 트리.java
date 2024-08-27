import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int to, from, value;

        public Edge(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        public int compareTo(Edge e) {
            return this.value - e.value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Queue<Edge> pq = new PriorityQueue<>();

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int vA = Integer.parseInt(st.nextToken());
            int vB = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(vA, vB, w));
        }

        int total = 0;

        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();

            int to = find(tmp.to);
            int from = find(tmp.from);

            if(!isSameParent(to, from)) {
                total += tmp.value;
                union(to, from);
            }
        }

        System.out.println(total);
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

     static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x<y) {
            parent[y]=x;
        }
        else {
            parent[x] =y;
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return true;
        else return false;
    }
}
