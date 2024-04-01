N = int(input())
M = int(input())
lst = list(map(int,input().split(" ")))
lst.sort()
board =[]
for i in range(N-1):
    board.append(lst[i+1] -lst[i])
board.sort()
ans =0
for i in range(len(board)-M+1):
    ans+=board[i]
print(ans)