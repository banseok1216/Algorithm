import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split(" "))
board = [list(map(int, input().split(" "))) for _ in range(N)]
ans = 0
for i in range(N):
    start = board[i][0]
    count = 1
    correct = True
    for j in range(1, N):
        if board[i][j] == start:
            count += 1
        elif board[i][j] == start + 1:
            if count >= M:
                count = 1
                start = board[i][j]
            else:
                correct = False
                break
        elif board[i][j] == start - 1:
            if count >= 0:
                count = -M+1
                start = board[i][j]
            else:
                correct = False
                break
        else:
            correct = False
            break
    if count<0:
        continue
    if correct:
        ans+=1
for i in range(N):
    start = board[0][i]
    count = 1
    correct = True
    for j in range(1, N):
        if board[j][i] == start:
            count += 1
        elif board[j][i] == start + 1:
            if count >= M:
                count = 1
                start = board[j][i]
            else:
                correct = False
                break
        elif board[j][i] == start - 1:
            if count >= 0:
                count = -M+1
                start = board[j][i]
            else:
                correct = False
                break
        else:
            correct = False
            break
    if count<0:
        continue
    if correct:
        ans+=1
print(ans)
