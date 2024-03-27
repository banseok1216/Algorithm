from collections import deque

N, M = map(int, input().split(" "))
board = [list(map(int, input())) for _ in range(M)]
check = [[[10000000, 10000000] for _ in range(N)] for _ in range(M)]
queue = deque()
check[0][0][0] = 0
queue.append((0, 0,0))
while (len(queue) != 0):
    node = queue.popleft()
    x = node[0]
    y = node[1]
    cur = node[2]
    for direct in (0, 1), (1, 0), (0, -1), (-1, 0):
        nx = x + direct[0]
        ny = y + direct[1]
        if  nx>= 0 and nx < M and ny >= 0 and ny < N:
            if board[nx][ny] == 1:
                if check[nx][ny][1] > check[x][y][cur] + 1:
                    check[nx][ny][1] = check[x][y][cur] + 1
                    queue.append((nx,ny,1))
            else:
                if check[nx][ny][0] > check[x][y][cur]:
                    check[nx][ny][0] = check[x][y][cur]
                    queue.append((x + direct[0], y + direct[1],0))

print(check[M - 1][N - 1][0])
