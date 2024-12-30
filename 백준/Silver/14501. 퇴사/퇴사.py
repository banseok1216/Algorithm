N = int(input())
board = []
dp = [0 for i in range(N+1)]
for i in range(N):
    a, b = map(int, input().split(" "))
    board.append((a, b))
i = 0
for t, p in board:
    target = i + t
    if target > N:
        i += 1
        continue
    dp[target] = max(dp[target], max(dp[:i+1]) + p)
    i += 1
print(max(dp))
