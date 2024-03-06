import sys
input = sys.stdin.readline

word = input()

alpha = [chr(ord('a')+i) for i in range(26)]
result = []
for j in range(26):
    if alpha[j] in word:
        result.append(str(word.index(alpha[j])))
    else:
        result.append('-1')
print(' '.join(result))