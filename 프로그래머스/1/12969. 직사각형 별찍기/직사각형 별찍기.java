import java.util.Scanner;

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        
        for(int i = 0; i < b; i++) {
            String s = "";
            for(int j = 0; j < a; j++) {
                s += "*";
            }
            System.out.println(s);
        }
        
    }
}