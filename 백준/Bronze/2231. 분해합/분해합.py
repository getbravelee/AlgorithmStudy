import sys
input = sys.stdin.readline

"""
"""
n = int(input())

for i in range(1, n+1):
    sum_element = sum(map(int, str(i)))
    sum_num = i + sum_element

    if sum_num == n:
        print(i)
        break
    # n과 같다는 것은 생성자가 없다는 뜻
    if i == n:
        print(0)

