T = int(input())
for _ in range(T):
    board = []
    n = int(input())
    for i in range(2):
        board.append(list(map(int, input().split(" "))))
    dp = [[0, 0] for _ in range(n)]
    for i in range(n):
        for j in range(2):
            if i == 0:
                continue
            if i == 1:
                if j == 0:
                    board[j][i] = max(board[j][i] + board[j+1][i - 1], board[j][i - 1])
                else:
                    board[j][i] = max(board[j][i] + board[j-1][i - 1], board[j][i - 1])
            else:
                if j == 0:
                    board[j][i] = max(board[j][i] + board[j][i-2], board[j + 1][i - 1] + board[j][i], board[j][i-1] )
                else:
                    board[j][i] = max(board[j][i] + board[j][i - 2], board[j - 1][i - 1] + board[j][i], board[j][i - 1])

    print(max(board[0][n-1], board[1][n-1]))