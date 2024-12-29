# 크기가 N X M 인 지도 오른쪽 동쪽 위 북 지도의 자표 r,c r, 북쪽으로부터 c 서쪽으로부터
# 주사위가 이동방향 한칸 굴러감 이동방향에 칸이 없다면 반대로 한다음 굴려감
# x,y에 있는 정수 B 비교 A>B 이동방향 90도 회전 A<B 반시계 90도 회전
# 위, 남, 바닥 , 북, 서 ,동
dice = [1, 5, 6, 2, 4, 3]
from collections import deque


# # 동쪽 구르면 이동
# [4,5,3,2,6,1]
# #서쪽으로 구르면
# [3,5,4,2,1,6]
# #북쪽으로
# [5,6,2,1,4,3]
# #남쪽으로
# dice = [1,5,6,2,4,3]
# [2,1,5,6,4,3]
#
# #90도 회전
# [1,3,6,4,5,2]
# #90도 반시계
# [1,4,6,3,2,5]


def c_dice(d, t):
    tmp = [0 for i in range(6)]
    if t == "E":  # 동쪽으로 굴리기
        tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5] = d[4], d[1], d[5], d[3], d[2], d[0]
    elif t == "W":  # 서쪽으로 굴리기
        tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5] = d[5], d[1], d[4], d[3], d[0], d[2]
    elif t == "S":  # 남쪽으로 굴리기
        tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5] = d[3], d[0], d[1], d[2], d[4], d[5]
    elif t == "N":  # 북쪽으로 굴리기
        tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5] = d[1], d[2], d[3], d[0], d[4], d[5]
    elif t == "R":  # 시계 방향 회전
        tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5] = d[0], d[5], d[2], d[4], d[1], d[3]
    elif t == "L":  # 반시계 방향 회전
        tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5] = d[0], d[4], d[2], d[5], d[3], d[1]
    return tmp

def position(s):
    if s == "E":
        return 0, 1
    if s == "S":
        return 1, 0
    if s == "W":
        return 0, -1
    if s == "N":
        return -1, 0


def change(p, r):
    if r == "R":
        if p == "E":
            return "S"
        if p == "S":
            return "W"
        if p == "W":
            return "N"
        if p == "N":
            return "E"
    if r == "L":
        if p == "E":
            return "N"
        if p == "S":
            return "E"
        if p == "W":
            return "S"
        if p == "N":
            return "W"
    if r == "B":
        if p == "E":
            return "W"
        if p == "S":
            return "N"
        if p == "W":
            return "E"
        if p == "N":
            return "S"


def bfs(sx, sy):
    global board
    s = set()
    queue = deque()
    queue.append((sx, sy))
    count = 0
    while queue:
        x, y = queue.pop()
        if (x, y) in s:
            continue
        else:
            s.add((x, y))
            count += 1
        for ix, iy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + ix, y + iy
            if 0 > nx or nx >= N or 0 > ny or ny >= M:
                continue
            else:
                if board[sx][sy] == board[nx][ny]:
                    queue.append((nx, ny))
    return count


N, M, K = map(int, input().split(" "))

board = []

for i in range(N):
    board.append(list(map(int, input().split(" "))))
x, y = 0, 0
answer = 0
pos = "E"
for i in range(K):
    ix, iy = position(pos)
    tmp_dice = c_dice(dice,pos)
    nx, ny = ix + x, iy + y
    if 0 > nx or nx >= N or 0 > ny or ny >= M:
        pos = change(pos, "B")
        ix, iy = position(pos)
        tmp_dice = c_dice(dice, pos)
        nx, ny = ix + x, iy + y
    dice = tmp_dice
    answer += board[nx][ny] * bfs(nx,ny)
    if dice[2] > board[nx][ny]:
        pos = change(pos, "R")
    if dice[2] < board[nx][ny]:
        pos = change(pos, "L")
    x , y = nx,ny

print(answer)
