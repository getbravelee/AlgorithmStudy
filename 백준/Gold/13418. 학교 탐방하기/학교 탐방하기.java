import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parents;

    static class Node {
        int from, to, value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq1 = new PriorityQueue<>((o1, o2) -> o1.value - o2.value); // 최적의 코스
        PriorityQueue<Node> pq2 = new PriorityQueue<>((o1, o2) -> o2.value - o1.value); // 최악의 코스

        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq1.add(new Node(v1, v2, c));
            pq2.add(new Node(v1, v2, c));
        }

        make();
        int best = 0;  // 최적의 코스에서 오르막길 개수

        while (!pq1.isEmpty()) {
            Node tmp = pq1.poll();
            int from = tmp.from;
            int to = tmp.to;

            if (!isSameParent(from, to)) {
                if (tmp.value == 0) {  // 내리막길
                    best++;
                }
                union(from, to);
            }
        }

        make();
        int worst = 0;  // 최악의 코스에서 오르막길 개수

        while (!pq2.isEmpty()) {
            Node tmp = pq2.poll();
            int from = tmp.from;
            int to = tmp.to;

            if (!isSameParent(from, to)) {
                if (tmp.value == 0) {  // 내리막길
                    worst++;
                }
                union(from, to);
            }
        }

        // 피로도의 차이 계산
        int result = Math.abs(worst * worst - best * best);
        System.out.println(result);
    }

    static void make() {
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parents[y] = x;
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
