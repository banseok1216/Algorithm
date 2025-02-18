from collections import deque

N , M = map(int, input().split(" "))

board = []

check = [[False for _ in range(N)] for _ in range(M)]
def bfs(i,j, t):
    q = deque()
    q.append((i,j))
    global check
    global board
    count = 0
    while q:
        (a,b) = q.popleft()
        if check[a][b]:
            continue
        check[a][b] = True
        count += 1
        for ix, iy in (-1,0), (1,0), (0,1), (0,-1):
            x = a + ix
            y = b + iy
            if 0 <= x < M and 0 <= y < N:
                if  check[x][y]:
                    continue
                if board[x][y] != t:
                    continue
                q.append((x,y))
    return count
for _ in range(M):
    board.append(list(input()))
ans = dict()
ans["B"] = 0
ans["W"] = 0
for i in range(M):
    for j in range(N):
        if check[i][j] :
            continue
        else:
            ans[board[i][j]] += pow(bfs(i,j,board[i][j]), 2)
print(str(ans["W"]) + " " + str(ans["B"]))