import sys
input = sys.stdin.readline
"""
2차원 배열 괄호, 컴마 없이 출력
"""

n = int(input())
graph = []
for _ in range(n):
    x, y = map(int, input().split())
    graph.append([x, y])
graph.sort()

for i,j in graph:
    print(i,j)
