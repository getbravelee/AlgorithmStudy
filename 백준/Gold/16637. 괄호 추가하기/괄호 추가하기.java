import java.util.*;
import java.io.*;

public class Main {
    static int ans;
    static List<Integer> nums = new ArrayList<>();
    static List<Character> opers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            if(Character.isDigit(s.charAt(i))) nums.add(s.charAt(i) - '0');
            else opers.add(s.charAt(i));
        }
        ans = Integer.MIN_VALUE;
        dfs(nums.get(0), 0);
        System.out.println(ans);

    }

    public static int calc(char op, int n1, int n2) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return -1;
    }

    public static void dfs(int result, int idx) {
        // 주어진 연산자의 개수를 초과하였을 경우.
        if (idx >= opers.size()) {
            ans = Math.max(ans, result);
            return;
        }

        int res = calc(opers.get(idx), result, nums.get(idx+1));
        dfs(res, idx + 1);
        // 괄호가 있는 경우
        if (idx + 1 < opers.size()) {
            // result의 오른쪽에 있는 값을 연산함.
            int res2 = calc(opers.get(idx + 1), nums.get(idx + 1), nums.get(idx + 2));

            // 현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
            dfs(calc(opers.get(idx), result, res2), idx + 2);
        }
    }
}
