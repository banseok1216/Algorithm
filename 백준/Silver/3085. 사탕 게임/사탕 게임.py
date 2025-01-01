# 봄보니
# N*N 게임 2칸 고르고 교환 모두 같은색 으로어진 칸 먹기 행 또는 열


N = int(input())
board = []
for _ in range(N):
    board.append(list(input()))


def sim():
    global board
    sum = 0
    for i in range(N):
        count = 0
        s = 0
        t = 0
        while s != N:
            if board[s][i] == board[t][i]:
                count += 1
            else:
                sum = max(sum, count)
                count = 1
                t = s
            s += 1
        sum = max(sum, count)
        count = 0
        s = 0
        t = 0
        while s != N:
            if board[i][s] == board[i][t]:
                count += 1
            else:
                sum = max(sum, count)
                count = 1
                t = s
            s += 1
        sum = max(sum, count)
    return sum

answer = 0
for i in range(N):
    for j in range(N):
        for ix, iy in (1, 0), (0, 1):
            nx, ny = ix + i, iy + j
            if 0 <= nx < N and 0 < ny < N:
                temp = board[i][j]
                board[i][j] = board[ix + i][iy + j]
                board[nx][ny] = temp
                answer = max(answer,sim())
                temp = board[nx][ny]
                board[nx][ny] = board[i][j]
                board[i][j] = temp
print(answer)