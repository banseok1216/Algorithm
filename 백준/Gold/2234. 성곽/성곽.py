from collections import deque

N , M = map(int, input().split(" "))
board = [0 for i in range(N)]
countBoard = [[(0,0) for i in range(N)] for j in range(M)]
check = [[False for i in range(N)] for j in range(M)]
count2 = 0
count3 = 0
for i in range(M):
    board[i] = list(map(int, input().split(" ")))

def find(i):
    if i == 0:
        return 0,-1
    if i == 1:
        return -1,0
    if i == 2:
        return 0,1
    if i == 3:
        return 1,0

def countBFS(x,y,z):
    global board
    global countBoard
    global check
    global count2
    global answer1
    global count3
    q = deque()
    q2 = deque()
    q.append((x,y,z))
    while q:
        x , y, z = q.pop()
        num = board[x][y]
        if not check[x][y]:
            count2+=1
            check[x][y] = True
            q2.append((x,y))
        else:
            continue
        for i in range(4):
            if not num & (1 << i):
                nx , ny = find(i)
                if not check[nx + x][ny + y]:
                    q.append((nx + x , ny + y, z))
    while q2:
        x,y = q2.pop()
        countBoard[x][y] = (count2, answer1)

answer1 = 0
answer2 = 0
answer3 = 0
for i in range(M):
    for j in range(N):
        if not check[i][j]:
            answer1+= 1
            countBFS(i,j,0)
            answer2 = max(answer2, count2)
            count2 = 0
for i in range(M):
    for j in range(N):
        for x,y in (1,0),(-1,0),(0,1),(0,-1):
            if 0<= i + x < M and 0<= j+y < N:
                s1, c1  = countBoard[i][j]
                s2, c2 = countBoard[i + x][j+y]
                if c1 != c2:
                    answer3 = max(answer3, s1 + s2)
print(answer1)
print(answer2)
print(answer3)