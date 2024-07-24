import java.io.*;
import java.util.*;

/*
10101111 12시부터 시계방향  n,s
01111101
11001110
00000010
2		 회전 횟수
3 -1	 톱니바퀴 번호 방향
1 1		 

각 톱니바퀴의 12시의 n,s에 따라 점수 부여

마주보는 이빨의 극이 같으면 회전하지 않는다.
연쇄적으로 회전한다. 만약 3번 기어를 돌렸을때 2번이 회전해야 1번이 회전하든지 말든지 할 수 있다.

n : 0
s : 1
*/

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 기어 초기화
		String[][] gears = new String[4][8];
		for (int i = 0; i < 4; i++) {
			gears[i] = br.readLine().split("");
		}
		
		// 회전
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int gearNum = Integer.parseInt(st.nextToken()) - 1; // 기어 인덱스
			int dir = Integer.parseInt(st.nextToken()); // 방향, 1(시계)
			
			// 기어 방향정보
			int[] d = new int[4];
			
			// 중심 기어 방향 초기화
			d[gearNum] = dir;
			
			// 중심 기어 기준 왼쪽 기어 회전 정보 담기
			for (int left = gearNum - 1; left >= 0; left--) {
			    if (!gears[left][2].equals(gears[left + 1][6])) {
			        d[left] = d[left+1] * (-1);
			    } else {
			        break;
			    }
			}

			// 중심 기어 기준 오른쪽 기어 회전 정보 담기
			for (int right = gearNum + 1; right < 4; right++) {
			    if (!gears[right][6].equals(gears[right - 1][2])) {
			        d[right] = d[right-1] * (-1);
			    } else {
			        break;
			    }
			}
			
			// 각 기어 회전 정보에 따라 회전
			for(int j = 0; j < 4; j++) {
				gears[j] = rotate(gears[j], d[j]);
			}

		}
		// 점수
		int[] score = { 1, 2, 4, 8 };
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (gears[i][0].equals("1")) {
				sum += score[i];
			}
		}
		System.out.println(sum);
	}


	public static String[] rotate(String[] gear, int dir) {
		Deque<String> list = new LinkedList<>(Arrays.asList(gear));
		// 반시계 방향
		if (dir == -1) {
			list.add(list.poll());
		}
		// 시계 방향
		if (dir == 1){
			list.addFirst(list.pollLast());
		}

		String[] result = list.toArray(new String[0]);
		return result;
	}
}