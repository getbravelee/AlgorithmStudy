n = int(input())
l = list(map(int, input().split()))
l.sort()
m = list()
for i in range(n):
    if n % 2 != 0 and i < n//2 :
        m.append(l[i] + l[n-2-i])
        if i == n//2 -1:
            m.append(l[-1])
    elif n % 2 == 0 and i < n//2:
        m.append(l[i] + l[n-1-i])
    else:
        break
print(max(m))