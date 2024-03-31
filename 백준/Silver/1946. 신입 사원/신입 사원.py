C = int(input())
for _ in range(C):
    M = int(input())
    board = []
    for i in range(M):
        first , second = map(int,input().split(" "))
        board.append((first,second))
    board.sort()
    check = board[0][1]
    ans =0
    for i in range(M):
        if board[i][1] <= check:
            check = board[i][1]
            ans+=1
    print(ans)

