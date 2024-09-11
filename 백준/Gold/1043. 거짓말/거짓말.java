import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수
        Set<Integer> set = new HashSet<>(); // 진실을 아는 사람
        List<List<Integer>> parties = new ArrayList<>(); // 파티 정보

        st = new StringTokenizer(br.readLine());
        int numTruthPeople = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람 정보 초기화
        for (int i = 0; i < numTruthPeople; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 파티 정보 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        // 진실을 알게된 사람을 반복적으로 추가
        Queue<Integer> queue = new LinkedList<>(set);

        while (!queue.isEmpty()) {
            int currentPerson = queue.poll();
            for (List<Integer> party : parties) {
                if (party.contains(currentPerson)) {
                    for (int person : party) {
                        if (!set.contains(person)) {
                            set.add(person);
                            queue.add(person);
                        }
                    }
                }
            }
        }

        // 진실을 말할 수밖에 없는 방의 수 계산
        int cnt = 0;
        for (List<Integer> party : parties) {
            boolean containsTruth = false;
            for (int person : party) {
                if (set.contains(person)) {
                    containsTruth = true;
                    break;
                }
            }
            if (containsTruth) {
                cnt++;
            }
        }
        
        int ans = M - cnt;
        System.out.println(ans);
    }
}
