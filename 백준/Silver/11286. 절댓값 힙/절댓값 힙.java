import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;

		// 입력 받을 정수 개수
		int n = Integer.parseInt(br.readLine());

		// 최소 절댓값을 구현할 우선순위 큐 초기화
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int absA = Math.abs(a);
			int absB = Math.abs(b);
			if (absA == absB)
				return a - b;
			return absA - absB;
		});

		// n 만큼 반복
		while (n-- > 0) {

			// 정수 입력
			int x = Integer.parseInt(br.readLine());
			
			// 0 아니면 추가
			if (x != 0) {
				pq.offer(x);
			}

			// 0 일 때
			else {
				// 비어있으면 0 출력
				if (pq.isEmpty()) {
					System.out.println(0);
				} 
				// 비우고 리턴
				else {
					System.out.println(pq.poll());
				}
			}

		}
	}
}