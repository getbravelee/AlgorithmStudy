import sys

input = sys.stdin.readline
n = int(input())
c = [list(input().strip()) for _ in range(n)]

result = 0

def check() :
    max_cnt = 1
    for i in range(n) :
        cnt = 1
        # 가로 비교
        for j in range(n) :
            if j+1 < n and c[i][j] == c[i][j+1] :
                cnt += 1
            # 다른 사탕을 만나면 새롭게 카운트하기 위해서 초기화 시키기
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)
        # 세로 비교
        for j in range(n) :
            if j+1 < n and c[j][i] == c[j+1][i] :
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)
    return max_cnt

#swap
for i in range(n) :
    for j in range(n-1) :
        # 가로 스왑
        if c[i][j] != c[i][j+1] :
            c[i][j], c[i][j+1] = c[i][j+1], c[i][j]
            result = max(result, check())
            c[i][j], c[i][j+1] = c[i][j+1], c[i][j]
        # 세로 스왑
        if i+1 < n and c[i][j] != c[i+1][j] :
            c[i][j], c[i+1][j] = c[i+1][j], c[i][j]
            result = max(result, check())
            c[i][j], c[i+1][j] = c[i+1][j], c[i][j]

print(result)