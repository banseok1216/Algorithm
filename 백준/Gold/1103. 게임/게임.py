
N, M = map(int, input().split(" "))
board = [[0 for j in range(M)] for i in range(N)]
for i in range(N):
    _board = list(input())
    for j in range(M):
        if _board[j] == "H":
            board[i][j] = -1
        else:
            board[i][j] = int(_board[j])

dp = [[0 for j in range(M)] for i in range(N)]
visited = [[False for j in range(M)] for i in range(N)]
maxdist = 0

def dfs(cur_x, cur_y, count):
    global visited
    global maxdist
    maxdist = max(maxdist, count)
    visited[cur_x][cur_y] = True
    for x, y in (-1, 0), (1, 0), (0, -1), (0, 1):
        nx = cur_x + x * board[cur_x][cur_y]
        ny = cur_y + y * board[cur_x][cur_y]
        if 0 <= nx <= N - 1 and 0 <= ny <= M - 1 and board[nx][ny] != -1:
            if visited[nx][ny]:
                print(-1)
                exit()
            if count + 1 > dp[nx][ny]:
                dp[nx][ny] = count + 1
                dfs(nx, ny, count + 1)
    visited[cur_x][cur_y] = False


dfs(0, 0, 1)

print(maxdist)
