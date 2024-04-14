import sys
input = sys.stdin.readline
"""
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
"""
from collections import deque

def qPush(q, x):
    q.append(x)

def qPop(q):
    if q:
        return q.popleft()
    else:
        return -1

def qSize(q):
    return len(q)

def qEmpty(q):
    if q:
        return 0
    else:
        return 1

def qFront(q):
    if q:
        return q[0]
    else:
        return -1

def qBack(q):
    if q:
        return q[-1]
    else:
        return -1

n = int(input())
q = deque()

for i in range(n):
    cmd = input().split()

    if cmd[0] == "push":
        qPush(q, cmd[1])
    elif cmd[0] == "pop":
        print(qPop(q))
    elif cmd[0] == "size":
        print(qSize(q))
    elif cmd[0] == "empty":
        print(qEmpty(q))
    elif cmd[0] == "front":
        print(qFront(q))
    elif cmd[0] == "back":
        print(qBack(q))
