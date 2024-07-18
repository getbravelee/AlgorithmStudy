import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// n입력
		int n = Integer.parseInt(br.readLine());
		
		// 기존 좌표 저장 & 중복없는 오름차순 set
		int[] arr = new int [n];
		st = new StringTokenizer(br.readLine());
		
		Set<Integer> s = new HashSet<>();
		for(int i = 0; i < n; i++) {
			arr[i] = (Integer.parseInt(st.nextToken()));
			s.add(arr[i]);
		}
		List<Integer> tempSet = new ArrayList<>(s);
		Collections.sort(tempSet);
		
		// 
		Map<Integer, Integer> idxMap = new HashMap<>();
		for(int i = 0; i < tempSet.size(); i++) {
			idxMap.put(tempSet.get(i), i);
		}
		
		int[] result = new int[n];
		for(int i = 0; i < n; i++) {
			bw.write(String.valueOf(idxMap.get(arr[i])));
			if(i == n -1) {
				break;
			}
			bw.write(" ");
		}
		bw.flush();
	}
}
