import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] students = new int[30];
        int result = 0;
        for(int i = 0; i < 28; i++) {
            int student = Integer.parseInt(br.readLine());
            students[student-1] = 1;
        }
        for (int i = 0; i < 30; i++) {
            if (students[i] == 0) {
                result = i+1;
                bw.write(result + "\n");
            }
        }
        bw.flush();
    }
}