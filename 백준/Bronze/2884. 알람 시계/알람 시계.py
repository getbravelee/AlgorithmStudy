import sys
input = sys.stdin.readline

h, m = map(int, input().split())

if h == 0 and m-45 < 0:
    h = 24

time = h*60 + m - 45

h = time // 60
m = time % 60

print(h, m)