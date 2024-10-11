import java.io.*;
import java.util.*;

public class Main {

    static long attackerPower, maxHp;

    static class Room {
        long type, power, hp;

        public Room(long type, long power, long hp) {
            this.type = type;
            this.power = power;
            this.hp = hp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 방의 개수
        int attackerPower = Integer.parseInt(st.nextToken());  // 용사 공격력

        Room[] rooms = new Room[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int power = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());

            rooms[i] = new Room(type, power, hp);
        }
        long left = 1;
        long right = Long.MAX_VALUE;
        long result = 0;
        while(left <= right) {
            long mid = (left + right)/2;
            if (canSurvive(mid, attackerPower, rooms)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    static boolean canSurvive(long hp, long power, Room[] rooms) {
        maxHp = hp;
        long currHp = maxHp;
        long currPower = power;
        for (Room room : rooms) {
            if(room.type == 1)  { // 몬스터 방
                long cnt = 0; // 몬스터가 용사를 공격하는 횟수
                cnt = room.hp/currPower;
                if(room.hp % currPower == 0) cnt--;
                currHp -= cnt * room.power; // 체력 감소
                if(currHp <= 0) return false;
            }

            else { // 포션 방
                currPower += room.power; // 파워 업
                if(maxHp - currHp < room.hp) { // 체력회복
                    currHp = maxHp;
                }
                else {
                    currHp += room.hp;
                }
            }
        }
        return currHp > 0;
    }
}
