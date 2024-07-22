import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] sets = new int[6];
		for(int i = 0; i < 6; i++) {
			sets[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr = new int[2];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int tShirt = 0;
		int pens = 0;
		int pen = 0;

		for(int i = 0; i < 6; i++) {
			if(sets[i] == 0) {
				continue;
			}
			else if(arr[0] >= sets[i]) {
				tShirt++;
			}
			else if(arr[0] < sets[i] && sets[i] % arr[0] != 0){
				tShirt += (sets[i] / arr[0]) + 1;
			}
			else if(arr[0] < sets[i] && sets[i] % arr[0] == 0){
				tShirt += (sets[i] / arr[0]);
			}
		}
		pens = n / arr[1];
		pen = n % arr[1];
		
		System.out.println(tShirt);
		System.out.println(pens + " " + pen);
	}
}