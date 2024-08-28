import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static boolean[][] adjMatrix;
    static int totalPopulation;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        population = new int[N];
        adjMatrix = new boolean[N][N];
        totalPopulation = 0;
        
        // 각 구역의 인구 수 입력
        for (int i = 0; i < N; i++) {
            population[i] = sc.nextInt();
            totalPopulation += population[i];
        }
        
        // 인접 행렬 입력
        for (int i = 0; i < N; i++) {
            int adjCount = sc.nextInt();
            for (int j = 0; j < adjCount; j++) {
                int neighbor = sc.nextInt() - 1;
                adjMatrix[i][neighbor] = true;
                adjMatrix[neighbor][i] = true;
            }
        }
        
        // 모든 가능한 부분집합을 탐색
        for (int i = 1; i < (1 << N) - 1; i++) {
            if (isConnected(i) && isConnected(~i & ((1 << N) - 1))) {
                int areaPopulation = calculatePopulation(i);
                int otherPopulation = totalPopulation - areaPopulation;
                minDifference = Math.min(minDifference, Math.abs(areaPopulation - otherPopulation));
            }
        }
        
        // 최소 인구 차이 출력
        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
    }
    
    // 연결 여부 확인 (BFS 사용)
    static boolean isConnected(int bitmask) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        int start = -1;

        for (int i = 0; i < N; i++) {
            if ((bitmask & (1 << i)) != 0) {
                start = i;
                break;
            }
        }
        
        if (start == -1) return false;

        queue.add(start);
        visited[start] = true;

        int count = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int i = 0; i < N; i++) {
                if ((bitmask & (1 << i)) != 0 && adjMatrix[current][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }
        
        // 해당 부분집합의 크기와 방문한 노드의 수가 같다면 연결됨
        return count == Integer.bitCount(bitmask);
    }
    
    // 부분집합의 인구수 계산
    static int calculatePopulation(int bitmask) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if ((bitmask & (1 << i)) != 0) {
                sum += population[i];
            }
        }
        return sum;
    }
}