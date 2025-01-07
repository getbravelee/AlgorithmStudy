import java.io.*;
import java.util.*;

/*
*
* */

public class Main {

    static int V, E, start;
    static ArrayList<ArrayList<Node>> adjList;
    static int[] move;
    static final int INF = 300_000 * 10;

    static class Node implements Comparable<Node> {
        int end, weight;

        Node (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st =  new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<Node>());
        }

        move = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(from).add(new Node(to, w));
        }

        dijkstra(start);
        for (int i = 1; i <= V; i++) {
            if(move[i] >= INF) {
                System.out.println("INF");
            }
            else {
                System.out.println(move[i]);
            }
        }
//        for (int i = 1; i <= V; i++) {
//            int end = i;
//            int result = dijkstra(start, end);
//            String inf = "INF";
//            String ans = result >= 3000_000 ? inf : "" + result;
//            System.out.println(ans);
//        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(move, INF);
        boolean[] visited = new boolean[V + 1];
        move[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int curr = tmp.end;

            if(!visited[curr]) {
                visited[curr] = true;

                for(Node node : adjList.get(curr)) {
                    if (!visited[node.end] && move[node.end] > move[curr] + node.weight) {
                        move[node.end] = move[curr] + node.weight;
                        pq.offer(new Node(node.end, move[node.end]));
                    }
                }
            }
        }
    }
}