import java.io.*;
import java.util.*;

public class Main {
    static int len;
    static char[] cs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        String s = br.readLine();
        len = s.length();
        cs = s.toCharArray();

        // 주기 찾기
        HashSet<String> set = new HashSet<>();
        int cycleLength = 0;
        String original = new String(cs);
        set.add(original);  // 원래 문자열을 미리 추가

        while (true) {
            func();
            cycleLength++;
            String current = new String(cs);
            if (set.contains(current)) {
                break;
            }
            set.add(current);
        }

        // X를 주기로 나눈 나머지만큼만 실행
        X = X % cycleLength;
        cs = original.toCharArray();  // 초기 상태로 재설정

        for (int i = 0; i < X; i++) {
            func();
        }

        System.out.println(new String(cs));
    }

    // 섞기
    static void func() {
        char[] arr = new char[len];
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                arr[i / 2] = cs[i];
            } else {
                arr[len - 1 - (i / 2)] = cs[i];
            }
        }
        cs = arr;
    }
}