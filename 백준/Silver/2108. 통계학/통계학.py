import sys
input = sys.stdin.readline

"""
산술평균 : arithmetic mean
중앙값 : median
최빈값: mode
범위 : scope
"""
def arithmeticMean(lst):
    v = round(sum(lst) / len(lst))
    print(v)

def median(lst):
    lst.sort()
    v = len(lst)//2
    print(lst[v])

def mode(lst):
    lst.sort()
    cnt_dict = {}

    for i in lst:
        if i in cnt_dict:
            cnt_dict[i] += 1
        else:
            cnt_dict[i] = 1

    mode_num = max(cnt_dict.values())
    mode_nums = [key for key, value in cnt_dict.items() if value == mode_num]
    if len(mode_nums) > 1:
        mode_nums.sort()
        print(mode_nums[1])
    else:
        print(mode_nums[0])

def scope(lst):
    max_num = max(lst)
    min_num = min(lst)
    print(max_num - min_num)

n = int(input())
nums = []
for _ in range(n):
    nums.append(int(input()))

arithmeticMean(nums)
median(nums)
mode(nums)
scope(nums)