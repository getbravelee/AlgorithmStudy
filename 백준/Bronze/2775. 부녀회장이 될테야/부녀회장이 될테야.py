import sys
input = sys.stdin.readline
"""

"""

tc = int(input())
for _ in range(tc):

    k = int(input()) # 층
    n = int(input()) # 호수

    apt = [[] for _ in range(k+1)]

    # 0층 주민 수
    for i in range(1, n+1):
        apt[0].append(i)

    # 1층부터 k층까지
    for i in range(1, k+1):
        # 1호부터 n호까지
        for j in range(n):
            # 1호는 무조건 1명
            if j == 0:
                apt[i].append(1)
                continue
            apt[i].append(apt[i][j-1] + apt[i-1][j])

    print(apt[k][n-1])
