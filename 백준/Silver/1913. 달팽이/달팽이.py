N = int(input())
target = int(input())
mat = [[0]*N for _ in range(N)]

x, y = int(N/2), int(N/2)   # 시작점 - 중앙
dx = [0, 1, 0, -1] #x, y 바꿔주기
dy = [1, 0, -1, 0]

n = 1 # N*N # 시작값
rx, ry = 0, 0
mat[x][y] = n
n += 1
if target == 1:
    rx, ry = int(N/2)+1, int(N/2)+1

for i in range(1, int(N/2)+1):    #loop 횟수
    if n == 2:
        nx, ny = x-1, y-1
    else:
        nx, ny = nx-1, ny-1
    
    step = i*2    #몇개 픽셀을 지날지   # 2, 4, 6, ... (N/2)+1
    for j in range(4):    #네번 (상하좌우)
        for k in range(step):
            nx = nx + dx[j]
            ny = ny + dy[j]
            mat[nx][ny] = n
            if n == target:
                rx, ry = nx+1, ny+1
            n += 1

for val in mat:
    print(*val)
print(rx, ry)