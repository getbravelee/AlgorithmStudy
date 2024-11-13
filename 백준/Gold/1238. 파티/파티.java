import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int idx, value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int compareTo(Node node) {
            return this.value - node.value;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[N + 1];
        ArrayList<Node>[] reverseList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, z));
            reverseList[y].add(new Node(x, z));
        }

        int[] a = dijkstra(list, X, N);
        int[] b = dijkstra(reverseList, X, N);

        int res = 0;

        for (int i = 1; i <= N; i++) {
            res = Math.max(res, a[i] + b[i]);
        }
        System.out.println(res);

    }

    static int[] dijkstra(ArrayList<Node>[] arr, int start, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int currIdx = current.idx;
            int currDist = current.value;

            if(currDist > dist[currIdx]) continue;

            for (Node n : arr[currIdx]) {
                int nextIdx = n.idx;
                int nextDist = n.value;
                int newDist = dist[currIdx] + nextDist;

                if(dist[nextIdx] > newDist) {
                    dist[nextIdx] = newDist;
                    pq.add(new Node(nextIdx, newDist));
                }
            }
        }
        return dist;
    }
}
