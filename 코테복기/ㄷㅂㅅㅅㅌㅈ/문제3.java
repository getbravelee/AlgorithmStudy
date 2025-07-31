class 문제3 {
    public int solution(int D, int[] cakes) {
        int n = cakes.length;      // 장애물 개수
        int totalThrows = 0;       // 총 표창 던진 횟수
        int cookiePos = -D;        // 쿠키 현재 위치 (D만큼 떨어진 곳에서 시작)

        // 게임 진행: 모든 장애물을 제거하거나 통과할 때까지 반복
        while (true) {
            // 1. 표창 던지기 (매 턴마다 반드시 1개씩)
            totalThrows++;
            throwShuriken(cakes);   // 각 높이별로 가장 앞의 장애물만 제거

            // 2. 쿠키가 1칸 전진
            cookiePos++;

            // 3. 현재 위치에 장애물이 있는지 확인
            if (cookiePos >= 0 && cookiePos < n && cakes[cookiePos] > 0) {
                return -1;  // 장애물에 막혀서 게임 오버
            }

            // 4. 게임 종료 조건 확인
            if (cookiePos >= n || !hasObstacles(cakes)) {
                break;  // 모든 장애물을 통과했거나 제거했음
            }
        }

        return totalThrows;  // 성공: 총 표창 개수 반환
    }

    // 표창을 던져서 장애물 제거하는 메서드
    private void throwShuriken(int[] cakes) {
        // 각 높이별로 처리했는지 기록하는 배열 (같은 높이는 첫 번째만 맞음)
        boolean[] heightProcessed = new boolean[100001];

        // 모든 위치를 왼쪽부터 확인
        for (int i = 0; i < cakes.length; i++) {
            // 현재 위치에 장애물이 있고, 아직 그 높이를 처리하지 않았다면
            if (cakes[i] > 0 && !heightProcessed[cakes[i]]) {
                int originalHeight = cakes[i];  // 원래 높이 저장
                cakes[i]--;                     // 장애물 높이 1 감소
                heightProcessed[originalHeight] = true;  // 이 높이는 처리됨 표시

                // 예시: [2,2,3]에서 높이 2는 첫 번째 것만 맞고,
                //       두 번째 높이 2는 관통되지 않아서 안 맞음
            }
        }
    }

    // 아직 제거되지 않은 장애물이 있는지 확인하는 메서드
    private boolean hasObstacles(int[] cakes) {
        for (int height : cakes) {
            if (height > 0) return true;  // 높이가 0보다 큰 장애물이 하나라도 있으면 true
        }
        return false;  // 모든 장애물이 제거됨
    }
}
