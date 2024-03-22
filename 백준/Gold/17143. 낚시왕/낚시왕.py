from collections import deque
R, C, M = map(int , input().split(" "))

board = [[0 for _ in range(C)] for _ in range(R)]
que = deque()
def direct(d):
    if d==1:
        return (-1,0)
    if d ==2:
        return (1,0)
    if d==3:
        return (0,1)
    if d==4:
        return (0,-1)
ans =0
for i in range(M):
    r ,c ,s ,d ,z = map(int ,input().split(" "))
    que.append((r-1,c-1,s,d,z,0))
    board[r-1][c-1] = z
for i in range(C):
    newBoard = [[0 for _ in range(C)] for _ in range(R)]
    for j in range(R):
        if board[j][i] != 0:
            ans += board[j][i]
            board[j][i] = 0
            break
    while(len(que) !=0 and que[0][5] == i):
        node = que.popleft()
        dic = node[3]
        n = direct(dic)
        count = node[2]
        nx = node[0]
        ny = node[1]
        if board[nx][ny] != node[4]:
            continue
        while count != 0:
            if 0 <= nx + n[0] < R and 0 <= ny + n[1] < C:
                nx = nx + n[0]
                ny = ny + n[1]
                count-=1
            else:
                if dic == 1:
                    dic = 2
                elif dic == 2:
                    dic =1
                elif dic ==3:
                    dic =4
                elif dic ==4:
                    dic =3
                n = direct(dic)

        if newBoard[nx][ny] == 0:
            newBoard[nx][ny] = node[4]
            que.append((nx, ny, node[2], dic, node[4], node[5] + 1))
        else:
            newBoard[nx][ny] = max(newBoard[nx][ny],node[4])
            que.append((nx, ny, node[2], dic, node[4], node[5] + 1))
    board = newBoard



print(ans)