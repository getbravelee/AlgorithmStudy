import sys

input = sys.stdin.readline

n = int(input())
dead = 666
cnt = 0

while True :
    if '666' in str(dead) :
        cnt += 1
    if cnt == n :
        break;
    dead += 1

print(dead)