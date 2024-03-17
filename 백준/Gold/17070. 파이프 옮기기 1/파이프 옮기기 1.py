from collections import deque
N = int(input())

board = [list(map(int,input().split(" "))) for _ in range(N)]
count = [[[0 for _ in range(4)] for _ in range(N)] for _ in range(N)]
count[0][0][1] = 1
def dfs(x,y,d):
    if (x<0 or y<0):
        return 0
    if board[x][y] == 1:
        return 0
    if not (x == N-1 and y==N-1) and d == 2 and (board[x+1][y] == 1 or board[x][y+1] == 1):
            return 0
    if x == 0 and y==0:
        return count[x][y][d]
    if count[x][y][d] != 0:
        return count[x][y][d]
    if d == 1:
        count[x][y][1] += dfs(x-1,y-1,2)
        count[x][y][1] += dfs(x, y - 1, 1)
        return count[x][y][1]
    if d==2:
        count[x][y][2] += dfs(x - 1, y - 1, 2)
        count[x][y][2] += dfs(x, y - 1, 1)
        count[x][y][2] += dfs(x-1, y, 3)
        return count[x][y][2]
    if d == 3:
        count[x][y][3] += dfs(x-1,y-1,2)
        count[x][y][3] += dfs(x-1, y, 3)
    return count[x][y][d]


dfs(N-1,N-1,2)
print(count[N-1][N-1][2])