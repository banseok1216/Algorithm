N = int(input())
K = int(input())

dp = [[0 for _ in range(K+1)]  for _ in range(N+1)]



for i in range(N+1):
    for j in range(K+1):
        if j == 1:
            dp[i][j] = i
            continue
        if i>=4:
            dp[i][j] = dp[i-2][j-1] + dp[i-1][j]
            dp[i][j] %= 1000000003
print(dp[N][K])
