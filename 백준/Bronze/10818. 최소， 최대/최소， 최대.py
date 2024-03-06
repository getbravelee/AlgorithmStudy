import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
print(str(min(nums)) + ' ' + str(max(nums)))