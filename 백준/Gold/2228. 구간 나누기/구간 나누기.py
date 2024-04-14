N, M = map(int, input().split(" "))
dp = [[0 for i in range(M + 1)] for j in range(N + 1)]
lst = [int(input()) for i in range(N)]
sum = [0]
for i in lst:
    if len(sum) == 0:
        sum.append(i)
    else:
        sum.append(sum[len(sum) - 1] + i)
for i in range(1,M + 1):
    dp[0][i] = -3276800

for i in range(1, N + 1):
    for j in range(1, M + 1):
        dp[i][j] = dp[i - 1][j]
        for k in range(1,i+1):
            if k >= 2:
                dp[i][j] = max(dp[i][j], dp[k - 2][j - 1] + sum[i] - sum[k - 1])
            elif k == 1 and j == 1:
                dp[i][j] = max(dp[i][j], sum[i])
print(dp[N][M])
