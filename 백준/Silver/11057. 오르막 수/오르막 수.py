N = int(input())

dp = [[0 for _ in range(N)] for _ in range(10)]
for i in range(10):
    dp[i][0] = 1
for i in range(N):
    for j in range(10):
        if i == 0:
            if j == 0:
                continue
            dp[j][i] += dp[j-1][i]
        else:
            dp[j][i] += dp[j][i-1]
            if j == 0:
                continue
            dp[j][i] += dp[j-1][i]
        dp[j][i] %= 10007
print(dp[9][N-1])
