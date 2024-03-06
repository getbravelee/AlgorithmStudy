import sys
input = sys.stdin.readline

num = list(map(int, input().split()))
start = 1
end = 8
cnt = 0
for i in range(start, end):
    if num[i] - num[i-1] == 1:
        cnt += 1
    if num[i] - num[i-1] == -1:
        cnt -= 1
if cnt == 7 :
    print('ascending')
elif cnt == -7 :
    print('descending')
else:
    print('mixed')