import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr = new int[100][100];
    static int r, c, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(simulate());
    }

    static int simulate() {
        int time = 0;
        int rowSize = 3, colSize = 3;

        while (time <= 100) {
            if (arr[r][c] == k) {
                return time;
            }
            if (rowSize >= colSize) {
                colSize = rowOperation(rowSize, colSize);
            } else {
                rowSize = columnOperation(rowSize, colSize);
            }
            time++;
        }
        return -1;
    }

    static int rowOperation(int rowSize, int colSize) {
        int maxColSize = 0;

        for (int i = 0; i < rowSize; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < colSize; j++) {
                int num = arr[i][j];
                if (num == 0) continue;
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            List<int[]> countList = new ArrayList<>();
            for (int key : countMap.keySet()) {
                countList.add(new int[]{key, countMap.get(key)});
            }
            countList.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

            int index = 0;
            for (int[] pair : countList) {
                if (index >= 100) break;
                arr[i][index++] = pair[0];
                arr[i][index++] = pair[1];
            }

            maxColSize = Math.max(maxColSize, index);
            while (index < 100) {
                arr[i][index++] = 0;
            }
        }
        return maxColSize;
    }

    static int columnOperation(int rowSize, int colSize) {
        int maxRowSize = 0;

        for (int j = 0; j < colSize; j++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < rowSize; i++) {
                int num = arr[i][j];
                if (num == 0) continue;
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            List<int[]> countList = new ArrayList<>();
            for (int key : countMap.keySet()) {
                countList.add(new int[]{key, countMap.get(key)});
            }
            countList.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

            int index = 0;
            for (int[] pair : countList) {
                if (index >= 100) break;
                arr[index++][j] = pair[0];
                arr[index++][j] = pair[1];
            }

            maxRowSize = Math.max(maxRowSize, index);
            while (index < 100) {
                arr[index++][j] = 0;
            }
        }
        return maxRowSize;
    }
}
