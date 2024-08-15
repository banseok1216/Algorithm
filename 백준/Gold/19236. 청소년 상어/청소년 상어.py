import copy
direction = {
    1: [-1, 0],
    2: [-1, -1],
    3: [0, -1],
    4: [1, -1],
    5: [1, 0],
    6: [1, 1],
    7: [0, 1],
    8: [-1, 1]
}
board_dic = {}
board = [[[] for j in range(4)] for i in range(4)]
for i in range(4):
    list_board = list(map(int, input().split(" ")))
    for j in range(4):
        board[i][j] = [list_board[j * 2], list_board[j * 2 + 1]]
        board_dic[list_board[j * 2]] = [i, j]
check = board[0][0]
shark = [0, 0, board[0][0][1], board[0][0][0]]
board_dic.pop(board[0][0][0])
board[0][0] = [0, 0]

answer = 0


def dfs(copy_board, copy_dic, copy_shark):
    global answer
    for i in range(1, 17):
        if i in copy_dic:
            x, y = copy_dic[i]
            num, dir_num = copy_board[x][y]
            nx = direction[dir_num][0] + x
            ny = direction[dir_num][1] + y
            while not (0 <= nx < 4) or not (0 <= ny < 4) or (
                    copy_shark[0] == nx and copy_shark[1] == ny):
                dir_num += 1
                if dir_num > 8:
                    dir_num = 1
                nx = direction[dir_num][0] + x
                ny = direction[dir_num][1] + y
            temp = copy_board[nx][ny]
            if temp[0] in copy_dic:
                copy_dic[temp[0]] = [x, y]
            copy_board[x][y] = temp
            copy_board[nx][ny] = [num, dir_num]
            copy_dic[i] = [nx, ny]

    shark_x = direction[copy_shark[2]][0] + copy_shark[0]
    shark_y = direction[copy_shark[2]][1] + copy_shark[1]
    while 0 <= shark_x < 4 and 0 <= shark_y < 4:
        if copy_board[shark_x][shark_y][0] == 0:
            shark_x += direction[copy_shark[2]][0]
            shark_y += direction[copy_shark[2]][1]
            continue
        back_board = copy.deepcopy(copy_board)
        back_board_dic = copy.deepcopy(copy_dic)
        back_shark = copy.deepcopy(copy_shark)
        back_shark = [shark_x, shark_y, back_board[shark_x][shark_y][1],
                      back_board[shark_x][shark_y][0] + back_shark[3]]
        back_board_dic.pop(back_board[shark_x][shark_y][0])
        back_board[shark_x][shark_y] = [0, 0]
        answer = max(answer, back_shark[3])
        dfs(back_board, back_board_dic, back_shark)
        shark_x += direction[copy_shark[2]][0]
        shark_y += direction[copy_shark[2]][1]

dfs(board, board_dic, shark)
print(answer)
