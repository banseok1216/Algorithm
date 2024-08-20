import bisect

N = int(input())
board = list(map(int, input().split(" ")))
answer = []
for i in range(N):
    index = bisect.bisect_left(answer, board[i])
    if len(answer) == index:
        answer.append(board[i])
    else:
        answer[index] = board[i]
print(N- len(answer))

