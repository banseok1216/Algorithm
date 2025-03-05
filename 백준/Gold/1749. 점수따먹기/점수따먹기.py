N, M = map(int, input().split(" "))
board = [[0] * (M + 1)]
for _ in range(N):
    board.append([0] + list(map(int, input().split(" "))))
for i in range(1, N + 1):
    for j in range(1, M + 1):
        board[i][j] += board[i - 1][j]
        board[i][j] += board[i][j - 1]
        board[i][j] -= board[i-1][j-1]
answer = -100000000000000
for i in range(1, N + 1):
    for j in range(1, M + 1):
        for x in range(i, N + 1):
            for y in range(j, M + 1):
                answer = max(board[x][y] - board[x][j-1] - board[i-1][y] + board[i-1][j-1], answer)
print(answer)
