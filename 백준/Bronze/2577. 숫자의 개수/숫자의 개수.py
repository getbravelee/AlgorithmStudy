import sys
input = sys.stdin.readline

n = 1
for _ in range(3):
    num = int(input())
    n *= num

result = list(str(n))

for i in range(10):
    print(result.count(str(i)))
