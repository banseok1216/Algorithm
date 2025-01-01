board = []
for i in range(19):
    board.append(list(map(int, input().split(" "))))

flag = 0
pos = [0, 0]


def find(x, y):
    global board
    global flag
    global pos
    sx = x
    sy = y
    for b in [(0, 1), (0, -1)], [(1, 0), (-1, 0)], [(1, 1), (-1, -1)], ([(-1, 1), (1, -1)]):
        count = 1
        x, y = sx, sy
        ix, iy = b[0]
        while 0 <= ix + x < 19 and 0 <= iy + y < 19 and board[ix + x][iy + y] == board[sx][sy]:
            nx, ny = ix + x, iy + y
            x = nx
            y = ny
            count += 1
        x, y = sx, sy
        ix, iy = b[1]
        while 0 <= ix + x < 19 and 0 <= iy + y < 19 and board[ix + x][iy + y] == board[sx][sy]:
            nx, ny = ix + x, iy + y
            x = nx
            y = ny
            count += 1
        if count == 5:
            pos = [x, y]
            flag = board[x][y]


for i in range(19):
    for j in range(19):
        if board[i][j] != 0:
            find(i, j)
if flag != 0:
    print(flag)
    print(str(pos[0] + 1) + " " + str(pos[1] + 1))
else:
    print(flag)
