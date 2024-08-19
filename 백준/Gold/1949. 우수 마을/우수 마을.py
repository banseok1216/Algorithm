from sys import setrecursionlimit

setrecursionlimit(10**6)
N = int(input())
board = list(map(int, input().split(" ")))
dp = [[0, 0] for i in range(N + 1)]
tree = [[] for j in range(N + 1)]
visited = [False for k in range(N + 1)]
for index in range(N):
    dp[index+1][0] = board[index]
for i in range(N - 1):
    a, b = map(int, input().split(" "))
    tree[a].append(b)
    tree[b].append(a)


def dfs(cur_index):
    global tree, visited, dp
    visited[cur_index] = True
    for nxt in tree[cur_index]:
        if visited[nxt]:
            continue
        dfs(nxt)
        dp[cur_index][0] += dp[nxt][1]
        dp[cur_index][1] += max(dp[nxt][1], dp[nxt][0])

dfs(1)
print(max(dp[1]))
