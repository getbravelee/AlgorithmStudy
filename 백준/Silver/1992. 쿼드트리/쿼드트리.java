import java.io.*;
import java.util.*;

public class Main {

    static String[][] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }
        division(0,0,n);
        System.out.println(sb.toString());
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
            sb.append(arr[row][col]);
            return;
        }
        sb.append("(");
        int newArrLen = size/2;

        division(row, col, newArrLen); // 1
        division(row, col+newArrLen, newArrLen); // 2
        division(row+newArrLen, col, newArrLen); // 3
        division(row+newArrLen, col+newArrLen, newArrLen); // 4
        sb.append(")");
    }
}