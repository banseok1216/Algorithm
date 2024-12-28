N , M , K = map(int, input().split(" "))
input_board = []
target_board = [[0 for _ in range(M)] for _ in range(N)]
for i in range(K):
    tmp = []
    R, C = map(int, input().split(" "))
    for j in range(R):
        tmp.append(list(map(int, input().split(" "))))
    input_board.append(tmp)
def exchange(b):
    n = len(b)
    m = len(b[0])
    rotated = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            rotated[j][n - 1 - i] = b[i][j]
    return rotated
def validate(x,y,b):
    global target_board
    for ix in range(len(b)):
        for iy in range(len(b[0])):
            nx, ny = x + ix, y+ iy
            if 0<=nx<N and 0<= ny< M:
                if b[ix][iy] == 1 and target_board[nx][ny] == 1:
                    return False
            else:
                return False
    return True

def simulate(b):
    global target_board
    #4
    for k in range(4):
        if k != 0:
            b = exchange(b)
        for x in range(N):
            #5
            for y in range(M):
                    if validate(x,y,b):
                        for ix in range(len(b)):
                            for iy in range(len(b[0])):
                                nx, ny = x + ix, y+ iy
                                target_board[nx][ny] |=  b[ix][iy]
                        return


for i in range(K):
    simulate(input_board[i])
answer = 0
for i in range(N):
    for j in range(M):
        if target_board[i][j] == 1:
            answer += 1
print(answer)