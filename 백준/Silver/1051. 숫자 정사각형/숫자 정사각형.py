N , M = map(int,input().split(" "))
board = [list(map(int, input())) for _ in range(N)]
ans =0
def dfs(x,y):
    global ans
    for i in range(x,N):
        if board[x][y] == board[i][y]:
            if y+(i-x) < M:
                if board[i][y] == board[x][y+(i-x)] == board[x][y] == board[i][y+(i-x)]:
                    ans = max(ans,(i-x+1)**2)
for i in range(N):
    for j in range(M):
        dfs(i,j)

print(ans)

