import math

N, M = map(int,input().split(" "))

board = [(list(input())) for _ in range(N)]
answer = -1
def firstDfs(x,y,xMul,yMul,ans):
    global answer
    if ans != "":
        square_root = math.sqrt(int(ans))
        if square_root == int(square_root):
            answer = max(answer, int(ans))
    if x < 0 or y < 0 or x >= N or y >= M:
        return
    firstDfs(x+xMul,y+yMul,xMul,yMul,ans+board[x][y])
def secondDfs(x,y,xMul,yMul,ans):
    global answer
    if ans != "":
        square_root = math.sqrt(int(ans))
        if square_root == int(square_root):
            answer = max(answer, int(ans))
    if x < 0 or y < 0 or x >= N or y >= M:
        return
    secondDfs(x-xMul,y+yMul,xMul,yMul,ans+board[x][y])
def thirdDfs(x,y,xMul,yMul,ans):
    global answer
    if ans != "":
        square_root = math.sqrt(int(ans))
        if square_root == int(square_root):
            answer = max(answer, int(ans))
    if x < 0 or y < 0 or x >= N or y >= M:
        return
    thirdDfs(x+xMul,y-yMul,xMul,yMul,ans+board[x][y])
def fourthDfs(x,y,xMul,yMul,ans):
    global answer
    if ans != "":
        square_root = math.sqrt(int(ans))
        if square_root == int(square_root):
            answer = max(answer, int(ans))
    if x < 0 or y < 0 or x >= N or y >= M:
        return
    fourthDfs(x-xMul,y-yMul,xMul,yMul,ans+board[x][y])

for i in range(N):
    for l in range(M):
        for j in range(N):
            for k in range(M):
                if j != 0 or k != 0:
                    fourthDfs(i,l,j,k,"")
                    firstDfs(i,l,j,k,"")
                    secondDfs(i,l,j,k,"")
                    thirdDfs(i,l,j,k,"")
                else:
                    square_root = math.sqrt(int(board[0][0]))
                    if square_root == int(square_root):
                        answer = max(answer, int(board[0][0]))
print(answer)