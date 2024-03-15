import copy
from collections import deque
from itertools import combinations

N = int(input())
board = [[False for _ in range(101)] for _ in range(101)]
request = [list(map(int, input().strip().split(" "))) for _ in range(N)]
direction = [(1, 0), (0, -1), (-1, 0), (0, 1)]
for list1 in request:
    list2 = []
    list2.append((list1[0], list1[1]))
    board[list1[0]][list1[1]] = True
    for i in range(list1[3] + 1):
        start = list2[-1]
        if i == 0:
            list2.append((list1[0] + direction[list1[2]][0], list1[1] + direction[list1[2]][1]))
            board[list1[0] + direction[list1[2]][0]][list1[1] + direction[list1[2]][1]] = True
        else:
            list3 = []
            dx, dy = start[0], start[1]
            for j in range(len(list2) - 2, -1, -1):
                mpx, mpy = list2[j][0], list2[j][1]
                tx, ty = (-1) * (mpy - dy), 1 * (mpx - dx)
                nx, ny = tx + dx, ty + dy
                if (0 <= nx < 101 and 0 <= ny < 101):
                    board[nx][ny] = True
                    list3.append((nx, ny))
            list2.extend(list3)
result = 0
for i in range(100):
    for j in range(100):
        if board[i][j] == True:
            check = True
            for node in (0,1),(1,0),(1,1):
                nx = i + node[0]
                ny = j + node[1]
                if(0<=nx < 101 and 0<= ny <101):
                    if  not board[nx][ny]:
                        check = False
            if check:
                result+=1
print(result)