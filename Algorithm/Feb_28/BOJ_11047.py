import sys

input = sys.stdin.readline
coin = []
cnt = 0
n,m = map(int, input().split())

for i in range(n) :
    coin.append(int(input()))

for i in reversed(range(n)):
    cnt += m // coin[i]
    m = m % coin[i]
print(cnt)
