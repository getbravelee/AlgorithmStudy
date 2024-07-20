import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        // 테스트 케이스 수만큼 반복
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean[] isPrime = sieveOfEratosthenes(num);
            ArrayList<Integer> primes = new ArrayList<>();
            
            // 소수 리스트 생성
            for (int j = 2; j < num; j++) {
                if (isPrime[j]) {
                    primes.add(j);
                }
            }
            
            // 소수 집합 생성
            HashSet<Integer> primeSet = new HashSet<>(primes);
            int count = 0;
            
            // 두 소수의 합 계산
            for (int prime : primes) {
                if (primeSet.contains(num - prime)) {
                    count++;
                    if (num == prime * 2) {
                        count++; // 같은 소수 두 번 더해지는 경우 추가
                    }
                }
            }
            
            bw.write((count / 2) + "\n"); // 중복된 카운트를 2로 나누기
        }
        
        bw.flush();
        bw.close();
    }

    // 에라토스테네스의 체 알고리즘
    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}