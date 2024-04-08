from collections import deque
from sys import stdin
input = stdin.readline
N, M = map(int, input().split(" "))
board = [list(map(int, input().split())) for _ in range(N)]

check = [[[False for k in range(4)] for i in range(M)] for j in range(N)]

startX, startY, startD = map(int, input().split(" "))
endX, endY, endD = map(int, input().split(" "))
que = deque()
lst = [(0, 1), (0, -1), (1, 0), (-1, 0)]
que.append((startX - 1, startY - 1, startD - 1, 0))
answer = 100000000
while len(que) != 0:
    node = que.popleft()
    if check[node[0]][node[1]][node[2]]:
        continue
    if node[0] == endX - 1 and node[1] == endY - 1 and node[2] == endD - 1:
        answer = node[3]
        break
    check[node[0]][node[1]][node[2]] = True
    for i in range(1,4):
        nx = node[0] + lst[node[2]][0]*i
        ny = node[1] + lst[node[2]][1]*i
        if N > nx >= 0 and M > ny >= 0 and board[nx][ny] == 0:
            que.append((nx, ny, node[2], node[3] + 1))
        else:
            break
    if node[2] == 0 or node[2] == 1:
        for i in 2, 3:
            nx = node[0]
            ny = node[1]
            if N > nx >= 0 and M > ny >= 0:
                que.append((nx, ny, i, node[3] + 1))
    if node[2] == 2 or node[2] == 3:
        for i in 1, 0:
            nx = node[0]
            ny = node[1]
            if N > nx >= 0 and M > ny >= 0:
                que.append((nx, ny, i, node[3] + 1))
print(answer)
