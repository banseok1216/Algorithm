#최단 경로 에 있는 손님 우선 순위 행 ,열
from collections import deque

N,M,K = map(int,input().split(" "))
board = [list(map(int,input().split(" "))) for i in range(N)]
taxiX , taxiY = map(int,input().split(" "))
taxiX -=1
taxiY-=1
list1 = []
for i in range(M):
    a,b,c,d = map(int, input().split(" "))
    board[a-1][b-1] = -1
    list1.append((a-1,b-1,c-1,d-1))
while(M != 0):
    checkBoard = [[False for i in range(N)] for j in range(N)]
    que = deque()
    que.append((taxiX,taxiY,0))
    check = -1
    find = []
    while(len(que) != 0):
        node = que.popleft()
        if node[2] >= K:
            continue
        if checkBoard[node[0]][node[1]]:
            continue
        if check == -1 and board[node[0]][node[1]] == -1:
            check = node[2]
        if check != -1:
            if node[2] == check and board[node[0]][node[1]] == -1:
                find.append((node[0],node[1],node[2]))
            else:
                continue
        checkBoard[node[0]][node[1]] = True
        for d in (-1,0),(1,0),(0,-1),(0,1):
            nodex = node[0]+d[0]
            nodey = node[1]+d[1]
            if N>nodex>=0 and N>nodey>=0 and board[nodex][nodey] != 1:
                que.append((nodex,nodey,node[2]+1))
    if check == -1:
        K = -1
        break
    else:
        find.sort()
        dest = find[0]
        board[dest[0]][dest[1]] = 0
        K -= dest[2]
        endX = 0
        endY = 0
        for i in list1:
            if i[0] == dest[0] and i[1] == dest[1]:
                endX = i[2]
                endY = i[3]
        checkBoard = [[False for i in range(N)] for j in range(N)]
        que = deque()
        que.append((dest[0], dest[1], 0))
        check = -1
        find = []
        while (len(que) != 0):
            node = que.popleft()
            if node[0] == endX and node[1] == endY:
                check = node[2]
                K+= node[2]
                M-=1
                taxiX, taxiY = node[0], node[1]
                break
            if node[2] >= K:
                continue
            if checkBoard[node[0]][node[1]]:
                continue
            checkBoard[node[0]][node[1]] = True
            for d in (-1, 0), (1, 0), (0, -1), (0, 1):
                nodex = node[0] + d[0]
                nodey = node[1] + d[1]
                if N > nodex >= 0 and N > nodey >= 0 and board[nodex][nodey] != 1:
                    que.append((nodex, nodey, node[2] + 1))
        if check == -1:
            K = -1
            break
print(K)