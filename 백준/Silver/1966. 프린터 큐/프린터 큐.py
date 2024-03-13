import sys
input = sys.stdin.readline

"""
인덱스 m에 해당하는 수가 몇번째에 출력될 것인가?
동일한 우선순위가 있을 수 있기 때문에 enumerate를 통해 m에 해당하는 수를 찾자
"""
tc = int(input())
for _ in range(tc):
    n, m = map(int, input().split())
    priority = list(enumerate(list(map(int, input().split()))))
    val = priority[m]
    cnt = 0
    while priority:
        max_val = max(i[1] for i in priority)
        if priority[0][1] == max_val:
            now = priority.pop(0)
            cnt += 1
            if now == val:
                print(cnt)
                break
        else:
            now = priority.pop(0)
            priority.append(now)