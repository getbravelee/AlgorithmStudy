import sys
input = sys.stdin.readline

"""
팩토리얼 함수를 재귀로 구현
입력 받은 수의 팩토리얼을 구한다
문자열로 바꾼다
뒤에서부터 처음 0이 아닌 수가 나올때까지 카운트
"""

n = int(input())

def factorial(n):
    if n > 1:
        return n * factorial(n-1)
    else:
        return 1

fac_num = factorial(n)
str_fac = str(fac_num)
cnt = 0
for i in reversed(str_fac):
    if i == '0':
        cnt += 1
    else:
        print(cnt)
        break