import sys
input = sys.stdin.readline

n = int(input())
star = ''
for _ in range(n):
    star += '*'
    print(star)