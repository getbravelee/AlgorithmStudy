import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Node[] adjList;
    static boolean[] visited;
    static int maxDist, farthestNode = 0;
    static class Node {
        int to, weight;
        Node next;

        public Node(int to, int weight, Node next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        adjList = new Node[N];
        visited = new boolean[N];

        for (int i = 0; i < N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken())-1; // from
                int c = Integer.parseInt(st.nextToken())-1; // to
                int w = Integer.parseInt(st.nextToken());

                adjList[p] = new Node(c, w, adjList[p]);
                adjList[c] = new Node(p, w, adjList[c]);
        }

        dfs(0, 0);
        Arrays.fill(visited, false);

        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);

    }

    static void dfs(int v, int dist) {
        visited[v] = true;

        if(dist > maxDist) {
            maxDist = dist;
            farthestNode = v;
        }

        for (Node node = adjList[v]; node != null; node = node.next) {
            if (!visited[node.to]) {
                dfs(node.to, dist + node.weight);
            }
        }
    }
}