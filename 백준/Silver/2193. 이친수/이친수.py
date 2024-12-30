# 0과 1로만 이루진수를 이진수롸고 하낟.
# 이친수는 0으로 시작하지 않는다
# 1 -> 1
# 2 -> 1
# 3 -> 2
# 4 -> 1000 ,1001 1010
N = int(input())
dp = [[0, 0] for _ in range(N)]
dp[0][1] = 1
for i in range(1,N):
    dp[i][0] = dp[i - 1][1] + dp[i - 1][0]
    dp[i][1] = dp[i - 1][0]
print(sum(dp[N-1]))