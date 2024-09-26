import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().split())
map = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

house = []
chicken = []

result = 999999

for i in range(n) :
  for j in range(n) :
    if map[i][j] == 1 :
      house.append([i,j])
    if map[i][j] == 2 :
      chicken.append([i,j])

# m개의 치킨집 선택
for chi in combinations(chicken, m) :
  # 도시 치킨 거리
  temp = 0
  for h in house :
    # 각 집 치킨거리
    chicken_len = 999999
    for i in range(m) :
      chicken_len = min(chicken_len, abs(h[0]-chi[i][0]) + abs(h[1]-chi[i][1]))
    temp += chicken_len
  result = min(result, temp)

print(result)

'''
      for i in combinations(chicken, m) :
        print(i)
      ([1, 2], [2, 2], [4, 4])

      for j in house :
        print(j)
      [0, 2]
      [1, 4]
      [2, 1]
      [3, 2]
'''