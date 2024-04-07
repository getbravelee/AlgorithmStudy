import sys
input = sys.stdin.readline
"""

"""

from itertools import combinations

n, m = map(int, input().split())

card_list = list(map(int, input().split()))

max_num = 0

for cards in combinations(card_list, 3):
    if max_num < sum(cards) <= m:
        max_num = sum(cards)
print(max_num)