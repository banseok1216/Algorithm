N = int(input())
board = list(map(int,input().split(" ")))
K = int(input())
ans = 0
board.sort()
for i in range(len(board)):
    if i ==0 and board[i]>K:
        ans = (board[i] - 1) * (board[i] - 2) / 2
        ans -= (board[i] - K - 1) * (board[i] - K - 2) / 2
        ans -= (K - 1) * (K - 2) / 2
    if board[i]<K<board[i+1]:
        ans = (board[i+1] - board[i]-1) * (board[i+1] - board[i]-2) /2
        ans -= (board[i+1] - K-1) * (board[i+1] - K-2)/2
        ans -= (K-board[i] -1) * (K-board[i ] -2)/2
print(int(ans))

