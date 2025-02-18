board = [[0 for _ in range(10)] for _ in range(64)]
board[0] = [1 for _ in range(10)]
for i in range(1,64):
    for j in range(10):
        if j == 0:
            board[i][j] = board[i - 1][j]
        else:
            board[i][j] = board[i-1][j] + board[i][j-1]
N = int(input())

for _ in range(N):
    print(sum(board[int(input()) -1]))

