import sys
input = sys.stdin.readline
"""
n = int(input())
nums = []
for i in range(n):
    nums.append(int(input()))

nums.sort()

for i in range(len(nums)):
    print(nums[i])

메모리 초과 
-> sort 때문
-> 가변배열에서 동적으로 메모리가 할당돼서 그런것 같다
"""
n = int(input())
# 입력값 10000까지
nums = [0] * (10000+1)
for _ in range(n):
    nums[int(input())] += 1

# 1부터 10000까지 0이 아닌 수를 찾는다. 인덱스 0은 무조건 0
for i in range(len(nums)):
    if nums[i] != 0:
        # 작은 수부터 순차적으로 그 수의 갯수만큼 출력
        for _ in range(nums[i]):
            print(i)

