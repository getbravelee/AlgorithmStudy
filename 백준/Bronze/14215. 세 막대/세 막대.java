import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = {a, b, c};
		Arrays.sort(arr);
		int sum = arr[0] + arr[1];

		while(arr[2] >= sum) {
			arr[2] -= 1;
		}
		
		System.out.println(arr[2]+sum);

	}	
}
