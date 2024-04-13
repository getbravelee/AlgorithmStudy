import sys
input = sys.stdin.readline
"""
첫 풀이 : O(n+m + n*m) -> 1억이 넘는다.

n = int(input())
card_list = list((map(int, input().split()))) // n
m = int(input())
num_list = list((map(int, input().split()))) // m
for i in num_list: // n*m
    cnt = card_list.count(i)
    print(cnt, end= " ")
    
-> 이분탐색으로 해결
"""
n = int(input())
card_list = sorted(map(int, input().split()))
m = int(input())
num_list = map(int, input().split())

count = {}
for card in card_list:
    if card in count:
        count[card] += 1
    else:
        count[card] = 1

def binarySearch(arr, target, start, end):
    if start > end:
        return 0

    mid = (start + end) // 2

    if arr[mid] == target:
        return count.get(target)
    elif arr[mid] > target:
        return binarySearch(arr, target, start, mid-1)
    else:
        return binarySearch(arr, target, mid+1, end)

for card in num_list:
    print(binarySearch(card_list, card, 0, len(card_list)-1), end = " ")



