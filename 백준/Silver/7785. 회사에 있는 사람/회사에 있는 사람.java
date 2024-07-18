import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String io = st.nextToken();
            if (map.get(name) != null && map.get(name).equals("enter")) {
                map.remove(name);
            }
            else {
                map.put(name, io);
            }
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());

        for (String s : list) {
            System.out.println(s);
        }
    }
}