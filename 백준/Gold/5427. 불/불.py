from collections import deque
from copy import deepcopy

T = int(input())
for _ in range(T):
    w, h = map(int, input().split(" "))
    sX, sY = 0, 0
    board = []
    fire = []
    for i in range(h):
        temp = list(input())
        for j in range(w):
            if temp[j] == "@":
                sX, sY = i, j
            if temp[j] == "*":
                fire.append((i, j))
        board.append(temp)
    pos = []
    pos.append((sX, sY))
    answer = "IMPOSSIBLE"
    count = 1
    while len(fire) != 0 or len(pos) != 0:
        if answer != "IMPOSSIBLE":
            break
        temp = []
        for x, y in fire:
            for ix, iy in (-1, 0), (0, 1), (1, 0), (0, -1):
                nx, ny = ix + x, iy + y
                if 0 <= nx < h and 0 <= ny < w and not board[nx][ny] == "#" and not board[nx][ny] == "*":
                    temp.append((nx, ny))
                    board[nx][ny] = "*"
        fire = temp
        temp = []
        for x, y in pos:
            for ix, iy in (-1, 0), (0, 1), (1, 0), (0, -1):
                nx, ny = ix + x, iy + y
                if 0 <= nx < h and 0 <= ny < w:
                    if not board[nx][ny] == "#" and not board[nx][ny] == "*" and not board[nx][ny] == "@":
                        temp.append((nx, ny))
                        board[nx][ny] = "@"
                else:
                    answer = count
        pos = temp
        count += 1
    print(answer)
