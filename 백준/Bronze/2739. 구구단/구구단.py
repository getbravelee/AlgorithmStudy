import sys
input = sys.stdin.readline

num = int(input())
num = str(num)
for i in range(1, 10):

    print(num + ' * ' + str(i) + ' = ' + str(int(num) * i))