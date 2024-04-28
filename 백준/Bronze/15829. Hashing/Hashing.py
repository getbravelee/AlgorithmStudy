import sys
input = sys.stdin.readline
"""
예제 1: abcde의 해시 값은 1 × 31^0 + 2 × 31^1 + 3 × 31^2 + 4 × 31^3 + 5 × 31^4 = 1 + 62 + 2883 + 119164 + 4617605 = 4739715이다.
"""
def hashing(word):
    ans = 0
    for i in range(len(word)):
        ans += (ord(word[i])-96) * (31 ** i)
    return ans

n = int(input())
word = input().rstrip()

print(hashing(word) % 1234567891)



