import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Node>[] list;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] dist;

    static class Node implements Comparable<Node> {
        int idx, value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
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

        list = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(dist, (int) 1e9);
        dist[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, z));
            list[y].add(new Node(x, z));
        }

        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int minIdx = current.idx;
            int minDist = current.value;

            if (minDist != dist[minIdx]) continue;

            for (Node neighbor : list[minIdx]) {
                int nextIdx = neighbor.idx;
                int nextDist = neighbor.value;

                int newDist = dist[minIdx] + nextDist;
                if (dist[nextIdx] > newDist) {
                    dist[nextIdx] = newDist;
                    pq.add(new Node(nextIdx, newDist));
                }
            }
        }
        System.out.println(dist[N]);
    }
}
