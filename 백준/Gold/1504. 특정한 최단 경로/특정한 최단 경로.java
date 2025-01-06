import java.io.*;
import java.util.*;

/*
* 무향 그래프 -> 양방향
* 1번에서 N번 정점까지 최단거리 이동
* - 2가지 조건 만족
*   - 임의로 주어진 두 정점 반드시 통과 -> 1 -> v1 -> v2 -> N 와 1 -> v2 -> v1 -> N 경우가 다를 수 있기 때문에 두 가지 다 고려해야 함
*   - 한 번 이동했던 정점 또는 간선도 다시 이동 가능
* */

public class Main {

    static int VERTEX_CNT, EDGE_CNT;
    static final int INF = 200000000; // 1000 * 200_000
    static ArrayList<ArrayList<Node>> adjList;
    static int move[];

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        VERTEX_CNT = Integer.parseInt(st.nextToken());
        EDGE_CNT = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        move = new int[VERTEX_CNT + 1];

        for (int i = 0; i <= VERTEX_CNT; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < EDGE_CNT; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList.get(from).add(new Node(to, weight));
            adjList.get(to).add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, VERTEX_CNT);

        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, VERTEX_CNT);

        int ans = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);
        System.out.println(ans);
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(move, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[VERTEX_CNT + 1];
        move[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int curr = tmp.end;

            if(!visited[curr]) {
                visited[curr] = true;

                for (Node node : adjList.get(curr)) {
                    if(!visited[node.end] && move[node.end] > move[curr] + node.weight) {
                        move[node.end] = move[curr] + node.weight;
                        pq.add(new Node(node.end, move[node.end]));
                    }
                }
            }
        }
        return move[end];
    }
}