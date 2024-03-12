import sys
input = sys.stdin.readline

"""
소수 : 1과 자기 자신만으로 나누어지는 수
"""
n = int(input())
nums = list(map(int, input().split()))
result = 0
for i in nums:
    cnt = 0
    if i > 1:
        for j in range(2, i):
            if i % j == 0:
                cnt += 1
        if cnt == 0:
            result += 1
print(result)