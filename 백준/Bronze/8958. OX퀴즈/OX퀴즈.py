import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    score = 0
    ans = input()
    cnt = 1
    for i in range(len(ans)):
        if ans[i] == 'O':
            if ans[i-1] == 'O':
                cnt += 1
                score += cnt
            else:
                cnt = 1
                score += cnt
    print(score)