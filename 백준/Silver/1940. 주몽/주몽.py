N = int(input())
M = int(input())

board = list(map(int, input().split(" ")))

board.sort()
pointerA = 0
pointerB = N - 1
answer = 0
while pointerA < pointerB:
    current_sum = board[pointerA] + board[pointerB]
    if current_sum == M:
        countA, countB = 1, 1
        while pointerA + 1 <= pointerB and board[pointerA] == board[pointerA + 1]:
            countA += 1
            pointerA += 1
        while pointerB - 1 >= pointerA and board[pointerB] == board[pointerB - 1]:
            countB += 1
            pointerB -= 1
        answer += countA * countB
        pointerA += 1
    elif current_sum < M:
        pointerA += 1
    else:
        pointerB -= 1
print(answer)