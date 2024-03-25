N = int(input())
board = list(map(int, input().split(" ")))
K = int(input())
check = min(K,len(board)-1)
start = 0
while K != 0 and start<check:
    find = max(board[start:check+1])
    if board[start] == find:
        start += 1
        check = min(start + K,N-1)
        continue
    for i in range(check,start,-1):
        if board[i] == find:
            temp = board[i]
            board[i] = board[i-1]
            board[i-1] = temp
            K -= 1
    start += 1
    check = min(start + K,N-1)
for i in board:
    print(i,end=" ")
