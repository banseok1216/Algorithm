from collections import deque
import copy

board = []
hash_set = set()
que = deque()
zero = []
answer_board = "123456780"
answer = -1
puzzle = ""
for i in range(3):
    input_board = list(input().split(" "))
    for j in range(3):
        if input_board[j] == "0":
            zero = [i,j]
    puzzle += "".join(input_board)

que.append([zero[0], zero[1], puzzle, 0])
hash_set.add(puzzle)
while len(que) != 0:
    start_x, start_y, board, count = que.popleft()
    if board == answer_board:
        answer = count
        break
    for dir_x, dir_y in (-1, 0), (1, 0), (0, -1), (0, 1):
        nx = start_x + dir_x
        ny = start_y + dir_y
        if 0 <= nx < 3 and 0 <= ny < 3:
            copy_board = list(board)
            temp = copy_board[ny + nx * 3]
            copy_board[ny + nx * 3] = "0"
            copy_board[start_y + start_x * 3] = temp
            string_board = "".join(copy_board)
            if string_board not in hash_set:
                hash_set.add(string_board)
                que.append([nx, ny, string_board, count + 1])

print(answer)
