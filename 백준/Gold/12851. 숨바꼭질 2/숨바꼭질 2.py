import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())
max_num = 100000
graph = [0] * (max_num + 1)
result = list()
def bfs(v):
    q = deque()
    q.append(v)

    while q:
        v = q.popleft()
        if v == k:
            result.append(graph[v])
            continue
        for nx in (v-1, v+1, 2*v):
            # 10만을 넘으면 안된다.
            if 0 <= nx < max_num+1 and (graph[nx] == 0 or graph[nx] == graph[v]+1):
                graph[nx] = graph[v] + 1
                q.append(nx)

bfs(n)

print(result[0])
print(len(result))
