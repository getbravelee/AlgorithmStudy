import sys
input = sys.stdin.readline
"""

"""


while True:
    num_list = list(map(int, input().split()))
    num_list.sort()

    if sum(num_list) == 0:
        break

    if num_list[2]**2 == num_list[0]**2 + num_list[1]**2:
        print("right")
    else:
        print("wrong")
