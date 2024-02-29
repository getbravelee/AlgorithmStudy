import sys

input = sys.stdin.readline

N = int(input())
# 체력감소(각 보석의 무게)
L = list(map(int, input().split()))
# 기쁨(가치)
J = list(map(int, input().split()))
L, J = [0] + L, [0] + J
# 체력(무게한도)
W = 100

def knapsack(W, L, J, N):
    # dp를 위한 2차원 리스트 초기화
    K = [[0 for _ in range(W + 1)] for _ in range(N + 1)]
    for i in range(N + 1): # 행
        for j in range(W + 1): # 열
            if i == 0 or j == 0: # 0번째 행/열은 0으로 세팅
                K[i][j] = 0
                # i 번째 보석이 배낭의 무게 한도보다 크지 않은 경우 -> 보석을 배낭에 넣을 수 있다.
            elif L[i] <= j:
                # max(i번째 보석을 위해 i번재 보석만큼의 무게를 비웠을 때의 최적값에 i 번재 보석의 가격을 더한 값, i-1개의 보석들을 가지고 구한 전 단계의 최적 값)
                K[i][j] = max(J[i] + K[i-1][j-L[i]], K[i-1][j])
            else:
                # 무거워서 넣을 수 없다. -> i번쨰 보석을 뺀 i-1개의 보석들을 가지고 구한 전 단계의 최적 값을 그대로 가져온다.
                K[i][j] = K[i-1][j]
    return K[N][W]
# 체력이 0이 되면 안된다.
print(knapsack(99, L, J, N))