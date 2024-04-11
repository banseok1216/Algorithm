N , M = map(int,input().split(" "))
board = [list(map(int,input().split(" "))) for _ in range(N)]
check = [[[0 for k in range(2)] for i in range(M)] for j in range(N)]
for i in range(N):
    for j in range(M):
        if j ==0 and i == 0:
            check[i][j][0] = board[i][j]
        elif i != 0 and j == 0:
            check[i][j][0]= board[i][j] + max(check[i-1][j][0],check[i-1][j][1])
        elif i == 0 and j !=0:
            check[i][j][0] = board[i][j] + check[i][j-1][0]
        else:
            check[i][j][0] = board[i][j] + max(check[i][j - 1][0],check[i-1][j][0],check[i-1][j][1])
    for j in range(M - 1, -1, -1):
        if i == 0:
            check[i][j][1] = check[i][j][0]
        if i != 0 and j == M-1:
            check[i][j][1]= board[i][j] +  max(check[i-1][j][1],check[i-1][j][0])
        elif i != 0 and j != M-1:
            check[i][j][1] = board[i][j] + max(check[i][j + 1][1],check[i-1][j][1],check[i-1][j][0])


print(max(check[N-1][M-1]))

