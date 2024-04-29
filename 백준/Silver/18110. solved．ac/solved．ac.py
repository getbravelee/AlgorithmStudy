import sys
input = sys.stdin.readline
"""
round는 사사오입 원칙을 따른다. -> 직접 반올림 함수 구현
n이 0이 될 수 있으므로 zerodivisionerror를 조심하자
"""
from collections import deque

def rnd(tm):
    if tm - int(tm) >= 0.5:
        return int(tm)+1
    else:
        return int(tm)

def trimmedMean(n):
    tm = n * 0.15
    return rnd(tm)

n = int(input())
lv_list = []
for i in range(n):
    lv_list.append(int(input()))

dq = deque(sorted(lv_list))

if n != 0:
    for i in range(trimmedMean(n)):
        dq.pop()
        dq.popleft()

    avg = rnd(sum(dq) / len(dq))
    print(avg)
else:
    print(0)
