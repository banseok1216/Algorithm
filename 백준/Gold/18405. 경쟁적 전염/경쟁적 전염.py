# NXN 크기 시험관 1번 부터 K 번까지 바이러스 종류
# S초 지난후 X,Y 에 존재하는 바이러스 종류 출력
# 시험관 가장 왼쩍은 (1,1)
# 낮은 종류 먼저
from collections import deque

N, K = map(int, input().split(" "))
board = []
for i in range(N):
    board.append(list(map(int, input().split(" "))))
S, X, Y = map(int, input().split(" "))
check = []
for i in range(N):
    for j in range(N):
        if board[i][j] != 0:
            check.append((board[i][j], i, j))
check2 = []


def explode(x, y, num):
    global board
    for ix, iy in (-1, 0), (1, 0), (0, -1), (0, 1):
        nx, ny = ix + x, iy + y
        if 0 <= nx < N and 0 <= ny < N:
            if board[nx][ny] == 0:
                board[nx][ny] = num
                check2.append((num, nx, ny))


for _ in range(S):
    check.sort()
    for num, x, y in check:
        explode(x, y, num)
    check = check2
    check2 = []

print(board[X - 1][Y - 1])
