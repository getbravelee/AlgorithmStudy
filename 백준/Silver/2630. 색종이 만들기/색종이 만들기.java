import java.util.*;
import java.io.*;

public class Main {

	static String[][] arr;
	static int color;
	static int white;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new String[n][n];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().split(" ");
		}
		division(0, 0, n);
		System.out.println(white);
		System.out.println(color);

	}

	public static boolean isOneColor(int row, int col, int size) {
		String check = arr[row][col];
		for (int i = row; i < row+size; i++) {
			for (int j = col; j < col+size; j++) {
				if (!arr[i][j].equals(check)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void division(int row, int col, int size) {
		if(isOneColor(row, col, size)) {
			if(arr[row][col].equals("0")) white++;
			else color++;
			return;
		}
		int newArrLen = size/2;
		
		division(row, col+newArrLen, newArrLen); // 1
		division(row, col, newArrLen); // 2
		division(row+newArrLen, col, newArrLen); // 3
		division(row+newArrLen, col+newArrLen, newArrLen); // 4

	}
}
