N = int(input())
board = list(map(int, input().split(" ")))
K = int(input())
dp = [[0 for _ in range(N)] for _ in range(3)]
for i in range(N-1):
    board[i + 1] += board[i]
for i in range(3):
    for j in range(N):
        if j - K < 0:
            if i == 0:
                dp[i][j] = board[j]
                continue
        if i == 0:
            dp[i][j] = max(board[j] - board[j - K], dp[i][j - 1])
        else:
            dp[i][j] = max(dp[i][j - 1],
                           board[j] - board[j - K] + dp[i - 1][j - K])

print(dp[2][N-1])