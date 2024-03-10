import sys
input = sys.stdin.readline

n = int(input())
word = []
for i in range(n):
    word.append(input().strip())

word_set = set(word)
word_set = list(word_set)

word_set.sort()
word_set.sort(key = len)

for i in word_set:
    print(i)