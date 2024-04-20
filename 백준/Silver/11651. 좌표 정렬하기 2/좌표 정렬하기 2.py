import sys
input = sys.stdin.readline
"""
2차원 배열 괄호, 컴마 없이 출력
"""

n = int(input())
graph = []
for _ in range(n):
    x, y = map(int, input().split())
    graph.append([y, x])
graph.sort()

for i in range(n):
    graph[i][0], graph[i][1] = graph[i][1], graph[i][0]

for i,j in graph:
    print(i,j)
