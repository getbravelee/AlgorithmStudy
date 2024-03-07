import sys
input = sys.stdin.readline

t = int(input())

n = input().strip()
result = 0
for i in range(t):
    result += int(n[i])
print(result)

