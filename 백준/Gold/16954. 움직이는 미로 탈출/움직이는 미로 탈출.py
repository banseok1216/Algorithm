import collections

board = []
dic_board = [set() for i in range(65)]
for i in range(8):
    board_list = list(input())
    for j in range(8):
        if board_list[j] == "#":
            count = 0
            while count + i < 8:
                if count in dic_board:
                    dic_board[count].add((count + i, j))
                else:
                    dic_board[count].add((count + i, j))
                count += 1
start = (7, 0, 0)
end = (0, 7)
check_board = [[[False for k in range(65)] for j in range(8)] for i in range(8)]
que = collections.deque()
que.append(start)
answer = 0
while que:
    x, y, count = que.popleft()
    if x == end[0] and y == end[1]:
        answer = 1
        break
    for direction in (-1, 0), (1, 0), (1, 1), (-1, 1), (-1, -1), (1, -1), (0, 0), (0, -1), (0, 1):
        nx = direction[0] + x
        ny = direction[1] + y
        if 0 > nx or nx >= 8 or 0 > ny or ny >= 8:
            continue
        if (nx, ny) in dic_board[count]:
            continue
        if (nx, ny) in dic_board[count+1]:
            continue
        if check_board[nx][ny][count]:
            continue
        check_board[nx][ny][count] = True
        que.append((nx, ny, count + 1))
print(answer)
