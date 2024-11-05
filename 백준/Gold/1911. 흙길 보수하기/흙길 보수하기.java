import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point>{
        int start, end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Point o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        List<Point> map = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.add(new Point(x, y));
        }
        Collections.sort(map);

        int cnt = 0; // 필요한 갯수
        int start = 0;

        for (Point p : map) {
            if (start <= p.start) {
                start = p.start;
            }
            if(start > p.end) {
                continue;
            }
            int count = 0;
            count = (p.end - start) / L;
            if((p.end - start) % L != 0) count++;
            cnt += count;
            start += count*L;
        }
        System.out.println(cnt);
    }
}