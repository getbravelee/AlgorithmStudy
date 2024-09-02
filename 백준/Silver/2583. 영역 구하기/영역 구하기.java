import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M,K,cnt,area;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		int maxX = N, maxY = M;
		
		int startX = 0, endX = 0;
		int startY = 0, endY = 0;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			endX =  Integer.parseInt(st.nextToken());
			startY =  Integer.parseInt(st.nextToken());
			endY =  Integer.parseInt(st.nextToken());
			
			for(int j = N-endY; j < N-endX; j++) {
				for(int k = startX; k < startY; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		int cnt = 0;
		List<Integer> areaList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					area = 1;
					bfs(i,j);
					areaList.add(area);
					cnt++;
				}
			}
		}
		Collections.sort(areaList);
		System.out.println(cnt);
		String s = "";
		for(int i = 0; i < areaList.size(); i++) {
			s += areaList.get(i) + " ";
		}
		System.out.println(s);
	
		
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if(nx >= 0  && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 0) {
						q.offer(new Point(nx,ny));
						visited[nx][ny] = true;
						area++;
				}
			}
		}
	}
}
