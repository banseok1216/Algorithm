N ,M = map(int,input().split(" "))
board = [list(input()) for _ in range(N)]
check = [[False for i in range(M)] for _ in range(N)]
ans = 0
fin = False
def dfs(x,y):
    check[x][y] = True
    global ans
    global fin
    if y == M-1:
        check[x][y] = True
        fin = True
        ans +=1
        return True
    for node in (-1,1),(0,1),(1,1):
        nx = x + node[0]
        ny = y +node[1]
        if nx>= 0 and nx < N and not check[nx][ny] and not fin:
            if board[nx][ny] == ".":
                dfs(nx,ny)
for i in range(N):
    fin = False
    dfs(i,0)
print(ans)