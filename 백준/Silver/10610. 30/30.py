import itertools
board = list(map(int,input()))
board.sort(reverse=True)
total= sum(board)
if total%3 != 0:
    print(-1)
else:
    if board[-1] != 0:
        print(-1)
    else:
        ans = ""
        for i in board:
            ans += str(i)
        print(int(ans))