import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
graph = []
max_h = 0
max_cnt = 1

for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        if graph[i][j] > max_h:
            max_h = graph[i][j]

def bfs(x, y, h, visited):
    q = deque()
    q.append((x, y))
    visited[x][y] = 1

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if graph[nx][ny] > h and visited[nx][ny] == 0:
                visited[nx][ny] = 1
                q.append((nx, ny))

for k in range(1, max_h+1):
    visited = [[0] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] > k and visited[i][j] == 0:
                bfs(i, j, k, visited)
                cnt += 1
    max_cnt = max(max_cnt, cnt)

print(max_cnt)