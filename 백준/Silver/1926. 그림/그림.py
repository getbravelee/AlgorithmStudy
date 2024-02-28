import sys
from collections import deque

input = sys.stdin.readline

n,m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    q = deque()
    graph[x][y] = 0
    q.append((x, y))
    area = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                q.append((nx,ny))
                area += 1
    return area

cnt = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            cnt.append(bfs(i, j))

print(len(cnt))
if len(cnt) != 0:
    print(max(cnt))
else:
    print(0)

