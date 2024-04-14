import sys
input = sys.stdin.readline
"""
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
"""

# return으로 하면 안된다. 반환할 값이 없다.
def stackPush(stack, x):
    stack.append(x)

def stackPop(stack):
    if stack:
        return stack.pop()
    else:
        return -1

def stackSize(stack):
    return len(stack)

def stackEmpty(stack):
    if stack:
        return 0
    else:
        return 1

def stackTop(stack):
    if stack:
        return stack[-1]
    else:
        return -1

n = int(input())
stack = []

for i in range(n):
    cmd = input().split()

    if cmd[0] == "push":
        stackPush(stack, cmd[1])
    elif cmd[0] == "pop":
        print(stackPop(stack))
    elif cmd[0] == "size":
        print(stackSize(stack))
    elif cmd[0] == "empty":
        print(stackEmpty(stack))
    elif cmd[0] == "top":
        print(stackTop(stack))
