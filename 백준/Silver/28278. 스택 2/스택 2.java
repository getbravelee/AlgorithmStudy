import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
                if ("1".equals(cmd)) {
                    stack.addFirst(st.nextToken());
                }
                else if ("2".equals(cmd)) {
                    if (!stack.isEmpty()) System.out.println(stack.removeFirst());
                    else System.out.println(-1);
                }
                else if ("3".equals(cmd)) {
                    System.out.println(stack.size());
                }
                else if ("4".equals(cmd)) {
                    if(stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                }
                else if ("5".equals(cmd)) {
                    if(!stack.isEmpty()) System.out.println(stack.peek());
                    else System.out.println(-1);
            }
        }
    }
}