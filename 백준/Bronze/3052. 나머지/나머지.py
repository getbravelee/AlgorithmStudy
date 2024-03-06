import sys
input = sys.stdin.readline

n = 42
num = list()
empty = set()
for _ in range(10):
    num.append(int(input()))
for i in num:
    empty.add(i % n)
print(len(empty))