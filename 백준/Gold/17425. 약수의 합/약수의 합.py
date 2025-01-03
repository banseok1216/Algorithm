import sys
from sys import stdin
input = stdin.readline
n = 1000000
board = [1] * (n + 1)

for i in range(2, n + 1):
    for j in range(i, n + 1, i):
        board[j] += i

for i in range(1, n):
    board[i+1] += board[i]
T = int(input())
ans = []
for _ in range(T):
    ans.append(board[int(input())])
print('\n'.join(map(str, ans))+"\n")
