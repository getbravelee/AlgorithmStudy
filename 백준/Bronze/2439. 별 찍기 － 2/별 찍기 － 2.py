import sys
input = sys.stdin.readline

n = int(input())
star = [' '] * n
for i in reversed(range(n)):
    star[i] = '*'
    print(''.join(star))