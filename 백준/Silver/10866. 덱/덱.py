import sys
input = sys.stdin.readline
"""
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
"""
from collections import deque

def dqPushFront(dq, x):
    dq.appendleft(x)

def dqPushBack(dq, x):
    dq.append(x)

def dqPopFront(dq):
    if dq:
        return dq.popleft()
    else:
        return -1

def dqPopBack(dq):
    if dq:
        return dq.pop()
    else:
        return -1

def qSize(dq):
    return len(dq)

def qEmpty(dq):
    if dq:
        return 0
    else:
        return 1

def qFront(dq):
    if dq:
        return dq[0]
    else:
        return -1

def qBack(dq):
    if dq:
        return dq[-1]
    else:
        return -1

n = int(input())
dq = deque()

for i in range(n):
    cmd = input().split()

    if cmd[0] == "push_front":
        dqPushFront(dq, cmd[1])
    elif cmd[0] == "push_back":
        dqPushBack(dq, cmd[1])
    elif cmd[0] == "pop_front":
        print(dqPopFront(dq))
    elif cmd[0] == "pop_back":
        print(dqPopBack(dq))
    elif cmd[0] == "size":
        print(qSize(dq))
    elif cmd[0] == "empty":
        print(qEmpty(dq))
    elif cmd[0] == "front":
        print(qFront(dq))
    elif cmd[0] == "back":
        print(qBack(dq))
