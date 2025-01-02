N, M = map(int, input().split(" "))
board = []
for _ in range(N):
    board.append(int(input()))
board.sort()
pointerA = 0
pointerB = 1
answer = 100000000000000000
while pointerB < N:
    if pointerA == pointerB:
        pointerB += 1
        continue
    sum =  board[pointerB] - board[pointerA]
    if sum < M:
        pointerB += 1
    elif sum == M:
        answer = min(answer, sum)
        break
    else:
        pointerA += 1
        answer = min(answer, sum)
print(answer)