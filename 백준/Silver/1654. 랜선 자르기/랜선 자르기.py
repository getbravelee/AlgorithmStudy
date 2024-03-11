n, k = map(int, input().split())

lan = []
max_len = 0

for _ in range(n):
    length = int(input())
    lan.append(length)
    max_len = max(max_len, length)

left, right = 1, max_len

while left <= right:
    mid = (left + right) // 2
    cnt = sum([l // mid for l in lan])

    if cnt >= k:
        left = mid + 1
    else:
        right = mid - 1

print(right)
