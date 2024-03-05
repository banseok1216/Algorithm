import sys

input = sys.stdin.readline
mod = 1000000000

if __name__ == '__main__':
    N, K = map(int, input().split())
    dp = [[1 for _ in range(N + 1)] for _ in range(K + 1)]
    dp[0][0] = 1
    for i in range(1, K + 1):
        for j in range(1, N + 1):
            for k in range(j):
                dp[i][j] += dp[i - 1][j - k]
                dp[i][j] %= mod
    print(dp[K-1][N])
