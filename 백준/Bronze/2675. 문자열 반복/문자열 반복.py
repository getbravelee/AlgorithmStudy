import sys
input = sys.stdin.readline

tc = int(input())
for _ in range(tc):
    r, s = input().split()
    word = ''
    r = int(r)
    for i in range(len(s)):
        for _ in range(r):
            word += s[i]
    print(word)