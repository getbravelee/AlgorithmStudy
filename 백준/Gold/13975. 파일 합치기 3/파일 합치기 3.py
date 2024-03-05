import sys
import heapq
input = sys.stdin.readline

t = int(input())
temp = list()
for _ in range(t):
    n = int(input())
    ch = list(map(int, input().split()))
    ans = 0
    q = []
    # minq
    for i in ch:
        heapq.heappush(q, i)
    while len(q) > 1:
        a = heapq.heappop(q)
        b = heapq.heappop(q)
        ans += a + b
        heapq.heappush(q, a + b)
    print(ans)