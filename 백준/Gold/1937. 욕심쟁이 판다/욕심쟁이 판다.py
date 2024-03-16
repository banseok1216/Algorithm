from collections import deque
N = int(input())

board = [list(map(int,input().strip().split(" "))) for _ in range(N)]
check = [[1 for _ in range(N)] for _ in range(N)]
def dfs(x,y):
    if check[x][y] != 1:
        return check[x][y]
    count = 0
    for direct in (1,0),(-1,0),(0,1),(0,-1):
        nx = x + direct[0]
        ny = y + direct[1]
        if nx>=0 and nx<N and ny >= 0 and ny<N:
            if board[x][y] < board[nx][ny]:
                count = max(count,dfs(nx,ny))
    check[x][y] += count
    return check[x][y]
ans = 0
for i in range(N):
    for j in range(N):
        ans = max(ans,dfs(i,j))
print(ans)