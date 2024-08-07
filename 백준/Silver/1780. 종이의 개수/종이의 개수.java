import java.util.*;
import java.io.*;

public class Main {
	
	static String[][] arr;
	static int n;
	static int a,b,c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new String[n][n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine().split(" ");
		}
		
		division(0,0,n);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}
	public static boolean isSameNum(int row, int col, int size) {
		String num = arr[row][col];
		for(int i = row; i < row+size; i++) {
			for(int j = col; j < col+size; j++) {
				if(!num.equals(arr[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void division(int row, int col, int size) {
		if(isSameNum(row, col, size)) {
			if(arr[row][col].equals("-1")) a++;
			else if(arr[row][col].equals("0")) b++;
			else c++;
			return;
		}
		int newlen = size/3;
		
		division(row, col, newlen); // 1
		division(row, col+newlen, newlen); // 2 
		division(row, col+2*newlen, newlen); // 3
		division(row+newlen, col, newlen); // 4
		division(row+newlen, col+newlen, newlen); // 5
		division(row+newlen, col+2*newlen, newlen); // 6
		division(row+2*newlen, col, newlen); // 7
		division(row+2*newlen, col+newlen, newlen); // 8
		division(row+2*newlen, col+2*newlen, newlen); // 9

	}
}