N, M = map(int, input().split(" "))
board = [10000000 for i in range(N+1)]
lst = []
for i in range(M):
    S,E,T = map(int,input().split(" "))
    lst.append((S,E,T))
board[1] = 0
check = False
for i in range(N):
    for S,E,T in lst:
        if board[E] > board[S]+T and board[S] != 10000000:
            board[E] = board[S]+T
            if i == N-1:
                check = True
if check == True:
    print(-1)
else:
    for i in range(2,len(board)):
        if board[i] == 10000000:
            print(-1)
        else:
            print(board[i])