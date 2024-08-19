N = int(input())
board = list(map(int, input().split(" ")))
graph = [[] for i in range(N)]
dp = [10000000 for i in range(N)]
start = 0
for i in range(N):
    if board[i] == -1:
        start = i
    else:
        graph[board[i]].append(i)


def dfs(cur):
    dp[cur] = 0
    check = []
    for nxt in graph[cur]:
        dfs(nxt)
        check.append(dp[nxt])
    check.sort(reverse=True)
    for i in range(len(check)):
        dp[cur] = max(dp[cur], check[i] + i + 1)


dfs(start)
print(dp[start])
