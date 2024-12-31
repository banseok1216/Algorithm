H, W = map(int, input().split(" "))
board = [[False for _ in range(H)] for _ in range(W)]
i_board = list(map(int, input().split(" ")))

for i in range(W):
    count = i_board[i]
    for j in range(count):
        board[i][j] = True
count = 0
for i in range(W):
    ix, iy = -1, 0
    for j in range(H):
        if not board[i][j]:
            continue
        nx, ny = i, j
        temp = 0
        while 0 <= ix + nx:
            board[nx][ny] = True
            if not board[ix + nx][iy + ny]:
                temp += 1
            else:
                break
            nx, ny = ix + nx, iy + ny
        if ix + nx == -1:
            temp = 0
        count += temp
print(count)