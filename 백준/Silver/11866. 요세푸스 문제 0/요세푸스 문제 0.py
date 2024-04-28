import sys
input = sys.stdin.readline
"""
양방향 연결 리스트 사용
join
"""
from collections import deque
n, k = map(int, input().split())

dq = deque([i for i in range(1, n+1)])
result = []

while len(dq) != 0:
    for i in range(k-1):
        dq.append(dq.popleft())
    result.append(str(dq.popleft()))
print('<' + ', '.join(result) + '>')



