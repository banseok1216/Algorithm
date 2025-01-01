T = int(input())


def sim(level, count):
    global board, pos
    for num, i, j in pos:
        if board[i][j] != "o":
            continue
        for ix, iy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx = i + ix + ix
            ny = j + iy + iy
            if 0 <= nx < 5 and 0 <= ny < 9 and board[nx - ix][ny - iy] == "o" and board[nx][ny] == ".":
                board[nx][ny] = "o"
                board[nx - ix][ny - iy] = "."
                board[i][j] = "."
                pos[num] = [num, nx, ny]
                sim(level + 1, count - 1)
                board[nx][ny] = "."
                board[nx - ix][ny - iy] = "o"
                board[i][j] = "o"
                pos[num] = [num, i, j]
    if pin[0] > count:
        pin[0] = count
        pin[1] = level


for k in range(T):
    board = []
    pos = []
    pin = [100000000, 0]
    start = 0
    for i in range(5):
        temp = list(input())
        for j in range(9):
            if temp[j] == "o":
                pos.append([start, i, j])
                start += 1
        board.append(temp)
    sim(0, len(pos))
    if pin[0] == 100000000:
        pin[0] = 0
    print(str(pin[0]) + " " + str(pin[1]))
    if k != T-1:
        input()