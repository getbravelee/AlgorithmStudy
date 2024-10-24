import java.io.*;
import java.util.*;

public class Main {

    static int L,C;
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[] alpha = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha);

        List<List<Character>> list = new ArrayList<>();
        combination(alpha, new ArrayList<>(), list, L, 0);
        for (List<Character> chars : list) {
            for (char c : chars) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void combination(char[] alpha, List<Character> curr, List<List<Character>> list, int r, int start) {

        if (curr.size() == r) {
            int cnt = 0;
            for (char c : vowel) {
                if(curr.contains(c) ) {
                    cnt++;
                }
            }
            if(cnt == 0) {
                return;
            }
            if(L-cnt > 1) {
                list.add(new ArrayList<>(curr));
                return;
            }
        }
        for (int i = start; i < alpha.length; i++) {
            curr.add(alpha[i]);
            combination(alpha, curr, list, r, i+1);
            curr.remove(curr.size() - 1);
        }
    }
}
