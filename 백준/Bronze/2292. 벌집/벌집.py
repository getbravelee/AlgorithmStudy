import sys
input = sys.stdin.readline
"""
큰 집에 순차적으로 작은 집들이 있다.
큰 집이란 큰 정육각형 모양의 작은 집들로 구성되어있는 것을 뜻한다.
예를 들어 20~37까지 작은 집들이 모여있는 집을 4번 큰집이라고 한다면
4번 큰 집에 속하는 작은 집까지의 거리는 어떤 집이든 4개의 방을 지나간다.

cnt는 반복을 진행하는 횟수로써, 몇 번째 큰집을 지나간다는 뜻이다.
"""
n = int(input())

house = 1 # 벌집 번호
cnt = 1

while n > house:
    house += 6 * cnt # 벌집 6배수로 증가
    cnt += 1
print(cnt)